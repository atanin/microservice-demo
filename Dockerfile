FROM openjdk:8
ADD target/demo.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]