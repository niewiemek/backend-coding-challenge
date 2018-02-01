# Intruduction
This is a simple Spring Boot application to save your personal expenses.

Requirements:
* Java 8
* MySQl 5.7.*
* Maven 3
* Gulp 3.9.1
* NPM 5.6.0
* Node 6.11.0

# Setting up

## Database Setup
Connect to your MySQL instance and do the following to create a database and a user.

``` 
mysql> CREATE DATABASE expenses;
Query OK, 1 row affected (0.00 sec)

mysql> CREATE USER 'expenses'@'localhost' IDENTIFIED BY 'YeM3Q7xfL2DyjCHN';
Query OK, 0 rows affected (0.00 sec)

mysql> GRANT ALL PRIVILEGES ON expenses . * TO 'expenses'@'localhost';
Query OK, 0 rows affected (0.00 sec)

mysql> FLUSH PRIVILEGES;
Query OK, 0 rows affected (0.00 sec)
```

## Build
### JavaScript
Front-End code should be built and deployed prior to running backend package. Use the ```gulp build-deploy``` task.
This will build minified JS files and deploy them in ```src/main/resources/static``` resources of the maven projecr.

### Java
User Maven to build.

```mvn clean package```

## Run
Application is built as a JAR file that you can run with:

```java -jar coding-challenge-0.0.1-SNAPSHOT.jar```

## Database setup
For purse of this project Hibernate can create database schema for you. To do this please set the following property to create on first start. It should be changed to none afterwards.

Create:
``` spring.jpa.hibernate.ddl-auto=create ```

Runtime:
``` spring.jpa.hibernate.ddl-auto=none ```

Please update DB connection string & credentials in ``` src/main/resources/application.properties ```

## Development Hints
Project Lombok is used to make the code a bit more friendly. Please install Project Lombok plugin into your IDE. You can check more details here: https://projectlombok.org/

#Further Development
#Input validation on front-end
#Date picker
#Login