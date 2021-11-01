FROM java:8

EXPOSE 8080

ADD target/weatherapp-0.0.1-SNAPSHOT.jar weatherapp-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-Dspring.profiles.active=dev","-jar","weatherapp-0.0.1-SNAPSHOT.jar"]