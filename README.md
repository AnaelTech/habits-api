# Habits API

The **Habits** app’s REST API.

![Java](https://skillicons.dev/icons?i=java)
![Spring](https://skillicons.dev/icons?i=spring)
![Maven](https://skillicons.dev/icons?i=maven)
![PostgreSQL](https://skillicons.dev/icons?i=postgres)
![Git](https://skillicons.dev/icons?i=git)
![GitHub](https://skillicons.dev/icons?i=github)
![VS Code](https://skillicons.dev/icons?i=vscode)

## Technologies

- Java 21
- Spring Boot `4.0.7`
- Spring Data JPA
- Hibernate
- PostgreSQL `18.4`
- Maven `3.9.12`

## Requirements

- Java 21+
- Maven 3.9+
- PostgreSQL

## Functionalities

- User management
- Management of habits
- Daily routine monitoring
- Daily newspaper
- Statistics
- Authentification

## Structure

```text
src/
├── main/
│   ├── java/
│   └── resources/
└── test/
```

## Installation

```bash
git clone https://github.com/AnaelTech/habits-api.git
cd habits-api
```

## Setup

Configure the environment variables `env` or the `application.properties` file:

- Database URL
- PostgreSQL username
- PostgreSQL password

## Launch the application

```bash
./mvnw spring-boot:run
```

Or with Maven :

```bash
mvn spring-boot:run
```

The API is available by default on:

```text
http://localhost:8080/api
```

## Tests

```bash
./mvnw test
```

## Challenges Encountered & Solutions

### `MapStruct Bean Not Found`

🚨 Problem:
During application startup, Spring failed to initialize the context with the following error:

No qualifying bean of type 'UserMapper' available

⚠️ Cause:
The UserMapper interface was correctly annotated with @Mapper(componentModel = "spring"), but MapStruct was not generating the implementation class required by Spring.

✅ Solution:
Added the MapStruct annotation processor configuration in Maven to enable automatic generation of mapper implementations during compilation.

### `Exception Handling and HTTP Status Management`

🚨 Problem:
Custom exceptions such as UserNotFoundException were correctly thrown by the service layer, but the API returned a 500 Internal Server Error instead of the expected HTTP status.

⚠️ Cause:
Spring did not know how to translate custom exceptions into HTTP responses.

✅ Solution:
Implemented a global exception handler using @RestControllerAdvice and @ExceptionHandler to centralize exception handling and return proper HTTP responses (404 Not Found, 409 Conflict, 400 Bad Request, etc.).

### `Error Response Standardization`

🚨 Problem:
Each exception handler was responsible for creating its own error response object, which could lead to duplicated code.

✅ Solution:
Created a reusable method inside the global exception handler to centralize the creation of ErrorResponse objects and ensure consistent API error responses.

## Licence

Personal project.
