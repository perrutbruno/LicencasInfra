FROM openjdk:14-alpine
VOLUME /tmp
COPY target/fornecedor-ms*.jar /spring/app.jar
EXPOSE 8010
EXPOSE 8012
EXPOSE 8080
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-Dspring.profiles.active=docker", "-jar", "/spring/app.jar"]
