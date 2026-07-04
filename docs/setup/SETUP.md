# Project Setup Guide

## Prerequisites

- Java 21
- Maven 3.9+
- PostgreSQL 17+
- pgAdmin 4
- Git
- VS Code / IntelliJ IDEA
- Postman

---

## Clone Repository

```bash
git clone https://github.com/basodes/inventory-management-app.git
```

---

## Navigate to Backend

```bash
cd inventory-management-app/backend
```

---

## Configure PostgreSQL

Create a database:

```sql
CREATE DATABASE inventory_db;
```

Update `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/inventory_db
spring.datasource.username=postgres
spring.datasource.password=YOUR_PASSWORD
```

---

## Run Application

```bash
mvn clean install
mvn spring-boot:run
```

---

Application URL

```
http://localhost:8080
```