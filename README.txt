# Task Management System

# HOW TO RUN THIS PROJECT?

### FROM THE IDE:

1. Open the project in any IDE like VS Code or IntelliJ IDEA or Eclipse.
2. Configure your database in **src/main/resources/application.properties**.
3. Create a database in MySQL (required because Hibernate is using update mode):
   ```
   spring.jpa.hibernate.ddl-auto=update
   ```
4. If you do NOT want to manually create tables, you can change:

   ```
   spring.jpa.hibernate.ddl-auto=create-drop
   ```
   (This will auto-create tables each time you run the app.)

5. Open package: **com.example.task_management_system**
6. Right-click on **TaskManagementSystemApplication**.
7. Select **Run As → Java Application**.
8. Confirm that the server is running at localhost.
9. Open **Swagger** or **Postman** for testing.
10. Use these URLs:

    * Login API: `http://localhost:8080/auth/login`
    * Task APIs: `http://localhost:8080/tasks`

### Authentication:

1. First call the login API:

   * POST: `/auth/login`
   * Body Example:

     ```
     {
       "username": "admin",
       "password": "password"
     }
     ```
2. Copy the token received.
3. Add this in header for all other API calls:

   ```
   Authorization: Bearer <token>
   ```

# ENDPOINTS

### Task APIs:

GET - `http://localhost:8080/tasks` - get all tasks
GET - `http://localhost:8080/tasks/{id}` - get task by ID
POST - `http://localhost:8080/tasks` - create new task
PUT - `http://localhost:8080/tasks/{id}` - update task
DELETE - `http://localhost:8080/tasks/{id}` - delete task

### Auth APIs:

POST - `http://localhost:8080/auth/login` - login & generate token

# ASSUMPTIONS

1. A MySQL database is created before running the project.
2. JWT authentication is required for all secured endpoints.
3. Admin role is required for delete operations.
4. Valid username and password must be present in the database.

# TECHNOLOGY STACK

1. Java 17
2. Spring Boot 3.4.11
3. Spring Security 6
4. MySQL
5. JWT Authentication
6. Postman for testing
7. Maven

# DESIGN DISCUSSION

1. Project follows Controller → Service → Repository architecture.
2. DTOs are used for clean API request/response.
3. Passwords are encrypted using Spring Security.
4. JWT token is used for authorization.
5. Global exception handling is implemented.

### Ease of extending the program

1. You can add Employee or Project modules easily.
2. You can implement refresh token functionality.
3. You can add pagination & sorting in task APIs.
