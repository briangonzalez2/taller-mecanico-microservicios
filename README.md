# Taller Mecánico - Sistema de Gestión con Microservicios

[![Java](https://img.shields.io/badge/Java-17-blue.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-green.svg)](https://spring.io/projects/spring-boot)
[![Docker](https://img.shields.io/badge/Docker-Containerized-blue.svg)](https://www.docker.com/)

## Descripción del Proyecto

Este proyecto implementa un **sistema de gestión para un taller mecánico automotriz** utilizando una **arquitectura de microservicios**. El objetivo es proporcionar una solución modular, escalable y mantenible que permita administrar:

- Usuarios (clientes y empleados)
- Vehículos de los clientes
- Órdenes de servicio y reparaciones
- Catálogo de repuestos y servicios ofrecidos

Cada funcionalidad está encapsulada en un microservicio independiente, facilitando el desarrollo paralelo, el mantenimiento y una posible escalabilidad futura.

**Estado actual**: Los microservicios son funcionales y se comunican entre sí. Falta desarrollar la interfaz de usuario (frontend).

## Arquitectura

- **Microservicios**:
  - `users-service`: Gestión de usuarios (registro, autenticación básica, perfiles).
  - `vehicleservice`: Registro y consulta de vehículos (marca, modelo, placa, historial).
  - `orderservice`: Creación, seguimiento y gestión de órdenes de reparación.
  - `catalog-service`: Administración del catálogo de repuestos y servicios.

- **Comunicación**: Llamadas HTTP REST entre servicios.
- **Base de datos**: Cada microservicio cuenta con su propia base de datos (configurada para desarrollo con H2 o PostgreSQL/MySQL).
- **Contenedorización**: Docker para cada servicio.
- **Orquestación**: Docker Compose para levantar todo el sistema localmente.

## Tecnologías Utilizadas

- **Lenguaje**: Java 17+
- **Framework**: Spring Boot (Spring Web, Spring Data JPA, Lombok, etc.)
- **Gestión de dependencias**: Maven
- **Contenedorización**: Docker y Docker Compose
- **Base de datos**: H2 (desarrollo) / PostgreSQL o MySQL (producción)
- **Otras**: Posible uso de OpenFeign para llamadas entre servicios, Spring Security básico.

## Estructura del Repositorio


taller-mecanico-microservicios/
├── catalog-service/      # Microservicio de catálogo de repuestos
├── orderservice/         # Microservicio de órdenes de servicio
├── users-service/        # Microservicio de usuarios
├── vehicleservice/       # Microservicio de vehículos
├── docker-compose.yml    # Orquestación de todos los contenedores
├── README.md             # Este archivo
└── .gitignore



Cada carpeta de microservicio contiene un proyecto Spring Boot completo con:
- `src/main/java` (entidades, repositorios, servicios, controladores)
- `pom.xml`
- `Dockerfile`
- `application.properties` / `application.yml`

## Requisitos Previos

- Java 17 o superior
- Maven 3.8+
- Docker y Docker Compose

## Cómo Ejecutar el Proyecto

1. Clona el repositorio:
   ```bash
   git clone https://github.com/briangonzalez2/taller-mecanico-microservicios.git
   cd taller-mecanico-microservicios


2. Levanta todos los microservicios con Docker Compose:
  docker-compose up --build

3. Esto creará y ejecutará los contenedores para los 4 microservicios (puertos predeterminados: 8080, 8081, 8082, 8083 según configuración).
Los servicios estarán disponibles en:
Users Service: http://localhost:8081 (ajustar según tu docker-compose)
Vehicle Service: http://localhost:8082
Order Service: http://localhost:8083
Catalog Service: http://localhost:8084

4. Pruebas: Usa herramientas como Postman o curl para probar las APIs REST de cada servicio.
Pruebas de Ejemplo (Endpoints básicos)

Users Service:
GET /api/users → Lista todos los usuarios
POST /api/users → Crea un nuevo usuario

# Contribuyentes

Manuel Jesús Rosero Zúñiga
Brian Esteban González Benavides
Diego Alejandro Parra Ríos
