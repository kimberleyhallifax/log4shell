FROM alpine:latest

COPY ../CVE .
RUN apk add openjdk11
EXPOSE 4444
CMD ["nc", "-n", "-l", "-v", "-p", "4444"]
