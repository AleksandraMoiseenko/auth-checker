FROM openjdk:11
MAINTAINER stm
COPY target/auth-checker-1.0-SNAPSHOT.jar auth-checker-1.0.jar
ENTRYPOINT ["java","-jar","/auth-checker-1.0.jar"]