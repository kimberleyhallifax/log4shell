FROM python:latest

COPY requirements.txt Exploit.class ./
RUN pip3 install -r requirements.txt

EXPOSE 8888
CMD python3 -m http.server 8888