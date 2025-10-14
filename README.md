# 🌟 Employee Department Portal — Microservices Project

## 🚀 Project Overview
The **Employee Department Portal** is a **full-fledged microservices-based application** built with **Spring Boot**.  
It simulates a real-world enterprise application where users and departments are managed through multiple **independent services** communicating via **API Gateway**, **Feign Clients**, and registered with **Eureka Discovery Server**.  

This project demonstrates:  
- **Microservices architecture**  
- **CRUD operations**  
- **Validation and exception handling**  
- **JWT authentication and authorization**  
- **Service discovery & API routing**  
- **Centralized configuration**  
- **Distributed tracing (Sleuth + Zipkin)**  
- **Containerization using Docker Compose**  

---

## 🏗 Architecture Overview

```
                   ┌───────────────┐
                   │   API Gateway │
                   └───────┬───────┘
                           │
          ┌────────────────┴───────────────┐
          │                                │
  ┌───────────────┐                  ┌───────────────┐
  │ User Service  │                  │ Dept Service  │
  │   (MySQL)    │                  │   (MySQL)    │
  └───────────────┘                  └───────────────┘
          │                                │
          └───────────────┬────────────────┘
                          │
                  ┌───────────────┐
                  │ Eureka Server │
                  └───────────────┘
                          │
                  ┌───────────────┐
                  │ Config Server │
                  └───────────────┘
                          │
                  ┌───────────────┐
                  │ Zipkin/Sleuth │
                  └───────────────┘
```

> **Legend:**  
> - **API Gateway**: Routes all requests  
> - **Eureka Server**: Service discovery  
> - **Config Server**: Centralized properties  
> - **Zipkin/Sleuth**: Distributed tracing  

---

## 🛠 Services Overview

| Service | Description | Port |
|---------|------------|------|
| **User Service** | Handles user registration, retrieval, deletion, validation | 8081 |
| **Department Service** | Manages departments with CRUD operations | 8082 |
| **API Gateway** | Routes client requests to microservices | 8080 |
| **Eureka Server** | Service discovery registry | 8761 |
| **Config Server** | Centralized configuration for all services | 8888 |
| **Zipkin** | Traces requests across services | 9411 |

---

## ⚡ Features

### 1️⃣ User Service
- Register users with validation (name, email, password, age)  
- Retrieve all users / single user by ID  
- Delete users  
- Exception handling for invalid input  
- Ready for JWT authentication  

### 2️⃣ Department Service
- Add, update, delete, and retrieve departments  
- Connect with User Service using **Feign Client**  

### 3️⃣ API Gateway
- Centralized request routing  
- JWT validation at gateway level (next phase)  

### 4️⃣ Eureka Discovery Server
- Automatic service registration  
- Easy service discovery for all microservices  

### 5️⃣ Config Server
- Centralized configuration using Git or local properties  
- All services read configs dynamically  

### 6️⃣ Distributed Tracing
- **Sleuth + Zipkin** tracks request flow  
- Helps debug multi-service interactions  

### 7️⃣ Docker Integration
- Each service has its own Dockerfile  
- **Docker Compose** runs all services together  
- Environment variable support for DB and ports  

---

## 💻 API Endpoints

### User Service
| Method | Endpoint | Description |
|--------|---------|-------------|
| POST   | `/api/users/register` | Register a new user |
| GET    | `/api/users` | Get all users |
| GET    | `/api/users/{id}` | Get user by ID |
| DELETE | `/api/users/{id}` | Delete user by ID |

### Department Service
| Method | Endpoint | Description |
|--------|---------|-------------|
| POST   | `/api/departments` | Add new department |
| GET    | `/api/departments` | Get all departments |
| GET    | `/api/departments/{id}` | Get department by ID |
| PUT    | `/api/departments/{id}` | Update department |
| DELETE | `/api/departments/{id}` | Delete department |

> All requests pass through **API Gateway** for routing.

---

## ⚡ Getting Started

### Prerequisites
- Java 17+  
- MySQL  
- Maven  
- Docker & Docker Compose (optional)  
- IDE: IntelliJ / VS Code / Eclipse  

### Manual Run
1. Clone the repository:
```bash
git clone https://github.com/YourUsername/employee-department-portal.git
```
2. Create databases:
```sql
CREATE DATABASE user_db;
CREATE DATABASE department_db;
```
3. Update `application.properties` in each service with DB credentials  
4. Run **Eureka Server** → **Config Server** → **User Service** → **Department Service** → **API Gateway**  
5. Test APIs using **Postman**  

### Docker Compose
1. Navigate to `/docker` folder  
2. Build & run all services:
```bash
docker-compose up --build
```
3. Access services via **API Gateway** at `http://localhost:8080`  

---

## 📌 Next Steps
- Complete **JWT Authentication & Authorization**  
- Secure API Gateway routes  
- Add more **unit/integration tests**  
- Enhance **Swagger UI** for API documentation  

---

## 📖 License
This project is for **learning and demonstration purposes**.  
Feel free to **fork, adapt, and extend** for your own microservices projects.  

---

## ✨ Author
**Abhishek Rangnath Kanade**  
- Final Year BTech | MERN & Java & Spring Developer  
- Email: [your-email@example.com]  
- GitHub: [https://github.com/YourUsername](https://github.com/YourUsername)
