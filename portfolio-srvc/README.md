# Portfolio Service

A Spring Boot microservice for managing stock portfolios.

## Technology Stack
* Java 17
* Spring Boot 3
* Spring Data JPA
* PostgreSQL
* Docker

## Architecture



## Getting Started

### Prerequisites
* Docker Desktop
* Java 17

### Running the Application
1. Start the PostgreSQL database:
   ```bash
   docker-compose up -d
2. Run the Spring Boot application (using Maven or IntelliJ).

API Documentation
The API is secured using Basic Authentication.

Default Username: user

Default Password: (Check application logs on startup)

Endpoints
POST /api/v1/stocks: Add a new stock

GET /api/v1/stocks: Get all stocks

