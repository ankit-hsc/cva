#!/bin/bash
export JAVA_HOME=/opt/java/jre1.8.0_65/bin
export PATH=$JAVA_HOME:$PATH
echo $PATH
echo "Starting CVA UI application.."

java -jar file-demo-0.0.1.war -Dspring.config.location=application.properties &

