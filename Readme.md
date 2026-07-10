# Pet API Integration

## Descripción

Este proyecto fue desarrollado como parte de una prueba técnica para una posición de **Backend Developer**.

La aplicación expone una API REST que consume la API pública de **Swagger Petstore**, permitiendo:

- Consultar una mascota por su identificador.
- Registrar una nueva mascota.

Como parte de la lógica de negocio solicitada por la prueba, la aplicación genera un identificador único de transacción (UUID) y la fecha de creación al registrar una mascota.

---

# Tecnologías utilizadas

- Java 17
- Spring Boot 3.2.7
- Spring Web
- RestClient
- Gradle

---

# Arquitectura

El proyecto sigue una arquitectura por capas para mantener una clara separación de responsabilidades.

```text
                HTTP Request
                     │
                     ▼
              PetController
                     │
                     ▼
               PetService
                     │
                     ▼
             PetStoreClient
                     │
                     ▼
         Swagger Petstore API
```

## Estructura del proyecto

```text
src/main/java/com/baersolutions/petapi
│
├── client
├── config
├── controller
├── dto
│   ├── external
│   ├── request
│   └── response
├── exception
└── service
    └── impl
```

---

# Endpoints

## Obtener mascota

### Request

```http
GET /api/pet/{petId}
```

### Ejemplo

```http
GET /api/pet/1
```

### Response

```json
{
    "id": 1,
    "name": "doggie",
    "status": "available"
}
```

---

## Registrar mascota

### Request

```http
POST /api/pet
```

```json
{
    "id": 10000023,
    "name": "testingPet",
    "status": "available"
}
```

### Response

```json
{
    "transactionId": "52133c82-6da5-4cf8-86c5-fe310984395c",
    "dateCreated": "2026-07-10T13:40:51.992453",
    "status": "available",
    "name": "testingPet"
}
```

---

# Manejo de errores

La aplicación implementa un manejo global de excepciones mediante `@RestControllerAdvice`.

Cuando ocurre un error al consumir la API externa, la aplicación responde con un formato de error consistente.

Ejemplo:

```json
{
    "timestamp": "2026-07-10T15:10:08.7809698",
    "status": 502,
    "error": "Bad Gateway",
    "message": "Error retrieving pet from Swagger Petstore.",
    "path": "/api/pet/3"
}
```

---

# Ejecución del proyecto

## Clonar el repositorio

```bash
git clone <repository-url>
```

## Acceder al proyecto

```bash
cd pet-api
```

## Ejecutar la aplicación

### Windows

```powershell
.\gradlew.bat bootRun
```

### Linux / macOS

```bash
./gradlew bootRun
```

La aplicación estará disponible en:

```text
http://localhost:8080
```

---

# Validación del proyecto

Para verificar que el proyecto inicia correctamente:

```powershell
.\gradlew.bat test
```

Durante el desarrollo se realizaron pruebas funcionales manuales mediante Postman para validar el correcto funcionamiento de los endpoints definidos en la prueba técnica.

---

# Decisiones técnicas

Durante el desarrollo se tomaron las siguientes decisiones de diseño:

- Uso de **RestClient** como cliente HTTP nativo de Spring Framework.
- Separación entre DTOs internos y DTOs de la API externa para evitar acoplamiento.
- Arquitectura por capas (Controller, Service y Client).
- Manejo centralizado de excepciones mediante `@RestControllerAdvice`.
- Registro de eventos mediante **SLF4J**.
- Uso de **Java Records** para representar DTOs inmutables.
- Inyección de dependencias mediante constructor.
- Configuración externalizada mediante `application.yml`.

---

# Autor

**Roman Bautista Espinosa**