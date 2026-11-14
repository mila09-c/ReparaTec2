# ReparaTec2

El siguiente proyecto es acerca de un sistema backend para la gestión de un taller de soporte y reparación de equipos tecnológicos, este proyecto emplea nuestros conocimientos sobre arquitectura REST en Java con Spring Boot y estructuras de datos propias (Tercer Parcial).

## Descripción

Una explicación más detallada del proyecto:
- La motivación principal fue digitalizar y organizar el control operativo de un taller de reparación técnica (recepción de equipos, asignación de clientes/técnicos, órdenes de reparación e inventario de refacciones).
- Se implementó una arquitectura por capas limpia (`controllers`, `services`, `models`, `dto`, `structures`) utilizando estructuras de datos creadas desde cero (`CustomLinkedList` basada en nodos y `CustomStack` LIFO) sin depender de colecciones nativas de Java para el almacenamiento principal de las entidades.

## Tecnologías Utilizadas

- Java 17+
- Spring Boot
- Gradle (`./gradlew`)
- Estructuras de datos propias (`CustomLinkedList` y `CustomStack`)
- Postman (Collection v2.1)
- Git Flow y SonarCloud

## Requisitos Previos

- JDK 17 o superior instalado
- IDE compatible con Java y Gradle (recomendamos IntelliJ IDEA)
- Postman para importar y probar la colección de endpoints

## Instalación

1. Clona este repositorio:

    - `git clone https://github.com/mila09-c/ReparaTec2.git`

2. Navega a la carpeta del proyecto:

    - `cd ReparaTec2`

3. Configura las variables de entorno copiando `.env.example` a `.env` en la raíz del proyecto:

    - `cp .env.example .env`

4. Ejecuta el servidor backend desde IntelliJ (`ReparaTec2Application`) o en terminal:

    - `.\gradlew.bat bootRun`

## Uso

1. Levanta el servidor en `http://localhost:8080`.
2. Importa la colección `postman/ReparaTec2.postman_collection.json` en Postman y verifica que `baseUrl` sea `http://localhost:8080`.
3. Ejecuta los endpoints principales por módulo:
    - **Health:** `GET /api/health` y `GET /api/health/db`
    - **Usuarios:** `GET /api/usuarios`, `GET /api/usuarios/{id}`, `POST /api/usuarios`
    - **Equipos:** `GET /api/equipos`, `GET /api/equipos/{id}`, `POST /api/equipos`, `PUT /api/equipos/{id}/estado`
    - **Reparaciones:** `GET /api/reparaciones`, `GET /api/reparaciones/{id}`, `POST /api/reparaciones`
    - **Refacciones:** `GET /api/refacciones`, `GET /api/refacciones/{id}`, `POST /api/refacciones`

## Características

- Arquitectura REST organizada por capas
- Estructuras de datos propias (`CustomLinkedList` con `.toList()` y `CustomStack`)
- Validaciones de entrada y respuestas HTTP estándar (`200 OK`, `201 Created`, `400 Bad Request`, `404 Not Found`)
- Endpoints de monitoreo (`Health Check`)
- Manejo de variables de entorno mediante `.env` y `.env.example`
- Colección completa de pruebas exportada en Postman Collection v2.1

## Estructura del Proyecto

- `src/main/java/com/example/reparatec2/controllers/`: Controladores REST
- `src/main/java/com/example/reparatec2/services/`: Lógica de negocio y uso de estructuras propias
- `src/main/java/com/example/reparatec2/models/`: Modelos de dominio
- `src/main/java/com/example/reparatec2/dto/`: Objetos de transferencia de datos (`Records`)
- `src/main/java/com/example/reparatec2/structures/`: Implementación de `CustomLinkedList` y `CustomStack`
- `postman/`: Colección exportada de Postman v2.1

## Autores

Jessica Cuahutle Romano
jessica.cuahutle.r@gmail.com

Ilde Rayón Cid
ilray930@gmail.com