# Spring Boot URL Shortener

This is a full-featured URL shortener web application built with Spring Boot. It allows users to shorten long URLs, manage their links, and track click counts. The application provides user authentication and authorization with role-based access control for regular users and administrators.

[![Java](https://img.shields.io/badge/Java-21-blue.svg)](https://www.java.com)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3-brightgreen.svg)](https://spring.io/projects/spring-boot)

## Features

  - **URL Shortening**: Convert long, cumbersome URLs into short and manageable links.
  - **User Authentication**: Secure user registration and login functionality.
  - **Public and Private URLs**: Users can create public links or private links that are only accessible to them.
  - **URL Expiration**: Set an expiration date for shortened URLs.
  - **Click Tracking**: A simple click counter for each shortened link.
  - **User Dashboard**: Registered users have a personal dashboard to view, manage, and delete their shortened URLs.
  - **Admin Dashboard**: Administrators have access to a dashboard to view all the shortened URLs in the system.
  - **Responsive UI**: A clean and responsive user interface built with Thymeleaf and Bootstrap.

## Technologies Used

  - **Backend**:
      - Java 21
      - Spring Boot 3.5.5
      - Spring Security (for authentication and authorization)
      - Spring Data JPA (for database interaction)
      - Thymeleaf (for server-side templating)
  - **Database**:
      - PostgreSQL
      - Flyway (for database migrations)
  - **Frontend**:
      - HTML5
      - CSS3
      - Bootstrap 5
  - **Build and Dependency Management**:
      - Apache Maven
  - **Containerization**:
      - Docker
      - Docker Compose

## Getting Started

Follow these instructions to get a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

  - JDK 21 or newer
  - Apache Maven 3.x
  - Docker and Docker Compose
  - Your favorite IDE (e.g., IntelliJ IDEA, Eclipse, VS Code)

### Installation and Setup

1.  **Clone the repository:**

    ```bash
    git clone https://github.com/lucasterra/spring-boot-url-shortener.git
    cd spring-boot-url-shortener
    ```

2.  **Start the PostgreSQL database using Docker Compose:**

    Navigate to the `docker` directory and run the following command:

    ```bash
    docker-compose up -d
    ```

    This will start a PostgreSQL container and expose it on port `5432`.

3.  **Configure the application:**

    The main configuration file is located at `src/main/resources/application.properties`. By default, the application is configured to connect to the PostgreSQL database started by Docker Compose.

    ```properties
    spring.application.name=spring-boot-url-shortener

    # App config
    app.base-url=http://localhost:8080
    app.default-expiry-in-days=30
    app.validate-original-url=true


    spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
    spring.datasource.username=postgres
    spring.datasource.password=postgres
    spring.jpa.show-sql=true
    spring.jpa.open-in-view=false
    ```

4.  **Run the application:**

    You can run the application using the Maven wrapper included in the project:

    ```bash
    ./mvnw spring-boot:run
    ```

    The application will be accessible at `http://localhost:8080`.

## Usage

  - **Homepage**: Visit `http://localhost:8080` to see the main page where you can shorten URLs as an anonymous user.
  - **Register**: Create a new account to access more features.
  - **Login**: Log in with your credentials to manage your URLs.
  - **My URLs**: After logging in, you can see a list of your created URLs, with options to delete them.
  - **Admin Dashboard**: Log in with an admin account to view all URLs created in the system. Default admin credentials can be found in the database migration files.

## Database Migrations

Database schema and initial data are managed by Flyway. The migration scripts are located in `src/main/resources/db/migration`. When the application starts, Flyway will automatically apply any pending migrations.

  - `V1__create_tables.sql`: Creates the `users` and `short_urls` tables.
  - `V2__insert_sample_data.sql`: Inserts sample users, including an admin and a regular user.
  - `V3__update_user_password.sql`: Updates the passwords for the sample users to be bcrypted.

## Project Structure

```
├── docker
│   └── compose.yaml                    # Docker Compose file for PostgreSQL
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com/lucasterra/spring_boot_url_shortener
│   │   │       ├── config              # Spring Security configuration
│   │   │       ├── domain              # Core domain entities, models, repositories, and services
│   │   │       ├── web                 # Spring MVC controllers and DTOs
│   │   │       └── Application.java    # Main Spring Boot application class
│   │   └── resources
│   │       ├── db/migration            # Flyway database migration scripts
│   │       ├── static                  # Static assets (CSS, JS, images)
│   │       ├── templates               # Thymeleaf templates
│   │       └── application.properties  # Application configuration
│   └── test                            # Test sources
├── .gitignore
├── mvnw                                # Maven wrapper script for Unix-like systems
├── mvnw.cmd                            # Maven wrapper script for Windows
└── pom.xml                             # Maven project configuration
```

## Running with Docker

You can also build a Docker image for the application and run it using Docker Compose.

1.  **Build the application JAR:**

    ```bash
    ./mvnw clean package
    ```

2.  **Build the Docker image:**

    The `pom.xml` is configured to build a Docker image using the Spring Boot Maven plugin.

    ```bash
    ./mvnw spring-boot:build-image
    ```

3.  **Run with Docker Compose:**

    The `docker/compose.yaml` file includes a service for the Spring Boot application.

    ```bash
    cd docker
    docker-compose up -d
    ```

    This will start both the PostgreSQL database and the Spring Boot application containers.

## Contributing

Contributions are welcome\! Please feel free to submit a pull request or open an issue for any bugs or feature requests.
