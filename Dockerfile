FROM maven:3.9.9-sapmachine-23 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn package -DskipTests
RUN echo "done"

FROM openjdk:23-slim
WORKDIR /app
LABEL maintainer="inggiskurnia32@gmail.com"
LABEL company="DTI Purwadhika"
COPY --from=build /app/target/*.jar app.jar
EXPOSE 3000
ENTRYPOINT ["java", "-jar", "app.jar"]