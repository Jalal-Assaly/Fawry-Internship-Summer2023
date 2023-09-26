FROM openjdk:17
WORKDIR /app
COPY target/spring-boot-bookstore-application.war /app/spring-boot-bookstore-application.war
EXPOSE 8090

ENTRYPOINT ["java", "-jar", "spring-boot-bookstore-application.war"]
