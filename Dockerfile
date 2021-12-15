FROM openjdk:latest
WORKDIR /app
COPY . .
CMD ["java","-jar", "out/artifacts/Projet_java_jar/Projet_java.jar"]
