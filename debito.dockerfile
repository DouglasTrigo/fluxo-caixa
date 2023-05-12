FROM openjdk:8

WORKDIR /app

COPY debito-0.0.1-SNAPSHOT.jar /app/debito-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/debito-0.0.1-SNAPSHOT.jar"]