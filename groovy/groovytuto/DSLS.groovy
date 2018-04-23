#!/usr/bin/env groovy
/* @file: DSLS.groovy
 * @author: https://www.tutorialspoint.com/groovy/groovy_dsls.htm
 * @date: 25.11.2017
 * @version: 0.1
 * @desc: Groovy allows one to omit parentheses around the arguments of a method call for top-level statements. This is known as the "command chain" feature.
 */

class EmailDsl {  
   String toText 
   String fromText 
   String body 
	
  /* 
   * This method accepts a closure which is essentially the DSL. Delegate the 
   * closure methods to 
   * the DSL class so the calls can be processed 
   */ 
   
   def static make(closure) { 
      EmailDsl emailDsl = new EmailDsl() 
      // any method called in closure will be delegated to the EmailDsl class 
      closure.delegate = emailDsl
      closure() 
   }
   
  /* 
   * Store the parameter as a variable and use it later to output a memo 
   */ 
	
   def to(String toText) { 
      this.toText = toText 
   }
   
   def from(String fromText) { 
      this.fromText = fromText 
   }
   
   def body(String bodyText) { 
      this.body = bodyText 
   } 
}

EmailDsl.make { 
   to "Nirav Assar" 
   from "Barack Obama" 
   body "How are things? We are doing well. Take care" 
}
