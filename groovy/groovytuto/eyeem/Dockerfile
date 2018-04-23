# @file: Dockerfile
# @author: Thierry JEAN-LOUIS 
# @date: 07.12.2017 
# @version: 0.1
# @desc: Essai de creation base de donnees et application groovy

# -

# GROOVY APP
# Use official images as parent image
FROM groovy:alpine as GroovyApp

# Create a working directory /app
WORKDIR /app

# Copy the current directory to the working directory
ADD . /app

# Expose on port
EXPOSE 80

# Env name 
ENV NAME GroovyDocker

# Run commands like install requirements
# Run 

# Run app.groovy when container is lauched
CMD ["/usr/bin/env groovy" , "app.groovy"]

# -

# MS SQL Image
# FROM ubuntu:16.04 as MSDataServer
FROM microsoft/mssql-server-linux:latest as MSDataServer
# docker run -e 'ACCEPT_EULA=Y' -e 'SA_PASSWORD=stu77Aka' -p 1433:1433 --name 'TjlDB' -d microsoft/mssql-server-linux:latest

# Env name 
ENV NAME MSDataServer
ENV ACCEPT_EULA Y
ENV SA_PASSWORD stu77Aka

# Default SQL Port
EXPOSE 1433

# Run SQL server process
# CMD /opt/mssql/bin/sqlservr

# -
