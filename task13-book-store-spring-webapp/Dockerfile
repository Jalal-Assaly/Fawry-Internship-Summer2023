FROM openjdk:17
WORKDIR /app
COPY target/spring-boot-bookstore-application.jar /app/spring-boot-bookstore-application.jar
EXPOSE 8090

ENTRYPOINT ["java", "-jar", "spring-boot-bookstore-application.jar"]
