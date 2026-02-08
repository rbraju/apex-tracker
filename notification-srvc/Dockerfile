# Stage 1: Build
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# 1.1 Copy parent POM and shared libraries to cache dependencies
#COPY pom.xml ./pom.xml
#COPY shared-lib /app/shared-lib
#COPY notification-srvc /app/notification-srvc
COPY . .

# 1.1 Build only this service and its dependencies
RUN mvn clean package -pl notification-srvc -am -DskipTests

# Stage 2: Run the app
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/notification-srvc/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
