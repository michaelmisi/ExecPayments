# Java Banking Core Engine

A robust, object-oriented financial transaction engine built with modern Java. 

This repository serves as the core domain logic for a banking middleware system, designed to process and validate payment batches securely. It represents my strategic transition from Senior PHP Development to the Java/Mainframe ecosystem.

## Key Technical Features
- **Object-Oriented Design**: Heavy use of Polymorphism and Interfaces (`Payment` contract) to handle various transaction types (Credit Card, Express Transfers).
- **Financial Integrity**: Custom checked exceptions (`PaymentException`) to strictly enforce business rules (e.g., credit limits, positive amounts).
- **Functional Processing**: Utilization of the Java Stream API for clean, declarative, and efficient batch processing and financial reporting.
- **Clean Code**: Separation of concerns with dedicated utility classes and strict encapsulation.

## Current Roadmap
This core engine is currently being migrated to a fully-fledged Enterprise architecture:
1. Wrapping the core logic within a **Spring Boot 3** REST API.
2. Implementing data persistence using **Spring Data JPA / Hibernate**.
3. Adding an Audit Trail via Java NIO for legacy system synchronization (Flat file generation for COBOL integration).