#!/usr/bin/env groovy
def username = System.console().readLine 'What is your name? \033[33m'
println "\033[0mHello \033[36m${username}\033[0m"
