# Service Booking API – NEXUS

Backend service for the Service Booking Platform (NEXUS), currently providing authentication capabilities and evolving into a full scheduling system.

The authentication module serves as the foundation for secure frontend integration and future booking-related domains.

At its current stage, the service exposes authentication-related REST APIs, while the scheduling domain is being incrementally introduced.

## Tech Stack

- Java
- Spring Boot
- Spring Security
- JWT (JSON Web Tokens)
- JPA
- PostgreSQL

## Responsibilities

- User registration with username and email uniqueness validation
- User authentication and JWT token generation
- Token validation (expiration and integrity checks)
- Exposure of secure REST APIs for frontend consumption
- Preparation for scheduling domain expansion (Phase 2)

## Application Flow

- Client sends a user registration request
- Backend validates username and email uniqueness
- User credentials are securely stored (hashed password)
- Client performs authentication (login)
- Backend generates and returns a JWT token
- Protected endpoints validate token integrity and expiration
- Requests with invalid or expired tokens are rejected

## Core Features

### User Registration

- Validates whether username or email already exists in the database
- Persists user data with secure password hashing

### Authentication

- Performs login using username/email and password
- Generates JWT token upon successful authentication

### Token Validation

- Validates token signature and expiration
- Ensures access to protected endpoints only for authenticated users

## Main Endpoints

- **POST /auth/register**
  Account registration

- **POST /auth/login**
  User authentication and JWT generation

- **GET /auth/validate**
  Explicit token validation endpoint (introspection-style)

## Data Model (High-Level)

### UserSignupRequest

- username
- email
- password 
- name
- role

### UserSigninRequest

- identifier
- password

### UserEntity

- id
- name
- username
- email
- password
- role
- createdAt

### Role (ENUM)

- ADMIN
- CUSTOMER

### UserDetails

- id
- name
- username
- email
- password (hashed, internal use only)
- authorities
- createdAt

### AuthToken

- token

### ErrorTemplate

- errorCode
- message
- timestamp
- traceId

## Error Handling

- Invalid credentials during authentication
- Duplicate username or email on registration
- Expired or malformed JWT tokens
- Unauthorized access to protected endpoints

## Security Considerations

- JWT-based stateless authentication
- Secure password storage using hashing
- Endpoint protection via Spring Security
- Token validation applied to protected routes

Password comparison is performed using Spring Security's PasswordEncoder,
ensuring secure hash-based validation without exposing raw credentials.

## Testing Strategy

Current:
- Manual validation of authentication flows

Planned:
- Unit tests for authentication services
- Unit tests for booking domain rules (Phase 2)
- Integration tests for booking conflict scenarios
- Concurrency validation scenarios to simulate booking conflicts under parallel requests

## Deployment (Planned)

- Environment-based configuration
- Planned containerization via Docker
- Planned integration with frontend and database using Docker Compose

## Known Limitations (Current Stage)

- Booking domain not yet exposed via REST endpoints
- No availability or scheduling logic implemented yet
- No database-level constraints for booking conflicts (planned)
- No integration tests yet

## Upcoming Architecture Enhancements

The following architectural improvements are planned as part of the booking implementation phase:

- Introduction of Provider and Booking bounded contexts
- OffsetDateTime-based scheduling model (UTC-safe)
- Booking modeled as startAt + duration
- Conflict detection at application layer
- Database-level protection against race conditions
- Index optimization for provider-based scheduling queries
- Docker Compose for full local environment (API + DB)

## Current Phase

The platform is currently evolving from an authentication-focused foundation into a full scheduling system.

Phase 1 (Completed):
- User registration
- Authentication (JWT-based)
- Token validation
- Secure REST integration with frontend

Phase 2 (In Progress):
- Provider domain modeling
- Booking lifecycle implementation
- Availability rules
- Conflict detection
- Business rule enforcement at application and database levels

## Prerequisites

To run this application locally, you will need:

- Java 17+
- PostgreSQL running locally or remotely

  Database connection details must be configured
  in the `application.yaml` file.

## Running Locally with existing PostgreSQL

Ensure PostgreSQL is running and properly configured
in `application.yaml`.

Start the application using Maven:

```bash
mvn spring-boot:run
```

To stop the application, interrupt the process:

```bash
Ctrl + C
```

## Frontend Dependency

This backend service is consumed by the frontend application:

[Service Booking UI](https://github.com/andrealsp-portfolio/service-booking-ui)

The backend provides authentication-related capabilities required by the frontend, including:

- User registration
- User authentication (login)
- JWT token validation

## API Usage Examples

All authenticated requests must include the JWT token
using the Authorization header with the Bearer prefix.

### Account Registration

```bash
curl --location 'http://localhost:8081/nexus/v1/auth/register' \
--data-raw '{
    "username": "andre.alsp",
    "email": "andre.alsp@outlook.com",
    "password": "P4$$w0RD",
    "name": "Andre Luis Santos Pereira",
    "role": "ADMIN"
}'
```

### Login

### User Authentication

```bash
curl --location 'http://localhost:8081/nexus/v1/auth/login' \
--data '{
    "identifier":"andre.alsp",
    "password": "P4$$w0RD"
}'
```

### Token Validation

```bash
curl --location 'http://localhost:8081/nexus/v1/auth/validate' \
--header 'Authorization: Bearer <JWT_TOKEN>'
```
