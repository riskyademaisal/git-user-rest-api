FROM alpine:latest

RUN apk --no-cache add openjdk17

RUN addgroup -S spring && adduser -S spring -G spring

USER spring:spring

ARG JAR_FILE=*.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]