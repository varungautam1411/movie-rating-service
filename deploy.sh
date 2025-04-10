#!/bin/bash

# Build the application
mvn clean package

# Copy to EC2
scp -i "../ec2.pem" target/movie-rating-service-1.0.jar ec2-user@ec2-3-16-48-250.us-east-2.compute.amazonaws.com:/home/ec2-user/restApp
scp -i "../ec2..pem" src/main/resources/application.properties ec2-user@ec2-3-16-48-250.us-east-2.compute.amazonaws.com:/home/ec2-user/restApp/config/
