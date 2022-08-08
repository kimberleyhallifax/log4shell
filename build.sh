cd containers/exploit/
javac Exploit.java
cd ../CVE/
mvn clean package
cd ../..
docker-compose build