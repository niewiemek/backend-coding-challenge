# Intruduction
This is a simple Spring Boot application to save your personal expenses.

Requirements:
* Java 8
* MySQl 5.7.*
* Maven

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
User Maven to build.

```mvn clean package```

## Run
Application is built as a JAR file that you can run with:

```java -jar expanses.jar```

## Development Hints
Project Lombok is used to make the code a bit more friendly. Please install Project Lombok plugin into your IDEA. You can check more details here: https://projectlombok.org/
