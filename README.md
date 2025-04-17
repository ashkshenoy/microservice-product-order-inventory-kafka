# 🧱 Microservices Demo Application (Spring Boot + Kafka)

This is a basic microservices-based demo project built with Spring Boot. It demonstrates service-to-service communication using Eureka for service discovery, API Gateway for routing, and Apache Kafka for event-driven messaging.

---

## 🧩 Architecture Overview

This project consists of the following microservices:

### 🛒 Product Service
- Performs CRUD operations for products.
- Publishes a `product-created-event` to Kafka upon successful product creation.
- Depends on the **Core module** for shared models.
- Acts as a **Kafka Producer**.

### 📦 Inventory Service
- Manages inventory records.
- Performs basic CRUD operations.

### 📬 Order Service
- Manages orders and their statuses.
- Performs basic CRUD operations.

### 📣 Notification Service
- Listens to Kafka events (e.g., `product-created-event`) and reacts accordingly.
- Acts as a **Kafka Consumer**.
- Depends on the **Core module** for shared models.

### 🌐 API Gateway
- Handles routing and request forwarding to various microservices.
- Secures and simplifies access to backend services.

### 🧭 Eureka Server
- Acts as a service registry.
- Enables dynamic discovery of microservices.

### 🧩 Core Module
- Contains shared DTOs and models used across services (e.g., Product & Notification).

---

## 🔁 Kafka Integration

- When a product is created via the **Product Service**, it emits a Kafka event: `product-created-event`.
- The **Notification Service** listens to this topic and processes the event (e.g., logging, sending mock notifications).
- This showcases a simple event-driven communication flow using Kafka.

---

## ⚙️ Technologies Used

- **Spring Boot**
- **Spring Cloud Netflix (Eureka, Gateway)**
- **Apache Kafka**
- **H2 Database** (In-Memory)
- **Maven**
- **Postman** (for API testing)

---

## 🚫 Business Logic Note

> This project is intended for **learning and demonstration purposes only**.  
> Business logic is minimal or intentionally skipped to focus on:
- Microservices architecture
- Kafka integration
- Inter-service communication
- Basic modular code reuse

---

## 🚀 How to Run

1. **Start Kafka** (Docker recommended or via binaries)
2. Run Eureka Server
3. Run API Gateway
4. Start each microservice (Product, Order, Inventory, Notification)
5. Use Postman to test endpoints

---





