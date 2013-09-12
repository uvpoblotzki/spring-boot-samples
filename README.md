# Spring Boot Example App

This App it a Spring Boot demo. It's a simple number guesser game. You can submit a guess using a
HTTP Post Request, e.g.:

    curl -X POST http://localhost:8080/guesser -d "guess=8"

The Result a JSON formatted result. The `hint` field gives a hint if your guess is too low or too high.

## Build and Run

To build an run you need maven. Execute the following command to build and start the server:

    mvn clean package
    java -jar target/spring-boot-1.0.0-SNAPSHOT.jar

