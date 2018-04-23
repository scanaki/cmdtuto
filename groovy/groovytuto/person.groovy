/* @file: person.groovy
 * @author: Thierry JEAN-LOUIS
 *	@date: 13.11.2017
 * @desc: abstract class
 */

class exemple {

	static void main (String[] args) {
		Habitants pers1 = new Habitants(); 
		pers1.name = "Thierry"
		pers1.setAdress("route de l'apprentissage");

		pers1.printInfos();
	}
}

abstract class Person {
	String name;

	public Person() { }
	abstract void printInfos(); 
}


class Habitants extends Person {
	String address; 

	public Habitants() { 
		super();
	}

	void setAdress(String addr) {
		this.address = addr;
	}

	void printInfos() {
	println("Hello, voici les infos voulues :");
	println("Prenom : " + name);
	println("Adresse : " + address);
	}
}
