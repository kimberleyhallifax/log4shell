FROM eclipse-temurin:latest

RUN apt-get update \
    && apt-get install wget \
    && apt-get install -y gcc \
    && apt-get install make \
    && wget http://sourceforge.net/projects/netcat/files/netcat/0.7.1/netcat-0.7.1.tar.gz \
    && tar -xzvf netcat-0.7.1.tar.gz \
    && cd netcat-0.7.1 \
    && ./configure --build=x86_64-unknown-linux-gnu \
    && make \
    && make install
EXPOSE 4444
ENTRYPOINT ["nc", "-lvvp", "4444"]