/* @file: app.groovy
 * @author: Thierry JEAN-LOUIS
 * @date: 26.10.2017
 * @desc: First groovy test with Docker
 */

 /* __class_app__ */
 class app {
 	static void main(String[] args) 
	{
		def gui = new guy();
		def date = new Date();
		def sample = "Ho my gods! This is working!";
		def phrase = sample.center(50);
		def arguments = [];
		def habitants = [Pamela : 36, Thierry : 37, Aya : 13];

		for(String i in args) {
			arguments.add(i);
		}
		println(date.toString());
		println("Hello."); 
		println(1..10);
		println(phrase);
		arguments.add("thierry"); 
		println(arguments)
		println(habitants.size());
		for ( personne in habitants ) {
			println(personne);
		}
      try {
         def arr = new int[3];
         arr[5] = 5;
      }catch(ArrayIndexOutOfBoundsException ex) {
         println("\033[36m=== Catching the Array out of Bounds exception ===\033[0m");
         println(ex.toString());
         println(ex.getMessage());
         println(ex.getStackTrace());  
         println("\033[36m==================================================\033[0m");
      } catch(Exception ex) {
         println("\033[36mCatching the exception\033[0m");
      } finally {
         println("\033[36mThe final block\033[0m");
      }
		
      println("\033[36mLet's move on after the exception\033[0m");
		gui.init();
	}
 }
 /* __class_app__ */

