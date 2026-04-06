# Healthcare Claims API

A GitHub-ready Spring Boot project that simulates a healthcare claims processing workflow. It covers **members, providers, eligibility tracking, and claim status updates** - a strong portfolio project for backend, healthcare, and enterprise API roles.

## Tech Stack
- Java 17
- Spring Boot 3
- Spring Web
- Spring Data JPA
- H2 Database (default for demo)
- MySQL-ready dependency included
- Swagger / OpenAPI

## Features
- Create and fetch members
- Create and fetch providers
- Submit healthcare claims
- Track claims by claim number
- Filter claims by status
- Update claim lifecycle status
- Seeded sample healthcare data for demo

## Project Structure
```
healthcare-claims-api/
├── src/main/java/com/example/claimsapi
│   ├── controller
│   ├── model
│   ├── repository
│   ├── service
│   ├── config
│   └── ClaimsApiApplication.java
├── src/main/resources
│   └── application.yml
├── pom.xml
└── README.md
```

## Run Locally
```bash
mvn spring-boot:run
```

App runs on:
- API: `http://localhost:8080`
- Swagger UI: `http://localhost:8080/swagger-ui.html`
- H2 Console: `http://localhost:8080/h2-console`

## Sample Endpoints

### Get all members
```http
GET /api/members
```

### Create member
```http
POST /api/members
Content-Type: application/json

{
  "memberId": "MBR1002",
  "fullName": "Noah Carter",
  "planName": "Student Gold Plan",
  "eligibilityStatus": "ACTIVE"
}
```

### Get all providers
```http
GET /api/providers
```

### Submit claim
```http
POST /api/claims
Content-Type: application/json

{
  "claimNumber": "CLM-2026-0002",
  "member": { "id": 1 },
  "provider": { "id": 1 },
  "serviceDate": "2026-04-01",
  "billedAmount": 180.50,
  "status": "SUBMITTED",
  "diagnosisCode": "R50.9",
  "procedureCode": "99214"
}
```

### Get claim by number
```http
GET /api/claims/CLM-2026-0001
```

### Filter claims by status
```http
GET /api/claims?status=IN_REVIEW
```

### Update claim status
```http
PATCH /api/claims/CLM-2026-0001/status?status=APPROVED
```

## Switch to MySQL
Update `application.yml` with your MySQL connection:
```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/claimsdb
    username: root
    password: yourpassword
  jpa:
    hibernate:
      ddl-auto: update
```

## GitHub Push Commands
```bash
git init
git add .
git commit -m "Initial commit - Healthcare Claims API"
git branch -M main
git remote add origin <your-github-repo-url>
git push -u origin main
```

## Resume Value
This project demonstrates:
- healthcare domain modeling
- REST API design
- Spring Boot microservice development
- claim workflow automation
- database schema design with JPA/Hibernate
- production-style API documentation with Swagger
