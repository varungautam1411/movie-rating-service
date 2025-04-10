#!/bin/bash

APP_HOME="/home/ec2-user/restApp"
JAR_FILE="$APP_HOME/movie-rating-service-1.0.jar"
CONFIG_DIR="$APP_HOME/config"

java -jar $JAR_FILE \
    --spring.config.location=file:$CONFIG_DIR/application.properties
