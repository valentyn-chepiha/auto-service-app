# Auto-service-app

## Description
Auto-service-app is the REST API server of a auto service application.
This project made to show my skills in Spring, Spring boot, Hibernate, REST, OOP, SOLID, data layers, liquibase.
In this project I used basic CRUD operations.
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
- Add your db configurations in resources/application.properties (username, password, url)
````-
    spring.datasource.url= CONNECTION STRING
    spring.datasource.username= USER NAME
    spring.datasource.password= PASSWORD
````
- Run project