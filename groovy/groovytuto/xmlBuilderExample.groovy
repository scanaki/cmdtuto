#!/usr/bin/env groovy
/* @file: xmlBuilderExample.groovy
 * @author: Thierry JEAN-LOUIS
 * @date: 22.11.2017
 * @desc: exemple d'utilisation d'un builder xml dans groovy
 */

import groovy.xml.MarkupBuilder

 class XmlBuilderExample {
	// class XmlExample
 	static void main(String[] args) {
		XmlBuilderExample xe = new XmlBuilderExample();
		// liste of film to add
      def mp = [1 : ['Enemy Behind', 'War, Thriller','DVD','2003', 
         'PG', '10','Talk about a US-Japan war'],
         2 : ['Transformers','Anime, Science Fiction','DVD','1989', 
         'R', '8','A scientific fiction'],
         3 : ['Trigun','Anime, Action','DVD','1986', 
         'PG', '10','Vash the Stam pede'],
         4 : ['Ishtar','Comedy','VHS','1987', 'PG', 
         '2','Viewable boredom ']] 
		// new xml builder
		def mB = new MarkupBuilder();

		println "\033[2J" // clear console screen
		mB.collection(shelf : 'New Arrivals') {
				movie(title : 'Enemy Behind') {
					type('War, Thirller')
					format('Divx')
					year('2017')
					rating('PG')
					stars(10)
					description('Talk about a US-Japan war')
				} /* __xml_node_movie__*/
		} /* __collection__ */
		println "";

		// adding some entries
		mB.collection(shelf : 'New Arrivals') {
			mp.each() {
				sd -> 
				movies(title : sd.value[0]) {
					type(sd.value[1])
					format(sd.value[2])
					year(sd.value[3])
					rating(sd.value[4])
					stars(sd.value[5])
					description(sd.value[6])
				} /* __xml_node_movie__*/
			} /* __map_mp__ */
		} /* __collection_mB__ */
		println "";
	} /* __main__ */
 } /* __XmlExample__ */
