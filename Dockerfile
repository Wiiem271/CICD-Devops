##use an openJDK Runtime as aparent image
FROM imagenarium/jdk-maven:17
ADD https://github.com/Wiiem271/dev/tree/main/target .
ENTRYPOINT ["java","-jar","tpAchatProject-1.0.jar"]