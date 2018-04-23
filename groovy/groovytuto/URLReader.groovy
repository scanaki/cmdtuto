#!/usr/bin/env groovy
/* @file: URLReader.groovy
 * @author: https://stackoverflow.com/questions/2583757/groovy-multithreading
 * @date: 22.11.2017
 * @desc: groovy multithreading
 */

class URLReader implements Runnable {
	static void main(String[] args) {
		def reader = new URLReader( "http://www.google.com" )
			new Thread( reader ).start()
			while ( reader.valid == null )
			{
				Thread.sleep( 500 )
			}
		println "valid: ${reader.valid}"
	}

	def valid
	def url

	URLReader( url ) {
		this.url = url
	}

	void run() {
		try {
			def connection = url.toURL().openConnection()
				valid = ( connection.responseCode == 200 ) as Boolean
		} catch ( Exception e ) {
			println e.message
				valid = Boolean.FALSE
		}
	}
}
