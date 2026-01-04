# 👤 User Service

The **User Service** is a core microservice responsible for managing **user profile data** and **monthly budget information**.  
It maintains user-related state required by the application and stays synchronized with the authentication system through **event-driven communication**.

This service **consumes user-related events** published by the Auth Service via **Apache Kafka**, ensuring loose coupling and avoiding direct dependencies between services.

---

## ✨ Responsibilities

This service is responsible for:

- Storing and managing **user profile information**
- Setting and retrieving **monthly user budgets**
- Consuming **user authentication events** from Auth Service
- Persisting user identity data after signup/login
- Providing user-related APIs to other services

This service **does not handle authentication or token management**.

---

## 🔁 Event-Driven User Sync Flow

1. User signs up or logs in via Auth Service
2. Auth Service publishes a user event to Kafka
3. User Service consumes the event
4. User data is created or updated in the database
5. User budget APIs become available

# Kafka Flow (WORKING): Auth Service → User Service
## 1. Current Status

✅ **Auth Service is producing events**  
✅ **Kafka is delivering events**  
✅ **User Service is consuming events successfully**  
✅ **User data is persisted in user-service database**
This flow is **live and working**.
## 2. Active Event Flow

Auth Service(UserInfoEvent) ---> Kafka Topic ---> User Service ---> User Database

## 🧩 Tech Stack

- **Language**: Java  
- **Framework**: SpringBoot  
- **Messaging**: Apache Kafka 
- **Database**: MySQL 
- **Build Tool**: Maven   


