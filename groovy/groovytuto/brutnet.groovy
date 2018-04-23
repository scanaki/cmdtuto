#!/usr/bin/env groovy
/* @file: brutnet.groovy
 * @author: Thierry JEAN-LOUIS
 * @date: 21.11.2017
 * @desc: calcul salaire brut et salaire net
 */

 class Brutnet {
	
	public void convNetenBrut(def Net, int nbmois) {
		println "calcul du salaire net en salaire brut :"
		def resultbrut = ((Net * nbmois / 100) * 33) + (Net * nbmois)
		println "\033[0m>> \033[33m${resultbrut}\033[0m€ par an."
	}

	public void convBrutenNet(def Brut, int nbmois) {
		println "calcul du salaire net à partir du salaire brut :"
		def resultnet = (Brut - (Brut / 100) * 23) / nbmois
		println "\033[0m>> \033[33m${resultnet}\033[0m€ par mois (sur ${nbmois} mois)."
	}

	static void main(String[] args) {

		println "Calcul brut / net -- Attention : mauvaise approximation"
		def cal = new Brutnet() ; 

		def val = System.console().readLine "\033[0mQuel est votre salaire? (net ou brut) \033[36m";
		def value = val.toInteger(); 
		def valMois = System.console().readLine "\033[0mSur combien de mois? \033[36m";
		def nbMois = valMois.toInteger(); 

		if ( value < 20000) {
			cal.convNetenBrut(value, nbMois);
			}
		else {
			cal.convBrutenNet(value, nbMois);
		}
	}
 }

