FROM openjdk:8-jdk-alpine
RUN apk update && apk upgrade && apk add netcat-openbsd
RUN mkdir -p /usr/local/fbmessangerservice
ADD demochatbot.fbmessanger-0.0.1-SNAPSHOT.jar /usr/local/fbmessangerservice
ADD run.sh run.sh
RUN chmod +x run.sh
CMD ./run.sh