# 🏢 Employee Department Portal

### Enterprise-Grade Microservices Architecture with Spring Boot

[![Java](https://img.shields.io/badge/Java-17+-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Docker](https://img.shields.io/badge/Docker-Ready-blue.svg)](https://www.docker.com/)
[![MySQL](https://img.shields.io/badge/MySQL-8.0+-blue.svg)](https://www.mysql.com/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

**A production-ready microservices application demonstrating modern cloud-native architecture patterns**

[Features](#-key-features) • [Architecture](#-architecture) • [Quick Start](#-quick-start) • [API Documentation](#-api-documentation) • [Screenshots](#-screenshots)

---

## 📋 Table of Contents

- [Overview](#-overview)
- [Key Features](#-key-features)
- [Architecture](#-architecture)
- [Technology Stack](#-technology-stack)
- [Services Overview](#-services-overview)
- [Database Schema](#-database-schema)
- [Getting Started](#-getting-started)
  - [Prerequisites](#prerequisites)
  - [Local Development Setup](#local-development-setup)
  - [Docker Deployment](#docker-deployment)
- [API Documentation](#-api-documentation)
- [Screenshots](#-screenshots)
- [Project Structure](#-project-structure)
- [Testing](#-testing)
- [Monitoring & Tracing](#-monitoring--tracing)
- [Roadmap](#-roadmap)
- [Contributing](#-contributing)
- [License](#-license)
- [Author](#-author)

---

## 🌟 Overview

The **Employee Department Portal** is a comprehensive microservices-based enterprise application built with Spring Boot that demonstrates modern cloud-native architecture patterns. This project simulates a real-world scenario where employee and department data are managed through multiple independent, scalable services.

### What Makes This Project Stand Out?

- ✅ **Complete Microservices Implementation** - Not just theory, fully functional services
- ✅ **Production-Ready Patterns** - Service discovery, API gateway, distributed tracing
- ✅ **Security First** - JWT authentication and authorization layer
- ✅ **Container Native** - Full Docker and Docker Compose support
- ✅ **Observable** - Integrated logging, monitoring, and distributed tracing
- ✅ **Well-Documented** - Comprehensive API docs and Postman collections

---

## 🚀 Key Features

<table>
<tr>
<td width="50%">

### Core Functionality
- 👥 **User Management** - Complete CRUD operations with validation
- 🏛️ **Department Management** - Hierarchical organization structure
- 🔐 **Authentication & Authorization** - JWT-based security
- ✅ **Input Validation** - Comprehensive validation layer
- 🚨 **Exception Handling** - Centralized error management

</td>
<td width="50%">

### Infrastructure
- 🌐 **API Gateway** - Centralized routing and load balancing
- 🔍 **Service Discovery** - Eureka-based auto-registration
- ⚙️ **Config Management** - Centralized configuration server
- 📊 **Distributed Tracing** - Sleuth + Zipkin integration
- 🐳 **Containerization** - Docker-ready deployment

</td>
</tr>
</table>

---

## 🏗 Architecture

### High-Level Architecture Diagram

```
┌─────────────────────────────────────────────────────────────────┐
│                         CLIENT LAYER                             │
│                  (Web/Mobile/Postman/etc.)                       │
└────────────────────────────┬────────────────────────────────────┘
                             │
                             ▼
                    ┌────────────────┐
                    │                │
                    │  API GATEWAY   │◄──── JWT Validation
                    │   Port: 8080   │
                    │                │
                    └────────┬───────┘
                             │
                ┌────────────┴────────────┐
                │                         │
                ▼                         ▼
       ┌─────────────────┐      ┌─────────────────┐
       │                 │      │                 │
       │  USER SERVICE   │      │  DEPT SERVICE   │
       │   Port: 8081    │◄────►│   Port: 8082    │
       │                 │ Feign│                 │
       └────────┬────────┘      └────────┬────────┘
                │                         │
                ▼                         ▼
         ┌──────────┐              ┌──────────┐
         │  MySQL   │              │  MySQL   │
         │ user_db  │              │ dept_db  │
         └──────────┘              └──────────┘
                │                         │
                └─────────┬───────────────┘
                          │
          ┌───────────────┴───────────────┐
          │                               │
          ▼                               ▼
┌──────────────────┐           ┌──────────────────┐
│                  │           │                  │
│  EUREKA SERVER   │           │  CONFIG SERVER   │
│   Port: 8761     │           │   Port: 8888     │
│                  │           │                  │
└──────────────────┘           └──────────────────┘
          │
          ▼
┌──────────────────┐
│                  │
│  ZIPKIN TRACING  │
│   Port: 9411     │
│                  │
└──────────────────┘
```

### Architecture Highlights

- **API Gateway Pattern** - Single entry point for all client requests
- **Service Registry** - Dynamic service discovery with Eureka
- **Inter-Service Communication** - Feign clients for declarative REST calls
- **Distributed Configuration** - Externalized config management
- **Observability** - Request tracing across service boundaries

---

## 💻 Technology Stack

### Backend Framework
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Spring Cloud](https://img.shields.io/badge/Spring%20Cloud-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)

### Database
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)

### DevOps & Tools
![Docker](https://img.shields.io/badge/Docker-2CA5E0?style=for-the-badge&logo=docker&logoColor=white)
![Maven](https://img.shields.io/badge/apache_maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=Postman&logoColor=white)

### Key Dependencies

| Technology | Purpose | Version |
|-----------|---------|---------|
| Spring Boot | Core Framework | 3.x |
| Spring Cloud Gateway | API Gateway | 4.x |
| Spring Cloud Netflix Eureka | Service Discovery | 4.x |
| Spring Cloud Config | Configuration Management | 4.x |
| Spring Cloud Sleuth | Distributed Tracing | 3.x |
| OpenFeign | HTTP Client | 4.x |
| Spring Data JPA | Data Access Layer | 3.x |
| Spring Security | Authentication/Authorization | 6.x |
| JWT | Token-based Auth | 0.11.x |
| Zipkin | Tracing UI | 2.x |
| MySQL Connector | Database Driver | 8.x |
| Lombok | Code Generation | 1.18.x |
| Validation API | Input Validation | 3.x |

---

## 🎯 Services Overview

<table>
<thead>
<tr>
<th>Service</th>
<th>Description</th>
<th>Port</th>
<th>Database</th>
<th>Key Features</th>
</tr>
</thead>
<tbody>
<tr>
<td><strong>🚪 API Gateway</strong></td>
<td>Entry point for all client requests, handles routing and load balancing</td>
<td>8080</td>
<td>-</td>
<td>Request routing, JWT validation, Rate limiting</td>
</tr>
<tr>
<td><strong>🔍 Eureka Server</strong></td>
<td>Service registry for dynamic service discovery</td>
<td>8761</td>
<td>-</td>
<td>Service registration, Health checks, Load balancing</td>
</tr>
<tr>
<td><strong>⚙️ Config Server</strong></td>
<td>Centralized configuration management</td>
<td>8888</td>
<td>-</td>
<td>External configs, Environment profiles, Dynamic refresh</td>
</tr>
<tr>
<td><strong>👤 User Service</strong></td>
<td>Manages user accounts and authentication</td>
<td>8081</td>
<td>user_db</td>
<td>User CRUD, Validation, Password encryption</td>
</tr>
<tr>
<td><strong>🏛️ Department Service</strong></td>
<td>Handles department and organizational structure</td>
<td>8082</td>
<td>dept_db</td>
<td>Department CRUD, User association, Feign integration</td>
</tr>
<tr>
<td><strong>📊 Zipkin</strong></td>
<td>Distributed tracing and monitoring</td>
<td>9411</td>
<td>-</td>
<td>Request tracing, Performance monitoring, Service dependencies</td>
</tr>
</tbody>
</table>

---

## 🗄 Database Schema

### Entity Relationship Diagram

*[📸 Screenshot: ER Diagram showing User and Department entities with relationships]*

### User Entity

```sql
CREATE TABLE users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    age INT CHECK (age >= 18),
    department_id BIGINT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (department_id) REFERENCES departments(id)
);
```

### Department Entity

```sql
CREATE TABLE departments (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL UNIQUE,
    code VARCHAR(20) NOT NULL UNIQUE,
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
```

---

## 🚀 Getting Started

### Prerequisites

Ensure you have the following installed:

- ☕ **Java JDK 17+** - [Download](https://www.oracle.com/java/technologies/downloads/)
- 🔧 **Maven 3.8+** - [Download](https://maven.apache.org/download.cgi)
- 🐬 **MySQL 8.0+** - [Download](https://dev.mysql.com/downloads/)
- 🐳 **Docker & Docker Compose** (Optional) - [Download](https://www.docker.com/products/docker-desktop/)
- 💡 **IDE** - IntelliJ IDEA / VS Code / Eclipse

### Local Development Setup

#### Step 1: Clone the Repository

```bash
git clone https://github.com/YourUsername/employee-department-portal.git
cd employee-department-portal
```

#### Step 2: Database Setup

```sql
-- Connect to MySQL
mysql -u root -p

-- Create databases
CREATE DATABASE user_db;
CREATE DATABASE department_db;

-- Create user and grant privileges
CREATE USER 'appuser'@'localhost' IDENTIFIED BY 'password123';
GRANT ALL PRIVILEGES ON user_db.* TO 'appuser'@'localhost';
GRANT ALL PRIVILEGES ON department_db.* TO 'appuser'@'localhost';
FLUSH PRIVILEGES;
```

#### Step 3: Configure Application Properties

Update `application.properties` or `application.yml` in each service:

**User Service** (`user-service/src/main/resources/application.properties`):
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/user_db
spring.datasource.username=appuser
spring.datasource.password=password123
spring.jpa.hibernate.ddl-auto=update
server.port=8081
eureka.client.service-url.defaultZone=http://localhost:8761/eureka
```

**Department Service** (`dept-service/src/main/resources/application.properties`):
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/department_db
spring.datasource.username=appuser
spring.datasource.password=password123
spring.jpa.hibernate.ddl-auto=update
server.port=8082
eureka.client.service-url.defaultZone=http://localhost:8761/eureka
```

#### Step 4: Start Services (in order)

```bash
# 1. Start Eureka Server
cd eureka-server
mvn spring-boot:run

# 2. Start Config Server (in new terminal)
cd config-server
mvn spring-boot:run

# 3. Start User Service (in new terminal)
cd user-service
mvn spring-boot:run

# 4. Start Department Service (in new terminal)
cd dept-service
mvn spring-boot:run

# 5. Start API Gateway (in new terminal)
cd api-gateway
mvn spring-boot:run

# 6. Start Zipkin (in new terminal)
cd zipkin-server
mvn spring-boot:run
```

#### Step 5: Verify Services

- Eureka Dashboard: http://localhost:8761
- API Gateway: http://localhost:8080
- Zipkin UI: http://localhost:9411

*[📸 Screenshot: Eureka Dashboard showing all registered services]*

### Docker Deployment

#### Option 1: Using Docker Compose (Recommended)

```bash
# Navigate to project root
cd employee-department-portal

# Build and start all services
docker-compose up --build

# Run in detached mode
docker-compose up -d

# View logs
docker-compose logs -f

# Stop all services
docker-compose down
```

*[📸 Screenshot: Docker containers running successfully]*

#### Option 2: Individual Docker Containers

```bash
# Build each service
docker build -t user-service:latest ./user-service
docker build -t dept-service:latest ./dept-service
docker build -t api-gateway:latest ./api-gateway
docker build -t eureka-server:latest ./eureka-server

# Run with Docker network
docker network create microservices-network
docker run -d --name eureka --network microservices-network -p 8761:8761 eureka-server:latest
docker run -d --name user-service --network microservices-network -p 8081:8081 user-service:latest
# ... (continue for other services)
```

---

## 📡 API Documentation

### Access Points

All API requests should be routed through the **API Gateway** at `http://localhost:8080`

### User Service Endpoints

#### 1. Register New User

```http
POST /api/users/register
Content-Type: application/json

{
  "name": "John Doe",
  "email": "john.doe@example.com",
  "password": "SecurePass123!",
  "age": 28,
  "departmentId": 1
}
```

**Response:**
```json
{
  "id": 1,
  "name": "John Doe",
  "email": "john.doe@example.com",
  "age": 28,
  "departmentId": 1,
  "createdAt": "2025-10-14T10:30:00"
}
```

*[📸 Screenshot: Postman request for user registration]*

#### 2. Get All Users

```http
GET /api/users
```

**Response:**
```json
[
  {
    "id": 1,
    "name": "John Doe",
    "email": "john.doe@example.com",
    "age": 28,
    "departmentId": 1
  },
  {
    "id": 2,
    "name": "Jane Smith",
    "email": "jane.smith@example.com",
    "age": 32,
    "departmentId": 2
  }
]
```

*[📸 Screenshot: Postman response showing list of users]*

#### 3. Get User by ID

```http
GET /api/users/{id}
```

*[📸 Screenshot: Postman request for specific user]*

#### 4. Delete User

```http
DELETE /api/users/{id}
```

**Response:**
```json
{
  "message": "User deleted successfully",
  "userId": 1
}
```

### Department Service Endpoints

#### 1. Create Department

```http
POST /api/departments
Content-Type: application/json

{
  "name": "Engineering",
  "code": "ENG",
  "description": "Software Engineering Department"
}
```

*[📸 Screenshot: Postman request for department creation]*

#### 2. Get All Departments

```http
GET /api/departments
```

*[📸 Screenshot: Postman response showing departments list]*

#### 3. Get Department by ID

```http
GET /api/departments/{id}
```

#### 4. Update Department

```http
PUT /api/departments/{id}
Content-Type: application/json

{
  "name": "Software Engineering",
  "code": "SENG",
  "description": "Updated description"
}
```

*[📸 Screenshot: Postman request for updating department]*

#### 5. Delete Department

```http
DELETE /api/departments/{id}
```

### Error Responses

All errors follow a consistent format:

```json
{
  "timestamp": "2025-10-14T10:30:00",
  "status": 400,
  "error": "Bad Request",
  "message": "Validation failed: Email already exists",
  "path": "/api/users/register"
}
```

*[📸 Screenshot: Error response example in Postman]*

### Postman Collection

📦 **Import Ready-to-Use Collections:**

- [Download Postman Collection](./postman/Employee-Department-Portal.postman_collection.json)
- [Download Environment Variables](./postman/Environment.postman_environment.json)

*[📸 Screenshot: Postman collection structure]*

---

## 📸 Screenshots

### Application Workflow

*[📸 Screenshot 1: Eureka Dashboard - All services registered and healthy]*

*[📸 Screenshot 2: API Gateway routing requests]*

*[📸 Screenshot 3: User registration via Postman]*

*[📸 Screenshot 4: Department creation and listing]*

*[📸 Screenshot 5: Zipkin distributed tracing UI showing request flow]*

*[📸 Screenshot 6: Database tables with sample data]*

*[📸 Screenshot 7: Docker containers running]*

*[📸 Screenshot 8: Config Server serving properties]*

*[📸 Screenshot 9: Error handling demonstration]*

*[📸 Screenshot 10: Swagger API documentation UI]*

---

## 📁 Project Structure

```
employee-department-portal/
│
├── api-gateway/
│   ├── src/main/java/
│   ├── src/main/resources/
│   ├── Dockerfile
│   └── pom.xml
│
├── eureka-server/
│   ├── src/main/java/
│   ├── src/main/resources/
│   ├── Dockerfile
│   └── pom.xml
│
├── config-server/
│   ├── src/main/java/
│   ├── src/main/resources/
│   ├── Dockerfile
│   └── pom.xml
│
├── user-service/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/portal/user/
│   │   │   │   ├── controller/
│   │   │   │   ├── service/
│   │   │   │   ├── repository/
│   │   │   │   ├── model/
│   │   │   │   ├── dto/
│   │   │   │   ├── exception/
│   │   │   │   └── UserServiceApplication.java
│   │   │   └── resources/
│   │   │       └── application.properties
│   │   └── test/
│   ├── Dockerfile
│   └── pom.xml
│
├── dept-service/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/portal/dept/
│   │   │   │   ├── controller/
│   │   │   │   ├── service/
│   │   │   │   ├── repository/
│   │   │   │   ├── model/
│   │   │   │   ├── dto/
│   │   │   │   ├── client/
│   │   │   │   └── DeptServiceApplication.java
│   │   │   └── resources/
│   │   │       └── application.properties
│   │   └── test/
│   ├── Dockerfile
│   └── pom.xml
│
├── postman/
│   ├── Employee-Department-Portal.postman_collection.json
│   └── Environment.postman_environment.json
│
├── docs/
│   ├── ER-Diagram.png
│   ├── Architecture.png
│   └── screenshots/
│
├── docker-compose.yml
├── .gitignore
├── README.md
└── LICENSE
```

---

## 🧪 Testing

### Unit Tests

```bash
# Run tests for User Service
cd user-service
mvn test

# Run tests for Department Service
cd dept-service
mvn test
```

### Integration Tests

```bash
# Run integration tests
mvn verify
```

### API Testing with Postman

1. Import the collection from `/postman` directory
2. Set environment variables
3. Run collection tests

*[📸 Screenshot: Postman test results]*

---

## 📊 Monitoring & Tracing

### Eureka Dashboard

Monitor service health and registration status:

```
http://localhost:8761
```

Features:
- Service instance status
- Health checks
- Application metadata

*[📸 Screenshot: Eureka monitoring dashboard]*

### Zipkin Distributed Tracing

Track requests across microservices:

```
http://localhost:9411
```

Features:
- Request flow visualization
- Performance bottleneck identification
- Service dependency mapping

*[📸 Screenshot: Zipkin trace visualization]*

### Application Logs

Each service produces structured logs with:
- Request/Response details
- Exception stack traces
- Performance metrics
- Correlation IDs (via Sleuth)

---

## 🗺 Roadmap

### Phase 1: Core Foundation ✅
- [x] Microservices architecture setup
- [x] Service discovery with Eureka
- [x] API Gateway implementation
- [x] Basic CRUD operations
- [x] Database integration

### Phase 2: Security & Validation ✅
- [x] Input validation
- [x] Exception handling
- [ ] JWT authentication implementation
- [ ] Role-based authorization (RBAC)
- [ ] API Gateway security filters

### Phase 3: Advanced Features 🚧
- [ ] Redis caching layer
- [ ] Event-driven architecture (Kafka)
- [ ] API rate limiting
- [ ] Swagger/OpenAPI documentation
- [ ] Pagination and sorting

### Phase 4: Testing & Quality 📋
- [ ] Comprehensive unit tests (80%+ coverage)
- [ ] Integration tests
- [ ] Performance testing (JMeter)
- [ ] Security testing (OWASP)
- [ ] Contract testing (Pact)

### Phase 5: DevOps & Production 🎯
- [ ] CI/CD pipeline (GitHub Actions)
- [ ] Kubernetes deployment
- [ ] Prometheus monitoring
- [ ] Grafana dashboards
- [ ] ELK stack for logging
- [ ] Production-grade configurations

---

## 🤝 Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

### Code Style Guidelines

- Follow Java naming conventions
- Write clean, self-documenting code
- Add comments for complex logic
- Include unit tests for new features
- Update documentation as needed

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## 👨‍💻 Author

<div align="center">

### **Abhishek Rangnath Kanade**

*Final Year BTech Student | Full Stack Developer*

[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/YourUsername)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://linkedin.com/in/yourprofile)
[![Email](https://img.shields.io/badge/Email-D14836?style=for-the-badge&logo=gmail&logoColor=white)](mailto:your-email@example.com)

**Tech Stack:** MERN Stack | Java & Spring Boot | Microservices Architecture

</div>

---

## 🙏 Acknowledgments

- Spring Boot and Spring Cloud teams for excellent frameworks
- Open source community for various libraries and tools
- Inspiration from enterprise microservices patterns

---

<div align="center">

### ⭐ If you find this project helpful, please consider giving it a star!

**Made with ❤️ by Abhishek Kanade**

</div>
