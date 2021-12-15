FROM openjdk:latest
WORKDIR /app
COPY . /app
RUN javac /app/src/com/company/main.java
CMD ["java", "/app/src/com/compnay/main"]
