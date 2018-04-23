/* @file: leslistes.groovy
 * @author: Thierry JEAN-LOUIS
 * @date: 13.11.2017
 * @desc: exemple d'implementation des listes chainees
 */

class leslistes {
	static void main(String[] args) { 
		List<String> liste = new ArrayList<String>();
		liste.add("Ceci est mon premier essai de liste chainee");
		liste.add("il y a t'il une chance que ca fonctionne au premier coup");
		liste.add("j'en suis pas sur mais il faut tenter");
		liste.add("reste plus qu'a faire un test!");

		//for(String phrase in liste) {
		for(String phrase : liste) {
			println("\033[32m" + "[" + "\033[34;47m" + phrase + "\033[0m"+ "\033[32m" + "]" + "\033[0m");
		}
	}
}
