cd containers/CVE/
javac Exploit.java
mvn clean package
cd ..
docker-compose build