set root=D:\ItuWorkShop\trunk\database\derby-server

cd %root%

set CLASSPATH=lib\derby.jar;lib\derbynet.jar

java -cp %CLASSPATH% org.apache.derby.drda.NetworkServerControl start -h localhost -p 51527
pause