# Notification Service

**Notification Service** is a microservice responsible for consuming and processing Kafka events within the **MicroServiceGrid** ecosystem.  
It ensures reliable handling of `OrderPlacedEvent` messages and uses **Avro** format for event serialization/deserialization.

---

## 🚀 Features
- Consume `OrderPlacedEvent` messages from Kafka
- Serialize/deserialize events using **Avro** format
- Automatically generate Java classes from Avro schemas
- Configured Kafka consumer with type-safe deserialization
- Replaces old manual JSON-based deserialization

---

## 🛠️ Tech Stack
- **Java 21**
- **Spring Boot 3**
- **Spring Kafka** for event-driven communication
- **Avro** for schema definition and serialization
- **Testcontainers** for Kafka integration testing
- **Docker** compatible

---

## ⚙️ Quick Start
1. Clone the repo:
```bash

 git clone https://github.com/Andrij72/notification-service.git
 cd notification-service
``` 
2. Build the project:
```bash
./mvnw clean install
``` 

3. Run the service:
```bash
./mvnw spring-boot:run
```

Kafka consumer listens to the order-placed topic and processes OrderPlacedEvent.

---
👨‍💻 Author: Andrij72 — demo project exploring microservice architecture with Spring Boot, Kafka, and Avro.