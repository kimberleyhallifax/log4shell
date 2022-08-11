FROM eclipse-temurin:latest

COPY . ./
RUN apt-get update \
    && apt-get install wget \
    && apt-get install -y maven \
    && apt-get install -y gcc \
    && apt-get install make \
    && mvn clean package \
    && wget http://sourceforge.net/projects/netcat/files/netcat/0.7.1/netcat-0.7.1.tar.gz \
    && tar -xzvf netcat-0.7.1.tar.gz \
    && cd netcat-0.7.1 \
    && ./configure --build=x86_64-unknown-linux-gnu \
    && make \
    && make install
#ENTRYPOINT [ "/bin/sh" ]
CMD java -cp target/log4j-rce-1.0-SNAPSHOT-all.jar log4j