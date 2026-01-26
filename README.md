# Back Office Application

## Overview
The Back Office is a program I'm developing using Spring Boot, designed to manage core business operations including **users**, **transactions**, **collections**, **inventory sorting**, and **deliveries**. The program will also support **employee authentication** and **administrator audits**. At a later stage, I will implement **POS functionality**.

This project is built with:
- **Java 17+**
- **Spring Boot 3.5.9**
- **PostgreSQL (Neon cloud or local)**
- **Maven** for build and dependency management
- **JUnit 5** for testing

---

## Features

### Existing Functionality
(Based on the client's initial request, before specifics were shared)
- **Users**: Manage user records (id, name, email, createdAt).
- **Transactions**: Track transactions linked to users.
- **Analytics**:
    - Total spend per user
    - Top spenders
    - User–transaction mapping

### Client's Specifications
- **Collections**
    - Number of items
    - Date of collection
    - Employee who handled collection

- **Sorting / Inventory**
    - Breakdown into specified products
    - Summary of units
    - Date
    - Verification status (good/bad)

- **Deliveries**
    - Date
    - Order number (id)
    - Quantity
    - Person who picks up the order

- **Employees**
    - Login functionality (I am thinking to use Spring Security)
    - Roles: `USER` and `ADMIN`
    - Admins can run audits and generate reports

---

## Architecture

```
src/main/java/com/thandekadior/backoffice/
├── App.java                  #spring boot entry point
├── model/                    #domain models (User, Transaction, Collection, Sorting, Delivery, Employee)
├── dao/                      #data access objects
├── service/                  #business logic services
├── controller/               #REST controllers
└── dto/                      #data transfer objects for clean JSON responses
```

---

## REST Endpoints

### Analytics
- `GET /analytics/totalSpend` → total spend per user
- `GET /analytics/topUsers?n=2` → top n spenders

### Collections
- `POST /collections` → add a new collection
- `GET /collections` → list all collections

### Sorting / Inventory
- `POST /sorting` → add sorting record
- `GET /sorting` → list all sorting records

### Deliveries
- `POST /deliveries` → add delivery record
- `GET /deliveries` → list all deliveries

### Authentication
- `POST /auth/login` → employee login
- `GET /admin/audit/summary` → audit summary (for ADMIN only)

---

## Setup

### Prerequisites
- Java 17 or higher
- Maven 3.8+
- PostgreSQL database

### Run locally
```bash
mvn clean install
mvn spring-boot:run
```

---

## Testing
Run the tests:
```
mvn test
```

---

## **Thank you!**
