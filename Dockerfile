FROM maven:3.6-jdk-8-slim
VOLUME /tmp
ADD /target/examples*.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
EXPOSE 50051
