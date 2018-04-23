#!/usr/bin/env groovy
/* @file: annotations.groovy
 * @author: Thierry JEAN-LOUIS
 * @date: 15.11.2017
 * @desc: 
 */


/*-------------------------*/
@interface OnlyIf {
   Class value() 
}  

@OnlyIf({ number<=6 }) 
void Version6() {
   result << 'Number greater than 6' 
} 

@OnlyIf({ number>=6 }) 
void Version7() {
   result << 'Number greater than 6' 
}
/*-------------------------*/


/*-------------------------*/
/* __class_example__ */
class Example {

	static void main ( String[] args ) {
		def anno = { println "Hello world!" }
		anno.call();

		def user = new User( username: "Thierry", age: 37);
		println(user.age); 
		println(user.username);
	}
} /* __class_example__ */
/*-------------------------*/


/*-------------------------*/
/* __interface_simple__ */
@interface Simple {
	String str1() default "Hello my friend";
} /* __interface_simple__ */
/*-------------------------*/


/*-------------------------*/
/* __enum_dayofweek__ */
enum DayOfWeek { Lun, Mar, Mer, Jeu, Ven, Sam, Dim }
/* __enum_dayofweek__ */

/* __interface_dayofweek__ */
@interface Scheduled {
	DayOfWeek dayOfWeek()
} /* __interface_dayofweek__ */
/*-------------------------*/


/*-------------------------*/
@interface Simpliest {}
@Simpliest

/* __class_user__ */
class User {
	String username; 
	int age;
} /* __class_user__ */
/*-------------------------*/


/*-------------------------*/
/* __interface_exemple__ */
@interface Exemple {
	int status() 
} /* __interface_exemple__ */

//@Exemple(status = 1)
/*-------------------------*/
