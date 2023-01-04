FROM openjdk:17-jdk-alpine
ARG JAR_FILE=/target/net-price-calculator-*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080/tcp
ENTRYPOINT ["java","-jar","/app.jar"]
