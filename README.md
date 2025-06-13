# JavaAssessment

# 📚 Library Membership System

This project is developed as part of an internal Java assessment project. It is a simple **Library Membership Management System** built using Spring Boot, Thymeleaf, PostgreSQL, and REST APIs.

---

## 🚀 Tech Stack

- ☕ **Java (Spring Boot Framework)**
- 🌐 **Thymeleaf (UI Layer)**
- 🐘 **PostgreSQL (Database)**
- 🔗 **RESTful APIs**

---

## 📌 Project Features

- Manage library members with the following fields:
  - `id` (UUID)
  - `name` (String)
  - `joinDate` (Date)
  - `issuedBooks` (Integer)
  - `active` (Boolean)

- REST API Endpoints:
  - `GET /members` - Fetch all members
  - `GET /member/{id}` - Fetch member by ID
  - `GET /members/active` - Fetch all active members
  - `POST /member` - Add a new member
  - `PUT /member/{id}` - Update existing member details

- Frontend UI is developed using Thymeleaf templates.

---

## 🏗️ Project Setup

### Prerequisites

- Java 17 or higher
- Maven
- PostgreSQL

### Database Configuration

Create a PostgreSQL database:

```bash
CREATE DATABASE library_db;
