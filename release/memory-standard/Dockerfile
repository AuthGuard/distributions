FROM openjdk:14-jdk-alpine

ARG JAR_FILE=target/memory-standard-standalone.jar


RUN mkdir /opt/authguard
RUN mkdir /opt/authguard/config
RUN mkdir /opt/authguard/keys

COPY config/ /opt/authguard/config
COPY keys/ /opt/authguard/keys

COPY ${JAR_FILE} /opt/authguard


EXPOSE 8080


ENTRYPOINT ["java", "-jar", "/opt/authguard/memory-standard-standalone.jar",\
            "--config", "/opt/authguard/config/application.yaml"]


