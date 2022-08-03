FROM alpine:latest

COPY CVE-2021-44228-Apache-Log4j-Rce .
RUN apk add openjdk11
EXPOSE 4444
CMD ["nc", "-n", "-l", "-v", "-p", "4444"]