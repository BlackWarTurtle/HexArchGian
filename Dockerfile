FROM amazoncorretto:17-alpine-jdk
COPY target/hex-arch-gian-0.0.1-SNAPSHOT.jar hex-arch-gian-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-Dspring.profiles.active=docker-profile", "-jar","/hex-arch-gian-0.0.1-SNAPSHOT.jar"]