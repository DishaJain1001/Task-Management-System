📌 **Task Management System (Spring Boot 3 + Java 17 + JWT + RBAC)**

A complete Task Management REST API built using Spring Boot 3.4.11, Java 17, JWT Authentication, and Role-Based Access Control (ADMIN/USER).
This project demonstrates secure authentication, CRUD operations, DTO-based communication, layered architecture, and exception handling.

🚀 **Features**

🔐 **Authentication & Authorization**

User Login (username/password)
JWT Token Generation
Token-based authentication
Role-Based Access (ADMIN / USER)
Secured endpoints using Spring Security

📝 **Task Management (CRUD)**

Create Task
Update Task
Delete Task
Get Task by ID
Get All Tasks

🔧 **Security**

Spring Security 6 configuration
Custom JwtAuthenticationFilter
JwtUtils for token creation & validation
AuthenticationManager for login process

📦 **Additional Features**

DTO-based request/response
Global Exception Handling
Layered Architecture (Controller → Service → Repository)

🛠️ **Tech Stack**

Java 17
Spring Boot 3.4.11
Spring Security 6
Spring Data JPA
MySQL Database
JWT Authentication

▶️ **How to Run This Project**
# FROM IDE:
1. Import the project into VSCode or IntelliJ IDEA or Eclipse.
2. Create a MySQL database manually (because Hibernate update mode is ON).
3. Check src/main/resources/application.properties and update DB credentials:

**spring.datasource.url=jdbc:mysql://localhost:3306/task_management
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update**

4. Open main class: TaskManagementSystemApplication.
5. Run as Java Application.
6. Confirm server started at **http://localhost:8080**.
7. Use Postman for API testing.

📘 **API Testing**
🔑 Login First (Required for JWT Token)
    POST: /auth/login 
    Body Example:
{
  "username": "admin",
  "password": "password"
}

You will get a JWT token.
Use this token in headers:
**Authorization: Bearer <your-token>**

🧱 **Assumptions**

MySQL database exists before running the project.
Valid user credentials exist in the database for login.
ADMIN role is required for deleting tasks.
JWT token is mandatory for all secured endpoints.

🌱 **Future Enhancements**

Add Refresh Token feature
Add Pagination & Sorting on tasks
Add Email notifications for due tasks
Maven

Swagger UI / Postman for Testing
