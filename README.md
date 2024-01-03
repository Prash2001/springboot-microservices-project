# Microservices Architecture with Spring Boot

Welcome to the Microservices Architecture project built on Spring Boot. This project is designed to demonstrate the implementation of a microservices-based system, showcasing best practices for building scalable, resilient, and modular applications.

## Project Overview

### 1. Microservices Foundation
Utilizing Spring Boot, this project embraces a microservices architecture designed for agility and modularity.

### 2. API Gateway and Service Discovery
A Spring Cloud Gateway handles routing and load balancing as the API Gateway, while Eureka facilitates service discovery for seamless communication.

### 3. Microservices Components
Core microservices include Product, Order, Inventory, and Notification services, each with dedicated databases and resilience through Resilience4j.

### 4. Backend Technologies
Java and Spring technologies, along with Kafka for event-driven communication, form the backbone of the robust backend services.

### 5. Security Measures
OAuth 2.0 ensures resource security, and Keycloak is integrated for streamlined user authentication across microservices.

### 6. Monitoring and Tracing
Micrometer collects application metrics, while Zipkin provides distributed tracing, ensuring insights into the system's performance.

### 7. Containerization and Orchestration
Docker and Docker Compose facilitate containerization and orchestration, ensuring consistent deployment across diverse environments.

### 8. Infrastructure as Code
Docker Compose, along with provided YAML configurations, ensures easy reproducibility and scalability, embodying modern software architecture principles.

## Getting Started

Follow these steps to set up and run the project on your local machine.

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/yourusername/microservices-project.git
   cd microservices-project
   ```
2. **Docker Compose:**
   - Create a `docker-compose.yml` file at the root of your project with the necessary configurations for each service. Here's a basic example:
     ```yaml
     version: '3'
     services:
       grafana:
         image: grafana/grafana:latest
         volumes:
           - ./grafana:/var/lib/grafana
         ports:
           - "3000:3000"
         environment:
           GF_SECURITY_ADMIN_PASSWORD: your_grafana_password

       mongodb:
         image: mongo:latest
         volumes:
           - ./mongo-data:/data/db
         ports:
           - "27017:27017"
         environment:
           MONGO_INITDB_ROOT_USERNAME: your_mongo_username
           MONGO_INITDB_ROOT_PASSWORD: your_mongo_password

       mysql_keycloak:
         image: mysql:latest
         volumes:
           - ./mysql_keycloak_data:/var/lib/mysql
         ports:
           - "3306:3306"
         environment:
           MYSQL_ROOT_PASSWORD: your_mysql_password

       postgres_inventory:
         image: postgres:latest
         volumes:
           - ./postgress-inventory:/var/lib/postgresql/data
         ports:
           - "5432:5432"
         environment:
           POSTGRES_USER: your_postgres_user
           POSTGRES_PASSWORD: your_postgres_password
           POSTGRES_DB: your_inventory_db_name

       postgres_order:
         image: postgres:latest
         volumes:
           - ./postgress-order:/var/lib/postgresql/data
         ports:
           - "5433:5432"
         environment:
           POSTGRES_USER: your_postgres_user
           POSTGRES_PASSWORD: your_postgres_password
           POSTGRES_DB: your_order_db_name

       prometheus:
         image: prom/prometheus:latest
         volumes:
           - ./prometheus:/etc/prometheus
         ports:
           - "9090:9090"

       keycloak:
         image: jboss/keycloak:latest
         volumes:
           - ./realms:/opt/jboss/keycloak/standalone/configuration/realms
         ports:
           - "8080:8080"
         environment:
           KEYCLOAK_USER: your_keycloak_admin_user
           KEYCLOAK_PASSWORD: your_keycloak_admin_password
     ```


3. **Run Docker Compose:**
   ```bash
   docker-compose up -d
   ```

4. **Access Microservices:**
   - Start all the services
   - Navigate to the API Gateway: `http://localhost:8080`
   - Explore individual microservices through their respective endpoints.


---

Thank you for exploring our Microservices Architecture project. We hope this serves as a valuable resource for understanding and implementing microservices using Spring Boot.
