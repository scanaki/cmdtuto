#!/usr/bin/env groovy
/* @file: netThreadExample.groovy
 * @author: http://www.tothenew.com/blog/how-to-use-thread-pooling-using-groovy/
 * @date: 22.11.2017
 * @desc: How to use Thread-Pooling using Groovy
 */

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.Future

class Example {
	static void main(String[] args) {
		def myClosure = {num -> println "I Love Groovy ${num}"}
		def threadPool = Executors.newFixedThreadPool(4)
			try {
				List<Future> futures = (1..10).collect{num->
					threadPool.submit({->
							myClosure num } as Callable);
				}
				// recommended to use following statement to ensure the execution of all tasks.
				futures.each{it.get()}
			}finally {
				threadPool.shutdown()
			}

		Collection results = futures.collect{it.get()}
	}
}
