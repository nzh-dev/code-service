# Project: code-service

This is my example and training project that creates application called code-service.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

Note! Instruction have been verified only with Mac OS X 10.14.6.

### Prerequisites

* Java 8
* Git
* Gradle 5.3.1
* Docker container execution environment

### Installing

A step by step series of examples that tell you how to get a development env running

Clone the code-service project from GitHub

```
git clone https://github.com/nzh-dev/code-service.git
```

Create DB container

```
docker build -t nzh-dev-postgres .
```

Start DB container
```
docker-compose up
```

Start code-service application (Spring Boot)

```
gradle build && java -jar backend/build/libs/backend-0.0.1-SNAPSHOT.jar
```

code-service should now be up and running on your local environment.

Try to search codes using your browser or tool like [Postman](https://www.getpostman.com/).
```
http://localhost:8080/codes
```

Try to search code using id.
```
http://localhost:8080/codes/70
```

## Deployment

* Intended for local development and training purposes only.
* Not supposed to be used in production.

## Built With

* [Java](https://www.java.com/) - Programming Language
* [Gradle](https://gradle.org/) - Build Tool
* [Spring Boot](https://spring.io/projects/spring-boot) - Create stand-alone applications
* [ModelMapper](http://modelmapper.org/) - Object model mapper 
* [Hibernate](https://hibernate.org/) - Object Relational Mapping (ORM)
* [Postgres](https://www.postgresql.org/) - Relational Database
* [Docker](https://www.docker.com/) - Packaging Tool

## Acknowledgments

* Guides used during implementation
    * [callicoder - spring-boot-jpa-hibernate-postgresql-restful-crud-api-example](https://www.callicoder.com/spring-boot-jpa-hibernate-postgresql-restful-crud-api-example/)

## Development tips

Start and Stop container
```
docker-compose up
docker-compose down
```
Start code service - Spring Boot
```
gradle build && java -jar backend/build/libs/backend-0.0.1-SNAPSHOT.jar
```
List running containers
```
docker ps
```
Login to container
```
docker exec -it <container id or name> /bin/bash
```

## Todo list

List of features and ideas to be added to code-service project in the future.

* Tests
    * Unit tests
    * Integration tests
    * e2e tests
* Javadoc
* Swagger UI
* Linting
* REST API - CRUD functions
    * Read using code.value_id
    * Create code
    * Delete code
    * Update code
    * Create and Delete code_relations
* Logging
* Authentication
* Security
* Properties
* Create Frontend application
* Update Java 8 to Java 11
* Change data source from relational to something else (hierarchy)
* Implement the same logig with some other language and frameworks
* Implement the same solution to: AWS, Azure or GCP

## Done list

List of tasks completed from Todo list.

* 18.11.2019 
   * Create DTO Class
   * Map Hibernate domain objects to DTO Class
