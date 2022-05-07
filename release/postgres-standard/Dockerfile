FROM openjdk:14-jdk-alpine

ARG JAR_FILE=target/postgres-standard-standalone.jar


RUN mkdir /opt/authguard
RUN mkdir /opt/authguard/config

COPY ${JAR_FILE} /opt/authguard


EXPOSE 8080


ENTRYPOINT ["java", "-jar", "/opt/authguard/postgres-standard-standalone.jar",\
            "--config", "/opt/authguard/config/application.yaml"]


