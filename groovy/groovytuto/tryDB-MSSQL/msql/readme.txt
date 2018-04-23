Ci-dessous, un bref rappel des commandes executees pour obtenier un serveur de base de donnees MS SQL : 

docker run -e 'ACCEPT_EULA=Y' -e 'SA_PASSWORD=stu77Aka' -p 1433:1433 --name 'TjlDB' -d microsoft/mssql-server-linux:latest
docker ps -a
docker images ls
docker container ls
docker nodes ls
echo $MSSQL_SA_PASSWORD
sudo docker exec -it sql1 /opt/mssql-tools/bin/sqlcmd    -S localhost -U SA -P '<YourStrong!Passw0rd>' \
sudo docker exec -it focused_pasteur /opt/mssql-tools/bin/sqlcmd  -S localhost -U SA -P 'stu77Aka' -Q 'ALTER LOGIN SA WITH PASSWORD="Mad2tu9U"'
docker exec -it focused_pasteur /opt/mssql-tools/bin/sqlcmd  -S localhost -U SA -P 'stu77Aka' -Q 'ALTER LOGIN SA WITH PASSWORD="Mad2tu9U"'
docker exec -it focused_pasteur "bash"
docker run -e 'ACCEPT_EULA=Y' -e 'SA_PASSWORD=stu77Aka' -p 1433:1433 --name 'TjlDB' -d microsoft/mssql-server-linux:latest

