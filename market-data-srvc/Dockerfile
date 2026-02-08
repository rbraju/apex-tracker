# Stage 1: Build
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# 1.1 Copy parent POM and shared libraries to cache dependencies
#COPY pom.xml ./pom.xml
#COPY shared-lib /app/shared-lib
#COPY market-data-srvc /app/market-data-srvc
COPY . .

# 1.1 Build only this service and its dependencies
RUN mvn clean package -pl market-data-srvc -am -DskipTests

# Stage 2: Run the app
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/market-data-srvc/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
