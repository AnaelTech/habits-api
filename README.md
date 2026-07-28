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

## Licence

Personal project.
