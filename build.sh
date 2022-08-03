cd CVE-2021-44228-Apache-Log4j-Rce/
javac Exploit.java
mvn clean package
docker build -t server . # Build python server docker image
cd ../marshalsec/
docker build -t japp . # Build ldap server docker image
cd ..