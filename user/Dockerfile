FROM openjdk:17-jdk-slim

ARG JAR_FILE=build/libs/user-service.jar
COPY ${JAR_FILE} user-service.jar

ENV SPRING_PROFILES_ACTIVE=prod

ENTRYPOINT ["java", "-Dspring.profiles.active=${SPRING_PROFILES_ACTIVE}", "-jar", "/user-service.jar"]
