FROM openjdk:8

WORKDIR /app

COPY saldo-0.0.1-SNAPSHOT.jar /app/saldo-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/saldo-0.0.1-SNAPSHOT.jar"]