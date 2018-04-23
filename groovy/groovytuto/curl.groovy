#!/usr/bin/env groovy
/* @file: curl.groovy
 * @author: Thierry JEAN-LOUIS
 * @date: 22.11.2017
 * @desc: Exemple d'utilisation de la commande curl
 */


// Url Eyeem pour récupération de la liste d'utilisateur
// https://www.eyeem.com/u/normanpaine/following

// commande systeme a utiliser cUrl
// i.e. curl https://www.eyeem.com/u/normanpaine/following
// https://www.eyeem.com/u/heathhlee/followers

/* __class_curleyeem__ */
class CurlEyeem {
	void run() {
		def process = ["curl", "https://www.eyeem.com/u/scanaki/following"].execute().text;
		println "==========================================="
		println "\033[34m" + process + "\033[0m"; 
		println "==========================================="
	}

	static void main(String[] args) {
		println "Running CurlEyeem..."; 
		CurlEyeem cEye = new CurlEyeem(); 

		cEye.run();
		println "End of CurlEyeem."
	}
}
/* __class_curleyeem__ */
