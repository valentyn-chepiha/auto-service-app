# Auto-service-app

## Description
Auto-service-app is the REST API server of an auto-service application.
This project was made to show my skills in Spring, SpringBoot, Hibernate, REST, OOP, SOLID, data layers and Liquibase.
In this project, I used basic CRUD operations.
One-to-one, one-to-many, and many-to-many relationships are used in databases.

## Technologies
- Java 11
- Spring
- Spring boot
- Hibernate
- PostgreSQL
- Swagger 2
- Lombok
- Liquibase

## How to use
- First, run the project.
- Use "http://localhost:8080/swagger-ui/" to access the Swagger UI
- After that, you can perform REST API

## Setup
- Clone this project

### First way
- Add your db configurations in resources/application.properties (username, password, url)
````
    spring.datasource.url= CONNECTION STRING
    spring.datasource.username= USER NAME
    spring.datasource.password= PASSWORD
````
- Run project

### Second way
- Install Docker
- Add your configuration in .env
````
    POSTGRESDB_DB= DB SCHEME NAME
    POSTGRESDB_USERNAME= USER NAME
    POSTGRESDB_PASSWORD= USER PASSWORD
    
    POSTGRESDB_LOCAL_PORT= PORT OUTSIDE CONTAINER
    POSTGRESDB_DOCKER_PORT= PORT INSIDE CONTAINER
    
    SPRING_LOCAL_PORT= PORT OUTSIDE CONTAINER
    SPRING_DOCKER_PORT= PORT INSIDE CONTAINER
````
- Run command
````
    docker compose up
````
