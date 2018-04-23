/* @file: closure.groovy
 * @author: Thierry JEAN-LOUIS
 * @date: 13.11.2017
 * @desc: exemple de "closure". 
 */

 class Exemple {
 	
	static void main(String[] args) {
		def closure = { println "[\033[36mAppel d'un morceau de code ou methode anonyme.\033[0m]".center(100) }
		println("\033[33mDemarrage du programme d'exemple :\033[0m");
		closure.call();

		def clos = {param->println "Hello ${param}"};
		clos.call("World");

      def clos2 = {println "Hello ${it}"};
      clos2.call("Titi");

      def str1 = "Hello";
      def clos3 = {param -> println "${str1} ${param}"}
      clos3.call("Thierry");
		
      // We are now changing the value of the String str1 which is referenced in the closure
      str1 = "Welcome";
      clos3.call("World");
	}
 }
