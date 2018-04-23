#!/usr/bin/env groovy
/* @file: xmlParserExample.groovy
 * @author: Thierry JEAN-LOUIS
 * @date: 22.11.2017
 * @desc: exemple de parser XML en groovy
 */

import groovy.xml.MarkupBuilder
import groovy.util.*

class XmlParserExample {
	// main function
	static void main(String[] args) {
		XmlParserExample xPe = new XmlParserExample();
		xPe.open("movies.xml");
		xPe.printAll();
		xPe.printMovies();
	} /* __main__ */

	// Variables
	private MarkupBuilder mB; 
	private XmlParser parser;
	private def doc;

	// Constructor
	XmlParserExample() {
		mB = new MarkupBuilder();
		parser = new XmlParser(); 
	} /* __constructor__ */

	// Methods
	void open(String fileName) {
		doc = parser.parse(fileName);
	}

	void printAll() {
		println "\033[32m" + doc + "\033[0m"
	}

	void printMovies() {
		doc.movie.each {
			bk ->
			println "-------------------------"
			print("[Movie]\tname : \033[36m")
			println "${bk['@title']}\033[0m"

			print("\ttype : \033[36m")
			println "${bk.type[0].text()}\033[0m"

			print("\tformat : \033[36m")
			println "${bk.format[0].text()}\033[0m"

			print("\tyear : \033[36m")
			println "${bk.year[0].text()}\033[0m"

			print("\trating : \033[36m")
			println "${bk.rating[0].text()}\033[0m"

			print("\tstars : \033[36m")
			println "${bk.stars[0].text()}\033[0m"

			print("\tdescription : \033[36m")
			println "${bk.description[0].text()}\033[0m"
		} /* __xml_doc__ */
	}  /* __printMovies__ */
} /* __class_XmlParserExample__ */
