FROM openjdk:17-jdk-slim-buster
MAINTAINER baeldung.com
COPY target/dockerized-file.jar dockerized-file.jar
ENTRYPOINT ["java","-jar","/dockerized-file.jar"]