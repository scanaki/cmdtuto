#!/usr/bin/env groovy
/* @file: firstJSON.groovy
 * @author: Thierry JEAN-LOUIS
 * @date: 24.11.2017
 * version: 0.1
 * desc: first groovy sample
 */

import groovy.json.JsonSlurper
import groovy.json.JsonOutput

class App implements Runnable {
	static void main( String[] args ) {
		try {
			App ex = new App();	
			new Thread( ex ).start();
			while( ex.valid == null ) {
				Thread.sleep( 500 );
			}
		} catch ( Exception e ) {
			println "\033[31m" + e.message + "\033[0m"
		}
	}

	// private member
	private FirstJSON myFJSON ;
	private valid;

	// Constructor
	App () { myFJSON = new FirstJSON(); valid = Boolean.FALSE }

	// Public methods
	// Parse JSON data 
	public void test1() {
		//def parser = new JsonSlurper().setType(JsonParserType.LAX); 
		def parser = new JsonSlurper(); 
		def object = parser.parseText('{ "user" : "scanaki" , "password" : "titi", "id" : "832510" }'); 
		println object.user
		println object.password
		println object.id
	}

	// Parse JSON data 
	public void test2() {
		JsonSlurper parser = new JsonSlurper();
		Object lst = parser.parseText('{ "List" : [2, 3, 4, 5] }');
		lst.each {
			println "\033[36m" + it.key + " : \033[33m" + it.value + "\033[0m"
		}
	}

	// Parse JSON data 
	public void test3() {
		JsonSlurper parser = new JsonSlurper();
		def object = parser.parseText('''{"integer" : 12, "fraction" : 19.8, "Long" : 12e13}'''); 

		println object.integer ; 
		println object.fraction ; 
		println object.Long ; 

		object.each {
			println "\033[33m" + it + "\033[0m"
		}
	}

	// Create JSON data 
	public void test4() {
		println JsonOutput.toJson(["Name" : "Thierry", "Age" : 37 ]);
	}

	// Create JSON data 
	public void test5() {
		def output =  JsonOutput.toJson([new Students ( name:"Thierry", id:1 ), new Students( name:"Pam", id:2 )]);
		println(output);
	}

	// personal test
	public void mytest() {
		def process = ["curl", "https://www.eyeem.com/u/scanaki/following"].execute().text;
		
		//println object
		println process
	}

	// Thread run method
	public void run() {
		try {
			test1();
			test2();
			test3();
			test4();
			test5();
			//mytest();
			valid = Boolean.TRUE;
		} catch ( Exception e ) {
			println "\033[31m" + e.message + "\033[0m";
			valid = Boolean.FALSE;
		}
	}
}

class FirstJSON {
	// parser
	def parser;
	// dataOut
	def dataOut;

	FirstJSON() {
		try {
			parser = new JsonSlurper();
			dataOut = new JsonOutput(); 
		} catch ( Exception e ) {
			println e.message ; 
		}
	}

	void parse() {
	
	}

	void writeJSON() {
	
	}
}

class Students {
	def name;
	def id;
}

