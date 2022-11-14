FROM openjdk:slim

WORKDIR /app

Copy target/tpAchatProject-1.0.jar /app/tpAchatProject-1.0.jar
COPY src/main/ressources/application.properties /app
ENTRYPOINT ["java","-jar","tpAchatProject-1.0.jar", "-Dspring.config.location=", "/app/application.properties"]
