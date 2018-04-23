#!/usr/bin/env groovy
/* @file:
 * @author: https://www.tutorialspoint.com/groovy/groovy_database.htm
 * @date: 22.11.2017
 * @desc: Database Connection
 */

import java.sql.*;
import groovy.sql.Sql

class Example {
	static void main(String[] args) {
		// Creating a connection to the database
		def sql = Sql.newInstance('jdbc:mysql://localhost:3306/TESTDB', 'testuser', 'test123', 'com.mysql.jdbc.Driver');

		sql.connection.autoCommit = false;

		def sqlstr = """INSERT INTO EMPLOYEE(FIRST_NAME, LAST_NAME, AGE, SEX, INCOME) VALUES ('Mac', 'Mohan', 20, 'M', 2000)""";
		try {
			sql.execute(sqlstr);
			sql.commit()
				println("Successfully committed")
		}catch(Exception ex) {
			sql.rollback()
				println("Transaction rollback")
		}

		sql.close();
	}
}
