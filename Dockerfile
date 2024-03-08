FROM openjdk:17-alpine
ADD app/target/app-0.0.1-SNAPSHOT.jar app-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "app-0.0.1-SNAPSHOT.jar"]