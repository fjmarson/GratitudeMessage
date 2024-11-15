# GratitudeMessage API

Esta API RESTful permite a los usuarios enviar, almacenar y listar mensajes de gratitud. Los mensajes incluyen un campo de fecha y el nombre del remitente, y los usuarios pueden listar los mensajes en orden cronológico o por popularidad. La API utiliza MySQL como base de datos y está documentada usando Swagger.

## Requisitos

- **Java 17** o superior.
- **Spring Boot 3.3.5**.
- **MySQL** como base de datos.
- **Swagger** para documentación de la API.

## Instalación

### 1. Clona este repositorio

```bash
git clone https://github.com/fjmarson/GratitudeMessage.git
cd GratitudeMessage
```
### 2. Configura MySQL

Asegúrate de tener una base de datos MySQL corriendo y crea una base de datos llamada gratitude_messages.

CREATE DATABASE gratitude_messages;

### 3. Configura la conexión a la base de datos

Abre el archivo src/main/resources/application.properties y asegúrate de que los parámetros de conexión a la base de datos son correctos.

spring.datasource.url=jdbc:mysql://localhost:3306/gratitude_messages
spring.datasource.username=root
spring.datasource.password=Bas3
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

### 4. Ejecuta la aplicación

Para compilar y ejecutar la aplicación, usa el siguiente comando:

mvn clean install
mvn spring-boot:run

Esto arrancará el servidor de la API en el puerto predeterminado 8080.

## Endpoints

### 1. Crear un mensaje de gratitud

POST /api/messages

Crea un nuevo mensaje de gratitud.

Request Body:

```bash
{
  "message": "Gracias por tu ayuda.",
  "popularity": 5,
  "sender_name": "Juan Pérez"
}
```
Respuesta (200 OK):

```bash
{
  "id": 1,
  "date": "2024-11-15T10:01:00",
  "message": "Gracias por tu ayuda.",
  "popularity": 5,
  "sender_name": "Juan Pérez"
}
```

### 2. Listar todos los mensajes de gratitud

GET /api/messages

Lista todos los mensajes de gratitud en orden cronológico (por defecto).

Respuesta (200 OK):



```bash
[
  {
    "id": 1,
    "date": "2024-11-15T10:01:00",
    "message": "Gracias por tu ayuda.",
    "popularity": 5,
    "sender_name": "Juan Pérez"
  },
  {
    "id": 2,
    "date": "2024-11-15T10:02:00",
    "message": "Te agradezco mucho.",
    "popularity": 3,
    "sender_name": "Ana Gómez"
  }
]
```

### 3. Listar los mensajes por popularidad

GET /api/messages/popularity

Lista todos los mensajes de gratitud ordenados por popularidad de mayor a menor.

Respuesta (200 OK):


```bash
[
  {
    "id": 1,
    "date": "2024-11-15T10:01:00",
    "message": "Gracias por tu ayuda.",
    "popularity": 5,
    "sender_name": "Juan Pérez"
  },
  {
    "id": 2,
    "date": "2024-11-15T10:02:00",
    "message": "Te agradezco mucho.",
    "popularity": 3,
    "sender_name": "Ana Gómez"
  }
]
```

### 4. Borrar un mensaje de gratitud

DELETE /api/messages/{id}

Borra un mensaje de gratitud dado su id.

Respuesta (200 OK):

```bash
{
  "message": "Mensaje borrado con éxito"
}
```
## Documentación de la API (Swagger)

La API está documentada usando Swagger. Para acceder a la documentación interactiva, abre el siguiente enlace en tu navegador:

```bash
http://localhost:8080/swagger-ui/index.html
```

## Estructura de la Base de Datos

Tabla: gratitude_message

![Table](https://raw.githubusercontent.com/fjmarson/GratitudeMessage/refs/heads/main/src/img/Table.png?token=GHSAT0AAAAAAC2QYU7MWOS4MPAUCJLPVU4WZZXNKAQ)

## Licencia

Este proyecto está bajo la Licencia MIT.

## Contribución
Si deseas contribuir, por favor abre un pull request o reporta problemas en la sección de issues.
