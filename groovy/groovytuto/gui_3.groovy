#!/usr/bin/env groovy
/* https://www.tutorialspoint.com/groovy/groovy_builders.htm
 * Event Handlers
 * partie 3
 */

import groovy.swing.SwingBuilder 
import javax.swing.* 
import java.awt.* 

def myapp = new SwingBuilder()
  
def buttonPanel = {
   myapp.panel(constraints : BorderLayout.SOUTH) {
	
      button(text : 'Option A', actionPerformed : {
         println 'Option A chosen'
      })
		
      button(text : 'Option B', actionPerformed : {
         println 'Option B chosen'
      })
   }
}
  
def mainPanel = {
   myapp.panel(layout : new BorderLayout()) {
      label(text : 'Which Option do you want', horizontalAlignment : 
      JLabel.CENTER,
      constraints : BorderLayout.CENTER)
      buttonPanel()
   }
}
  
def myframe = myapp.frame(title : 'Tutorials Point', location : [100, 100],
   size : [400, 300], defaultCloseOperation : WindowConstants.EXIT_ON_CLOSE){
      mainPanel()
   }
	
myframe.setVisible(true)
