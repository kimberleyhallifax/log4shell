FROM eclipse-temurin:latest

COPY . ./
RUN apt-get update && apt-get install -y maven
RUN mvn clean package
CMD java -cp target/log4j-rce-1.0-SNAPSHOT-all.jar server