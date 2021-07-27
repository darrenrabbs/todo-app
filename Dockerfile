FROM openjdk:8-jdk-slim

MAINTAINER Darren Rabbitt "darrenrabbitt@yahoo.com"

EXPOSE 8080

WORKDIR /usr/local/bin

COPY ./target/todo-0.0.1-SNAPSHOT.jar todo.jar

CMD ["java", "-jar", "todo.jar" ]
