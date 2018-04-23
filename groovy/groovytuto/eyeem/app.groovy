#!/usr/bin/env groovy
/* @file: app.groovy
 * @author: Thierry JEAN-LOUIS
 * @date: 01.12.2017
 * @desc: eyeem connection
 */

/* Site à regarder pour plus tard :
 * https://www.mkyong.com/java/how-to-automate-login-a-website-java-example/
 * https://www.logicmonitor.com/support/terminology-syntax/scripting-support/access-a-website-from-groovy/
 * https://www.logicmonitor.com/support/datasources/data-collection-methods/webpage-httphttps-data-collection/
 */

 class App {
 	static void main(String[] args) {
		def eyeem_url = [ site : "https://www.eyeem.com", login : "https://www.eyeem.com/login", user : "https://www.eyeem.com/u/" ]; 
		def conn = eyeem_url.login.toURL().openConnection();
		def status =  ( conn.responseCode == 200 ) ? "success" : "failed" ;
		println status;
	}
 }
