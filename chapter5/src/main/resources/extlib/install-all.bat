echo "Install poison jars....."
call mvn install:install-file -Dfile=com/oracle/ojdbc6/11.2.0.3/ojdbc6.jar -DgroupId=com.oracle -DartifactId=ojdbc6 -Dversion=11.2.0.3 -Dpackaging=jar
call mvn install:install-file -Dfile=com/microsoft/sqlserver/sqljdbc4.jar -DgroupId=com.microsoft.sqlserver -DartifactId=sqljdbc4 -Dversion=4.0 -Dpackaging=jar