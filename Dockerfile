FROM openjdk:8-alpine
MAINTAINER Your Name <you@example.com>

ADD target/pokemon-0.0.1-SNAPSHOT-standalone.jar /pokemon/app.jar

EXPOSE 8080

CMD ["java", "-jar", "/pokemon/app.jar"]
