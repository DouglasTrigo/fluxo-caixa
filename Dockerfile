FROM openjdk:8

WORKDIR /app

ARG JAR_FILE
COPY ${JAR_FILE} /app/app.jar

ENTRYPOINT ["java","-jar","app.jar"]