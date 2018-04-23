#!/usr/bin/env groovy
/* @file: app.groovy
 * @author: Thierry JEAN-LOUIS
 * @date: 01.12.2017
 * @version: 0.1
 * @desc: Create and run an instance of SQL Server from docker image 
 *
 * URL : 
 * https://docs.microsoft.com/fr-fr/sql/linux/quickstart-install-connect-docker
 *
 * REAL COMMAND EXAMPLE STARTING A MS SQL SERVER : 
 *	sudo docker run -e 'ACCEPT_EULA=Y' -e 'MSSQL_SA_PASSWORD=<YourStrong!Passw0rd>' \
 *	-p 1401:1433 --name sql1 \
 *	-d microsoft/mssql-server-linux:2017-latest
 * 
 *                                                                                                                                                                            
 * CHANGING PASSWORD OF SA ADMINISTRATOR :
 *	sudo docker exec -it sql1 /opt/mssql-tools/bin/sqlcmd \
 *	-S localhost -U SA -P '<YourStrong!Passw0rd>' \
 *	-Q 'ALTER LOGIN SA WITH PASSWORD="<YourNewStrong!Passw0rd>"'
 * 
 *                                                                                                                                                                            
 * HOW TO CONNECT TO SQL SERVER FROM DOCKER CONTAINER :
 *	 sudo docker exec -it sql1 "bash"
 *                                                                                                                                                                            
 *	 from local docker container run the following command :
 *	 /opt/mssql-tools/bin/sqlcmd -S localhost -U SA -P '<YourNewStrong!Passw0rd>'
 * 
 *                                                                                                                                                                            
 * HOW TO CONNECT TO SQL SERVER FROM OUTSIDE OF DOCKER CONTAINER :
 *	 sqlcmd -S 10.3.2.4,1401 -U SA -P '<YourNewStrong!Passw0rd>'
 * 
 *                                                                                                                                                                            
 * def cmd = ['docker' , 'run -e "ACCEPT_EULA=Y" -e "SA_PASSWORD=yourStrong(!)Password" -p 1433:1433 -d microsoft/mssql-server-linux:latest'].execute().text;
 * def cmd = ['docker' , 'run -e "ACCEPT_EULA=Y" -e "SA_PASSWORD=yourStrong(!)Password" -p 1433:1433 --name "tjlDB" -d microsoft/mssql-server-linux:latest'].execute().text;
 */

/* les deux lignes ci-dessous proviennent du site suivant : 
 * https://stackoverflow.com/questions/42898097/accessing-mssql-database-from-groovy
 *
 * Actuellement cette version ne fonctionne pas
 */
@Grab(group='com.microsoft.sqlserver', module='mssql-jdbc', version='6.+')
@GrabConfig(systemClassLoader=true)

import java.sql.*;
import groovy.sql.Sql

 class TestDb {
 	static void main(String[] args){
		println "starting TestDb class ...";
		println "Creating connection to SQL Server database";
		//def sql = Sql.newInstance("jbdc:sqlserver://localhost:1433;Database=focused_pasteur;integratedSecurity=true", "com.microsoft.sqlserver.jdbc.SQLServerDriver");
		try {
			//def sql = Sql.newInstance("jbdc:sqlserver://localhost;Database=focused_pasteur;integratedSecurity=true", "com.microsoft.sqlserver.jdbc.SQLServerDriver");
			def sql = Sql.newInstance("jbdc:sqlserver://localhost:1433;databaseName=focused_pasteur;integratedSecurity=true", "com.microsoft.sqlserver.jdbc.SQLServerDriver");

			println "Test DB connection";
			sql.eachRow("select * from INVENTORY") {
				println it.spelling + " ${it.part_of_speech}"
			}
		} catch (Exception e) {
			println e.message;
		}
	}

 }
