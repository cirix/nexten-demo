FROM maven:3.6.3-openjdk-11-slim as nexten_service_builder
WORKDIR /usr/src/app
COPY . .
RUN mvn clean install spring-boot:build-image

FROM alpine:latest
RUN apk add --no-cache openjdk11-jre-headless  --repository=http://dl-cdn.alpinelinux.org/alpine/edge/community
COPY --from=nexten_service_builder /usr/src/app/target/nexten-demo.jar  nexten-demo.jar
EXPOSE 8080
ENTRYPOINT  ["java", "-jar", "nexten-demo.jar"]

