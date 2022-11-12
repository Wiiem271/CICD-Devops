FROM openjdk:8-jdk-alpine
ADD https://github.com/Wiiem271/devops1/tree/main/target .
EXPOSE 8089
ENTRYPOINT ["java","-jar","tpAchatProject-1.0.jar"]
