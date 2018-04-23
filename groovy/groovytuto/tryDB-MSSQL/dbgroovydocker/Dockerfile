# Use an official Python runtime as a parent image
FROM groovy:alpine

# Set the working directory to /app
WORKDIR /app

# Copy the current directory contents into the container at /app
ADD . /app

# Install any needed packages specified in requirements.txt
#RUN pip install -r requirements.txt

# Make port 80 available to the world outside this container
EXPOSE 80

# Define environment variable
ENV NAME dbgroovydocker

# Run app.py when the container launches
CMD ["groovy", "app.groovy"]


# https://docs.microsoft.com/fr-fr/sql/linux/quickstart-install-connect-docker
# https://hub.docker.com/r/microsoft/mssql-server-linux/

# https://github.com/Microsoft/mssql-docker/blob/master/linux/mssql-server-linux/Dockerfile
# mssql-server-linux
# Maintainers: Microsoft Corporation (LuisBosquez and twright-msft on GitHub)
# GitRepo: https://github.com/Microsoft/mssql-docker

# Base OS layer: Latest Ubuntu LTS.
FROM ubuntu:16.04

# Default SQL Server TCP/Port.
EXPOSE 1433

# Copy all SQL Server runtime files from build drop into image.
COPY ./install /

# Run SQL Server process.
CMD /opt/mssql/bin/sqlservr
