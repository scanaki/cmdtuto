#!/bin/sh
///usr/bin/true; exec groovy -cp .. "$0"
/* @file: closure_2.groovy
 * @author: Thierry JEAN-LOUIS
 * @date: 15.11.2017
 * @desc: learning groovy - passing closure and variables example
 */

/* __class_example__ */
class Example {
	static void affiche(closure) {
		closure.call("\033[36mmy friend.\033[0m");
	}

	static void listexample() {
		def malist = [5, 4, 3, 2, 1, 0];
		malist.each { println it }

		// find all elements in list
		def val = malist.findAll { element -> element % 2 == 0 }
		println "\n\033[35m[recherche des chiffres pair]\033[0m";
		val.each { println "\033[31m${it}\033[0m" }
	}

	static void mapexample() {
		def map = ["TopicName" : "Maps", "TopicDescription" : "Methods in Maps"];
		// print all elements in a map collection
		println "\n\033[35mAffiche tous les elements contenus des maps :\033[0m"; 
		map.each { println it }
		map.each { println "\033[36m${it.key}\033[0m maps to: \033[36m${it.value}\033[0m" }
	}

	static void mapwithconditionexample() {
		def mp = ["TopicName" : "Maps", "TopicDescription" : "Methods in Maps"];
		def list = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];

		// print all elements in a map collection
		println "\n\033[35mAffichage des maps :\033[0m"; 
		mp.each { println it }
		mp.each { if (it.key =~ "Name" ) println "\033[36m${it.key}\033[0m maps to: \033[36m${it.value}\033[0m" }

		// print all elements in a list
		println "\n\033[35mAffichage de la liste pair :\033[0m"; 
		list.each { num -> if (num % 2 == 0) println num }
	}

	static void main(String[] args) {
		String str1 = "Welcome"; 
		def myclos = { println "$str1 ${it}" }

		//println "\033[2J"; // Clear screen
		myclos.call("World!");
		str1 = "Good bye";

		// Passing closure to another method 
		Example.affiche(myclos); 

		Example.listexample();
		Example.mapexample();
		Example.mapwithconditionexample();
	}

}

/* __class_example__ */
