#!/usr/bin/env groovy
/*
 * https://www.tutorialspoint.com/groovy/groovy_builders.htm
 * partie 4
 * Another variation of the above example is to define methods which can can act as handlers. In the following example we are defining 2 handlers of DisplayA and DisplayB.
 */

import groovy.swing.SwingBuilder 
import javax.swing.* 
import java.awt.* 

def myapp = new SwingBuilder()
  
def DisplayA = {
   println("Option A") 
} 

def DisplayB = {
   println("Option B")
}

def buttonPanel = {
   myapp.panel(constraints : BorderLayout.SOUTH) {
      button(text : 'Option A', actionPerformed : DisplayA) 
      button(text : 'Option B', actionPerformed : DisplayB)
   }
}  

def mainPanel = {
   myapp.panel(layout : new BorderLayout()) {
      label(text : 'Which Option do you want', horizontalAlignment : JLabel.CENTER,
      constraints : BorderLayout.CENTER)
      buttonPanel()
   }
}  

def myframe = myapp.frame(title : 'Tutorials Point', location : [100, 100],
   size : [400, 300], defaultCloseOperation : WindowConstants.EXIT_ON_CLOSE) {
      mainPanel()
   } 
	
myframe.setVisible(true) 
