#!/usr/bin/env groovy

// https://www.logicmonitor.com/support/terminology-syntax/scripting-support/access-a-website-from-groovy/

def NEW_LINE = System.getProperty("line.separator")
if (args.length < 1)
{
   println "Enter a URL as an argument."
   System.exit(-1)
}
def address = args[0]
def urlInfo = address.toURL()
println "===================================================================="
println "====== HEADER FIELDS FOR URL ${address}"
println "===================================================================="
def connection = urlInfo.openConnection()
headerFields = connection.getHeaderFields()
headerFields.each {println it}
