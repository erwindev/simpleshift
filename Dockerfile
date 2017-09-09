FROM java:8-jre
MAINTAINER Erwin Alberto

ENV SERVER_PORT 8080
EXPOSE 8080

ENV SPRING_CLOUD_CONFIG_URI=xxxx
ENV SPRING_PROFILE_ACTIVE=xxxx

RUN apt-get update
RUN mkdir /app
COPY ./build/libs/simpleshift.jar /app/

ENTRYPOINT ["java", "-jar", "/app/simpleshift.jar"]
