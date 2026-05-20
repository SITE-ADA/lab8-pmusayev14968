[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/Qr3lBpHw)

# University Course Management System

## Project Overview

This project is a microservices-based University Course Management System built with Spring Boot.

The system consists of two independent services:

* **student-service**
* **course-service**

The services communicate using **OpenFeign** and REST APIs.

### Features

#### Student Service

* Create student
* Update student
* Delete student
* Get all students
* Search students by name

#### Course Service

* Create course
* Update course
* Delete course
* Get all courses
* Enroll students into courses
* Validate course prerequisites before enrollment
* Retrieve students enrolled in a course
* Retrieve courses associated with a student using student name search

---

# Technologies Used

* Java 21
* Spring Boot 3
* Spring Web
* Spring Data JPA
* OpenFeign
* PostgreSQL
* Lombok
* Swagger / OpenAPI
* Maven

---

# Project Structure

```text
student-service/
course-service/
```

Each service has:

* Controller layer
* Service layer
* Repository layer
* DTOs
* Exception handling

---

# Running the Project

## 1. Clone the repository

```bash
git clone <repository-url>
cd <project-folder>
```

---

# Database Setup

Create two PostgreSQL databases:

```sql
CREATE DATABASE student_db;
CREATE DATABASE course_db;
```

---

# Configure application.properties

## student-service

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/student_db
spring.datasource.username=postgres
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
```

## course-service

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/course_db
spring.datasource.username=postgres
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update

student.service.base-url=http://localhost:8081
```

---

# Running Services

## Start student-service

```bash
cd student-service
mvn spring-boot:run
```

Runs on:

```text
http://localhost:8081
```

---

## Start course-service

```bash
cd course-service
mvn spring-boot:run
```

Runs on:

```text
http://localhost:8082
```

---

# Swagger URLs

## Student Service

```text
http://localhost:8081/swagger-ui.html
```

or

```text
http://localhost:8081/swagger-ui/index.html
```

## Course Service

```text
http://localhost:8082/swagger-ui.html
```

or

```text
http://localhost:8082/swagger-ui/index.html
```

---

# API Endpoints

# Student Service

## Create Student

```http
POST /api/v1/students
```

Request:

```json
{
  "firstName": "John",
  "lastName": "Smith",
  "email": "john@example.com",
  "age": 21
}
```

---

## Get All Students

```http
GET /api/v1/students
```

---

## Search Students By Name

```http
GET /api/v1/students/search?name=john
```

---

# Course Service

## Create Course

```http
POST /api/v1/courses
```

Request without prerequisite:

```json
{
  "title": "Introduction to Programming",
  "code": "CS101",
  "credits": 5,
  "prerequisiteId": null
}
```

Request with prerequisite:

```json
{
  "title": "Advanced Java",
  "code": "CS401",
  "credits": 6,
  "prerequisiteId": 1
}
```

---

## Enroll Student

```http
POST /api/v1/courses/{courseId}/students/{studentId}
```

Example:

```http
POST /api/v1/courses/2/students/1
```

---

## Get Students of Course

```http
GET /api/v1/courses/{courseId}/students
```

---

## Search Courses By Student Name

```http
GET /api/v1/courses/students/search?name=john
```

Example response:

```json
[
  {
    "studentId": 1,
    "firstName": "John",
    "lastName": "Smith",
    "courses": [
      {
        "id": 2,
        "title": "Advanced Java",
        "code": "CS401",
        "credits": 6,
        "prerequisiteId": 1
      }
    ]
  }
]
```

---

# Prerequisite Validation

Courses may optionally contain a prerequisite course.

Before enrollment:

* the system validates prerequisites
* invalid enrollments are rejected

Example error:

```json
{
  "message": "Student must complete prerequisite course with id 1 before enrolling in course 5"
}
```

---

# Important Notes

* `student-service` owns student data
* `course-service` owns courses and enrollments
* Services communicate through OpenFeign
* Databases are separated for proper microservice architecture
* Enrollment validation prevents duplicate enrollments
* Course prerequisites are optional (`null` allowed)

---

# Testing

You can test the APIs using:

* Swagger UI
* Postman
* curl

Example curl request:

```bash
curl -X GET "http://localhost:8082/api/v1/courses"
```

---