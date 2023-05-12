FROM openjdk:8

WORKDIR /app

COPY credito-0.0.1-SNAPSHOT.jar /app/credito-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/credito-0.0.1-SNAPSHOT.jar"]