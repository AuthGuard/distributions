FROM openjdk:14-jdk-alpine

ARG JAR_FILE=target/mongo-standard-0.11.0-standalone.jar

RUN mkdir /opt/authguard
RUN mkdir /opt/authguard/config
RUN mkdir /opt/authguard/keys

COPY ${JAR_FILE} /opt/authguard

ENTRYPOINT ["java", "-jar", "/opt/authguard/mongo-standard-0.11.0-standalone.jar",\
            "--config", "/opt/authguard/config/application.yaml"]

