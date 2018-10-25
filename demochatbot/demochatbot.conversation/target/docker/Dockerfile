FROM openjdk:8-jdk-alpine
RUN apk update && apk upgrade && apk add netcat-openbsd
RUN mkdir -p /usr/local/conversationservice
ADD demochatboot.conversation-0.0.1-SNAPSHOT.jar /usr/local/conversationservice
ADD run.sh run.sh
RUN chmod +x run.sh
CMD ./run.sh