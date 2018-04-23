#!/usr/bin/env groovy
/* @file: app.groovy
 * @author: Thierry JEAN-LOUIS
 * @date: 13.11.2017
 * @desc: First groovy test with Docker
 */

/* __class_app__ */
class app {

	static void main(String[] args) 
	{
		Connexion conn = new Connexion();
		conn.open("scanaki","test");
		conn.info();
	}
}
/* __class_app__ */

/* __class_connexion__ */
class Connexion {
	String _userName;
	String _pwd;

	void open(String userName, String password) {
		_userName = userName; 
		_pwd = password;
		// curl -v --insecure --anyauth --user username:password -c mycookie -H "Accept: application/json" -H "Content-Type: application/json" -X GET https://www.eyeem.com/login/
	}

	void close() {
	}

	void info() {
		println "initialisation de la connexion..."; 
		println "utilisateur : [" + "\033[36m" + _userName + "\033[0m" + "]"
	}
}
/* __class_connexion__ */
