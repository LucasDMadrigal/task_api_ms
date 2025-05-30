
# 🧠 TasksApp - Sistema de Gestión de Usuarios y Autenticación

TasksApp es una aplicación web construida bajo una arquitectura de microservicios, enfocada en la gestión de usuarios, autenticación y protección de endpoints mediante JWT. Está preparada para integrarse fácilmente con otros servicios, como `task-service` o un frontend vía API Gateway.

---

## 🧩 Arquitectura del Proyecto

Este proyecto está dividido en **módulos independientes**, cada uno con su propia base de datos y responsabilidad:

| Servicio       | Puerto | Responsabilidad principal                     |
|----------------|--------|-----------------------------------------------|
| `auth-service` | 8081   | Registro, login, autenticación con JWT        |
| `user-service` | 8080   | Gestión de usuarios (GET, PUT, etc.)          |

Comunicación entre servicios: ✅ vía `WebClient`  
Autenticación: ✅ `Spring Security + JWT`

---

## 🛠️ Tecnologías Utilizadas

- **Java 17**
- **Spring Boot 3.1**
- **Spring Web & WebFlux**
- **Spring Security**
- **Spring Data JPA**
- **JWT (Java JWT - JJWT 0.11.5)**
- **H2 Database** (modo embebido)
- **Gradle**
- **Postman** (para pruebas)

---

## 🚀 Instrucciones para levantar el proyecto

### 1. Cloná el repositorio

```bash
git clone https://github.com/tu_usuario/tasksApp.git
cd tasksApp
```

### 2. Abrí el proyecto en IntelliJ (Community Edition está OK)

Asegurate de:
- Usar **JDK 17** desde Windows, no WSL
- Gradle detecte los submódulos como proyectos independientes (`auth-service`, `user-service`)

### 3. Configurá los puertos en los archivos `application.properties`

#### 📁 `auth-service/src/main/resources/application.properties`
```properties
server.port=8081
user.service.url=http://localhost:8080
jwt.secret=mySuperSecretKey1234567890
jwt.expiration=86400000
```

#### 📁 `user-service/src/main/resources/application.properties`
```properties
server.port=8080
jwt.secret=mySuperSecretKey1234567890
jwt.expiration=86400000
```

> 🔒 **IMPORTANTE:** `jwt.secret` debe ser el mismo en ambos servicios para que la validación de tokens funcione correctamente.

### 4. Ejecutá ambos servicios

```bash
./gradlew :auth-service:bootRun
./gradlew :user-service:bootRun
```

---

## 📬 Endpoints Disponibles

### 🔐 `auth-service` (puerto 8081)

| Método | Endpoint           | Descripción              |
|--------|--------------------|--------------------------|
| POST   | `/api/auth/register` | Registra nuevo usuario (en ambos servicios) |
| POST   | `/api/auth/login`    | Devuelve JWT si el login es exitoso         |

---

### 👤 `user-service` (puerto 8080)

Todos los endpoints protegidos con JWT.

| Método | Endpoint        | Descripción                     |
|--------|-----------------|---------------------------------|
| GET    | `/api/users`    | Obtener todos los usuarios      |
| PUT    | `/api/users/{id}` | Modificar usuario por ID       |

> Para acceder, enviar token en el header:
```
Authorization: Bearer <tu-token>
```

---

## ✅ Funcionalidades implementadas

- [x] Registro y login de usuarios
- [x] Hashing de contraseñas con BCrypt
- [x] Generación y validación de JWT
- [x] Comunicación entre microservicios vía WebClient
- [x] Protección de rutas con Spring Security
- [x] Separación de responsabilidades (auth vs users)

---

## ✨ Mejoras futuras

- [ ] Implementación de `task-service`
- [ ] API Gateway con Spring Cloud Gateway
- [ ] Persistencia en base de datos relacional real (PostgreSQL/MySQL)
- [ ] Soporte para roles con permisos (ADMIN, USER, etc.)
- [ ] Frontend integrado

---

## 🧑‍💻 Autor

Lucas Madrigal  
Full Stack Developer - MERN & Java Spring Boot  
