# Auto-service-app

## Description
Auto-service-app is the REST API server of an auto-service application.
In this app you can add a customer and their cars. You can keep track of the work performed by repairmen and charge them a salary. The application also provides for the availability of a cumulative discount.

## Technologies
- Java 11
- Spring
- Spring boot
- Hibernate
- PostgreSQL
- Swagger 2
- Lombok
- Liquibase
- CRUD
- REST

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
