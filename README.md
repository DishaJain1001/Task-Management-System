📌 **Task Management System (Spring Boot 3 + Java 17 + JWT + RBAC)**

A complete Task Management REST API built using Spring Boot 3.4.11, Java 17, JWT Authentication, and Role-Based Access Control (ADMIN/USER).
This project demonstrates secure authentication, CRUD operations, DTO-based communication, layered architecture, and exception handling.

🚀 **Features**

🔐 **Authentication & Authorization**

1. User Login (username/password)
2. JWT Token Generation
3. Token-based authentication
4. Role-Based Access (ADMIN / USER)
5. Secured endpoints using Spring Security

📝 **Task Management (CRUD)**

1. Create Task
2. Update Task
3. Delete Task
4. Get Task by ID
5. Get All Tasks

🔧 **Security**

1. Spring Security 6 configuration
2. Custom JwtAuthenticationFilter
3. JwtUtils for token creation & validation
4. AuthenticationManager for login process

📦 **Additional Features**

1. DTO-based request/response
2. Global Exception Handling
3. Layered Architecture (Controller → Service → Repository)

🛠️ **Tech Stack**

1. Java 17
2. Spring Boot 3.4.11
3. Spring Security 6
4. Spring Data JPA
5. MySQL Database
6. JWT Authentication

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

1. MySQL database exists before running the project.
2. Valid user credentials exist in the database for login.
3. ADMIN role is required for deleting tasks.
4. JWT token is mandatory for all secured endpoints.

🌱 **Future Enhancements**

1. Add Refresh Token feature
2. Add Pagination & Sorting on tasks
3. Add Email notifications for due tasks
4. Maven

Swagger UI / Postman for Testing
