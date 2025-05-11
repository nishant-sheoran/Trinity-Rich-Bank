# Trinity Rich Bank ATM Simulator

## Overview
Trinity Rich Bank is a robust, Java-based ATM Simulator that replicates real-world banking operations. This project has been modernized to follow industry best practices, making it modular, readable, and scalable. It is designed to work independently as a full-featured ATM simulation, while also being future-ready for integration with AI/ML models and other advanced features.

## Key Features
- **Standalone ATM Simulator:** Fully functional for account management, deposits, withdrawals, mini statements, PIN changes, and more.
- **Modern Java Codebase:** Uses Gradle, Java 17+, and up-to-date dependencies for security and maintainability.
- **Modular Architecture:** Clear separation of UI, service, DAO, and integration layers for easy maintenance and extensibility.
- **Industry-Standard Practices:** JDBC for database access, Swing for UI, and REST client scaffolding for future integrations.
- **Future-Ready:** Designed to easily integrate with Python-based AI/ML models (e.g., for fake note detection) via REST API, but works perfectly as a standalone Java project.

## Tech Stack
| Component | Technology |
|-----------|------------|
| Frontend  | Java Swing (UI) |
| Backend   | Java (Core, JDBC, REST Client) |
| Database  | MySQL |
| ML Model (future) | TensorFlow/Keras (Python) |
| API (future) | Flask/FastAPI (Python) |
| Integration (future) | REST API (Java ↔ Python) |

## Project Structure
```
src/ASimulatorSystem/
  ui/           # UI classes (Login, Signup, Transactions, Deposit, etc.)
  service/      # Business logic (DepositService, AuthService, etc.)
  dao/          # Database access (DatabaseConnection, etc.)
  integration/  # REST API client for future ML model (MLNoteVerifier)
```

## Setup Instructions
### 1. Java Application
- Install JDK 17 or later
- Install Gradle
- Configure MySQL and update credentials in `DatabaseConnection.java`
- Build and run:
  ```sh
  gradle build
  gradle run
  ```

### 2. (Optional, Future) Python ML API
- If/when you want to add AI/ML features, set up your Python model (Flask/FastAPI) and expose a REST endpoint.
- The Java app is ready to communicate with such an API for features like fake note detection.

## UI/UX Modernization
- All screens use modern Swing layouts and components for a better user experience.
- Consistent look and feel across all operations.

## Contributing & Extending
- The modular codebase makes it easy to add new features, integrate with other systems, or use as a base for future projects.
- See code comments and JavaDoc for guidance.

## License
MIT

