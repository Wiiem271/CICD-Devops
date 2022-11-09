FROM openjdk:8-jdk-alpine
ADD https://github.com/Wiiem271/devops1/tree/chaima/target .
ENTRYPOINT ["java","-jar","tpAchatProject-1.0.jar"]
