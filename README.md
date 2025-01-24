# onboarding
This repository contains an onboarding project built with Java Spring Boot. The project provides a set of APIs for user authentication, including signup, signin, and password reset functionalities.

## Prerequisites

Before running the application, ensure you have the following installed on your system:

- Java 17 or higher
- Maven 3.8+
- Postman (optional, for API testing)

## Getting Started

Follow these steps to set up and run the project on your local machine:

### 1. Clone the Repository

```bash
git clone <repository-url>
cd <repository-folder>
```

### 2. Configure the Database

The project uses an in-memory H2 database for simplicity. Update the database configurations in the `application.properties` file located under `src/main/resources/` (if not already configured):

```properties
spring.datasource.url=jdbc:h2:mem:onboarding
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true
```

You can access the H2 console at `http://localhost:8082/h2-console` after starting the application.

### 3. Build the Project

Run the following command to build the project using Maven:

```bash
mvn clean install
```

### 4. Run the Application

Start the Spring Boot application:

```bash
mvn spring-boot:run
```

The application will run on `http://localhost:8082` by default.

## Testing the APIs

Use Postman or any API testing tool to test the endpoints. Below are the available APIs:

### 1. Signup

- **Endpoint:** `POST /api/users/signup`
- **Request Body:**
  ```json
  {
    "email": "faiz@gmail.com",
    "password": "password123"
  }
  ```
- **Response:**
  ```json
  {
    "id": 1,
    "email": "faiz@gmail.com",
    "password": "$2a$10$...",
    "resetToken": null
  }
  ```
  ![Image](https://github.com/user-attachments/assets/bf73e8e7-99e8-40ae-a590-486ed79c38c6)

### 2. Signin

- **Endpoint:** `POST /api/users/signin`
- **Request Body:**
  ```json
  {
    "email": "faiz@gmail.com",
    "password": "password123"
  }
  ```
- **Response:**
  ```json
  {
    "id": 1,
    "email": "faiz@gmail.com",
    "password": "$2a$10$...",
    "resetToken": null
  }
  ```
  ![Image](https://github.com/user-attachments/assets/4fa053b8-a67b-48e3-b07b-f838f614b435)

### 3. Forgot Password

- **Endpoint:** `POST /api/users/forgot-password`
- **Request Body:**
  ```json
  {
    "email": "faiz@gmail.com"
  }
  ```
- **Response:**
  ```json
  "575b79bc-9bf0-4a4a-9277-896574482de1"
  ```
  ![Image](https://github.com/user-attachments/assets/6f2d56a7-05ea-49c5-bc82-b38f2b5baae3)

## Screenshots

### H2 Console

![Image](https://github.com/user-attachments/assets/06fc0b47-b69a-4a70-bfdc-4536ccc4f891)

This shows the H2 console with the `USER_ENTITY` table displaying user information.

### Project Structure

![Image](https://github.com/user-attachments/assets/a602a45f-ba13-43e0-bc57-c5b473b01228)

This screenshot illustrates the folder structure of the project, including the configuration, controllers, models, and services.


## License

This project is licensed under the MIT License. Feel free to use and modify it as needed.

---

For further assistance, please contact mohammadfaizpathan343@gmail.com.
