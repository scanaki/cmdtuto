#!/usr/bin/env groovy
/* @file: app.groovy
 * @author: Thierry JEAN-LOUIS
 * @date: 01.12.2017
 * @version: 0.1
 * @desc: Trying mysql connection with docker container and groovy
 */

/* @reference :
 *		* https://docs.docker.com/samples/library/mysql/
 *		* https://hub.docker.com/_/mysql/
 *		* https://www.tutorialspoint.com/groovy/groovy_database.htm
 *		* http://grails.asia/groovy-sql-database-connection-example
 *		* https://www.schibsted.pl/blog/groovy-sql-an-easy-way-to-database-scripting/
 */

// -- DOCKER COMMAND EXEMPLES --
// Starting a MySQL instance :
// docker run --name some-mysql -e MYSQL_ROOT_PASSWORD=my-secret-pw -d mysql:tag

// Connect to MySQL from an application in another Docker container
// docker run --name some-app --link some-mysql:mysql -d application-that-uses-mysql

// Connect to MySQL from the MySQL command line client
// docker run -it --link some-mysql:mysql --rm mysql sh -c 'exec mysql -h"$MYSQL_PORT_3306_TCP_ADDR" -P"$MYSQL_PORT_3306_TCP_PORT" -uroot -p"$MYSQL_ENV_MYSQL_ROOT_PASSWORD"'

// image can also be used as a client for non-Docker or remote MySQL instances:
// docker run -it --rm mysql mysql -hsome.mysql.host -usome-mysql-user -p

// Container shell access and viewing MySQL logs :
// docker exec -it some-mysql bash

// The MySQL Server log is available through Docker’s container log :
// docker logs some-mysql

// Using a custom MySQL configuration file :
// docker run --name some-mysql -v /my/custom:/etc/mysql/conf.d -e MYSQL_ROOT_PASSWORD=my-secret-pw -d mysql:tag

// Configuration without a cnf file
// docker run --name some-mysql -e MYSQL_ROOT_PASSWORD=my-secret-pw -d mysql:tag --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci

// If you would like to see a complete list of available options, just run:
// docker run -it --rm mysql:tag --verbose --help

// Creating database dumps :
// docker exec some-mysql sh -c 'exec mysqldump --all-databases -uroot -p"$MYSQL_ROOT_PASSWORD"' > /some/path/on/your/host/all-databases.sql

// ma commande pour lancer un server mysql depuis docker :
// docker run -e 'ACCEPT_EULA=Y' -e 'MYSQL_ROOT_PASSWORD=stu77Aka' -p 1433:1433 --name 'TjDB' -d mysql

// commande pour avoir un bash sur le container créé :
// docker exec -it TjDB bash

// commande pour s'y connecter : 
// docker run -it --link some-mysql:mysql --rm mysql sh -c 'exec mysql -h"$MYSQL_PORT_3306_TCP_ADDR" -P"$MYSQL_PORT_3306_TCP_PORT" -uroot -p"$MYSQL_ENV_MYSQL_ROOT_PASSWORD"'
// docker run -it --link TjDB:mysql --rm mysql sh -c 'exec mysql -h"localhost" -P"1433" -uroot -p"stu77Aka"'
// docker run -it --rm mysql mysql -hlocalhost -P"1433" -uroot -p

// se connecter depuis le serveur DB
// mysql -p

import java.sql.*; 
import groovy.sql.Sql;

class App {

	static void main(String[] args) {
		println "\033[32m" + "[Starting app...]" + "\033[0m"

		def db = [url : "jdbc:mysql://localhost:3306/TjDB", user : "root" , pwd: "stu77Aka", driver : "com.mysql.jdbc.Driver"];

		def sqlrequest = """CREATE TABLE EMPLOYEE ( 
         FIRST_NAME CHAR(20) NOT NULL,
         LAST_NAME CHAR(20),
         AGE INT,
         SEX CHAR(1),
         INCOME FLOAT )""" ;
			
		//def sqlcon = Sql.newInstance('jdbc:mysql://localhost:1433/TjDB', 'root', 'stu77Aka', 'com.mysql.jdbc.Driver');
		def sqlcon = Sql.newInstance(db.url, db.user, db.pwd, db.driver);
		sqlcon.execute(sqlrequest); 
		sqlcon.close();
		
		println "\033[32m" + "[App end.]" + "\033[0m"
	}
}
