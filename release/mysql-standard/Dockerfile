FROM openjdk:11

ARG JAR_FILE=target/mysql-standard-0.12.0-standalone.jar


RUN mkdir /opt/authguard
RUN mkdir /opt/authguard/config

COPY ${JAR_FILE} /opt/authguard


EXPOSE 8080


ENTRYPOINT ["java", "-jar", "/opt/authguard/mysql-standard-0.12.0-standalone.jar",\
            "--config", "/opt/authguard/config/application.yaml"]


