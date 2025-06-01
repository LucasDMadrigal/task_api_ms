
# 🧠 TasksApp - Sistema de Gestión de Usuarios, Autenticación y Tareas

TasksApp es una aplicación web construida bajo una arquitectura de microservicios, enfocada en la gestión de usuarios, autenticación y manejo de tareas. Cada servicio es independiente, con su propia base de datos, seguridad y responsabilidades específicas.

---

## 🧩 Arquitectura del Proyecto

| Servicio        | Puerto | Responsabilidad principal                             |
|-----------------|--------|-------------------------------------------------------|
| `auth-service`  | 8081   | Registro, login, autenticación con JWT                |
| `user-service`  | 8080   | Gestión de usuarios (GET, PUT)                        |
| `task-service`  | 8082   | Gestión de tareas (crear, listar, actualizar, borrar) |

Comunicación entre servicios: ✅ vía `WebClient`  
Autenticación: ✅ `Spring Security + JWT`

---

## 🛠️ Tecnologías Utilizadas

- **Java 17**
- **Spring Boot 3.1**
- **Spring Security**
- **Spring Data JPA**
- **Spring Web & WebFlux**
- **JWT (JJWT 0.11.5)**
- **H2 Database (modo embebido)**
- **Gradle**

---

## 🚀 Instrucciones para levantar el proyecto

### 1. Cloná el repositorio

```bash
git clone https://github.com/tu_usuario/tasksApp.git
cd tasksApp
```

### 2. Abrí el proyecto en IntelliJ

Asegurate de:
- Usar **JDK 17** de Windows (no WSL)
- IntelliJ detecte los subproyectos: `auth-service`, `user-service`, `task-service`

### 3. Configurá los puertos y secretos en `application.properties`

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

#### 📁 `task-service/src/main/resources/application.properties`

```properties
server.port=8082
jwt.secret=mySuperSecretKey1234567890
jwt.expiration=86400000
```

> ⚠️ **IMPORTANTE:** `jwt.secret` debe ser el mismo en los tres servicios.

### 4. Ejecutá los tres servicios

```bash
./gradlew :auth-service:bootRun
./gradlew :user-service:bootRun
./gradlew :task-service:bootRun
```

---

## 📬 Endpoints Disponibles

### 🔐 `auth-service` (puerto 8081)

| Método | Endpoint             | Descripción                                  |
|--------|----------------------|----------------------------------------------|
| POST   | `/api/auth/register` | Registra usuario (sincroniza con user-service) |
| POST   | `/api/auth/login`    | Devuelve JWT si el login es válido           |

---

### 👤 `user-service` (puerto 8080)

> Requiere autenticación con token.

| Método | Endpoint          | Descripción              |
|--------|-------------------|--------------------------|
| GET    | `/api/users`      | Obtener todos los usuarios |
| PUT    | `/api/users/{id}` | Actualizar usuario por ID  |

---

### ✅ `task-service` (puerto 8082)

> Requiere autenticación con token.

| Método | Endpoint              | Descripción                            |
|--------|-----------------------|----------------------------------------|
| POST   | `/api/tasks/create`   | Crear nueva tarea                      |
| GET    | `/api/tasks/all`      | Listar tareas del usuario autenticado  |
| PUT    | `/api/tasks/update/{id}` | Actualizar una tarea por su ID      |
| DELETE | `/api/tasks/delete/{id}` | Eliminar una tarea por su ID        |

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
- [x] Gestión de usuarios (GET, PUT)
- [x] Gestión de tareas (crear, listar, editar, eliminar)
- [x] Separación de responsabilidades (auth, user, task)

---

## 🧪 Tests de integración

- ✔️ Test de registro en `auth-service`
- ✔️ Test de creación y obtención de tareas en `task-service`

> Los tests se encuentran dentro de la carpeta `src/test/java` de cada microservicio.

---

## 🧑‍💻 Autor

Lucas Madrigal  
Full Stack Developer - MERN & Java Spring Boot  
