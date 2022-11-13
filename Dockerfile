FROM openjdk:8
ADD target/tpAchatProject-1.0.jar fournisseur.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "fournisseur.jar"]

