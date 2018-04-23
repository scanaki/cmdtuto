# @file: Dockerfile
# @author: Thierry JEAN-LOUIS 
# @date: 07.12.2017 
# @version: 0.1
# @desc: Essai de creation base de donnees et application groovy
#
# WORKING COMMAND 
# docker run -e 'ACCEPT_EULA=Y' -e 'SA_PASSWORD=stu77Aka' -p 1433:1433 --name 'MSDataServer' -d microsoft/mssql-server-linux:latest
# echo $MSSQL_SA_PASSWORD
#
# docker exec -it MSDataServer /opt/mssql-tools/bin/sqlcmd -S localhost -U SA -P '<YourStrong!Passw0rd>' \
# docker exec -it MSDataServer /opt/mssql-tools/bin/sqlcmd -S localhost -U SA -P 'stu77Aka' -Q 'ALTER LOGIN SA WITH PASSWORD="Mad2tu9U"'
#
# docker exec -it MSDataServer "bash"

# -
# MS SQL Image
# FROM ubuntu:16.04 as MSDataServer
FROM microsoft/mssql-server-linux:latest as MSDataServer
# Env name 
ENV NAME MSDataServer
ENV ACCEPT_EULA Y
ENV SA_PASSWORD stu77Aka
# Default SQL Port
EXPOSE 1433
# Run SQL server process
# CMD /opt/mssql/bin/sqlservr
CMD ["/opt/mssql-tools/bin/sqlcmd" , " -S localhost -U SA -P 'stu77Aka'"]
# -
