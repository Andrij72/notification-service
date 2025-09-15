# 📩 Notification Service

**Notification Service** is a microservice responsible for consuming and processing Kafka events within the **MicroServiceGrid** ecosystem.  
It listens to the `order-placed` topic, deserializes events using **Avro**, and ensures reliable event-driven communication.

---

## 🚀 Features
- Consume `OrderPlacedEvent` messages from Kafka
- Deserialize messages using **Avro**
- Automatically generate Java classes from Avro schemas
- Type-safe deserialization with Spring Kafka
- Integration tests using **Testcontainers**
- Deployable via `docker-compose.override.yml`

---

## 🛠 Tech Stack
- **Java 21**
- **Spring Boot 3**
- **Spring Kafka**
- **Avro**
- **Docker Compose**
- **Testcontainers**

---

## ⚙️ Quick Start

### 1. Clone the repository

```bash
git clone https://github.com/Andrij72/notification-service.git
cd notification-service
```

### 2. Build the project
```bash
   ./mvnw clean install
```
### 3. Run with Docker Compose

The service runs as part of the shared microservices-net.
Docker will automatically pull the image from Docker Hub (andr72/notification-service:latest):
```bash
docker-compose -f docker-compose.override.yml up -d
```
---
### Kafka Topics

order-placed → Consumes OrderPlacedEvent

----

### Health Check

Spring Boot Actuator provides a health endpoint:

curl http://localhost:8089/actuator/health


Expected response:

{"status":"UP"}

---

### 📌 Ports Reference

|   | Service              | Port (host:container) |
|:--|----------------------|----------------------|
|   | Notification Service | 8089:8089            |

> Part of **MicroServiceGrid** with API Gateway, Order, Inventory, Product services.
----

### 👨‍💻 Author

Andrij72 — demo project exploring microservice architecture with Spring Boot, Kafka, and Avro.

----