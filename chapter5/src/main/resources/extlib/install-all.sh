#!/bin/sh

echo "Install poison jars....."
mvn install:install-file -Dfile=com/oracle/ojdbc6/11.2.0.3/ojdbc6.jar -DgroupId=com.oracle -DartifactId=ojdbc6 -Dversion=11.2.0.3 -Dpackaging=jar

echo Ok

