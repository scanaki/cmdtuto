#!/usr/bin/env groovy
/* @file: connTest.groovy
 * @author: Thierry JEAN-LOUIS
 * @date: 25.11.2017
 * @version: 0.1
 * @desc: Test de connexion. (sans class)
 */

 static void main(String[] args)
 {
 	site = ["https://www.eyeem.com/login", "https://www.eyeem.com", "http://www.google.com"];

	try {
		site.each {
			conn = it.toURL().openConnection();
			status = (conn.responseCode == 200) ? "\033[32mConnexion OK\033[0m":"\033[31mConnexion KO\033[0m";
			println it + " : " + status;
		}
	} catch (Exception e) {
		println e.message;
	}
 }
