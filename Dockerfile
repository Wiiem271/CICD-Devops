FROM imagenarium/jdk-maven:17
ADD https://github.com/Wiiem271/dev/target .
ENTRYPOINT ["java","-jar","tpAchatProject-1.0.jar"]