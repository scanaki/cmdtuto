#!/usr/bin/env groovy

/* ==> Exemple provenant du site ci-dessous:
http://opensourceforgeeks.blogspot.fr/2014/08/executing-shell-commands-in-groovy.html
*/

class GroovyTest {
    public static void main(def args){
        //def url = 'http://mail.google.com';
        def url = 'https://www.eyeem.com/u/scanaki';
        println("Output : \n" + executeCurlCommand(url));
    }    
     
    def static executeCurlCommand(URL){
         
        def url = "curl " + URL;
        def proc = url.execute();
        def outputStream = new StringBuffer();
        proc.waitForProcessOutput(outputStream, System.err)
        return outputStream.toString();
         
         
    }
}
