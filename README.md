
<div align="center">

# Planora

### Plan. Organize. Achieve.

**A smarter way to organize lessons, teams and activities.**

Planora is a modern desktop planning application designed for schools, clubs and organizations. It brings people, topics and activities together in one structured workspace — making planning easier, clearer and more efficient.

<br/>

[![Java](https://img.shields.io/badge/Java-25-orange?logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-3.9%2B-C71A36?logo=apachemaven&logoColor=white)](https://maven.apache.org/)
[![Platform](https://img.shields.io/badge/Platform-Desktop-blue)]()
[![Status](https://img.shields.io/badge/Status-In%20Development-yellow)]()
[![GitHub](https://img.shields.io/badge/GitHub-Timonexus-181717?logo=github)](https://github.com/timonexus)

<br/>

[**Explore the Project**](https://github.com/timonexus/Planora)
·
[**Report an Issue**](https://github.com/timonexus/Planora/issues)

</div>

---

## Overview

Planning activities across different people, groups and topics can quickly become complicated. Information gets scattered, responsibilities become unclear and keeping everything organized takes time.

**Planora aims to solve exactly that problem.**

Whether you organize lessons at a school, coordinate training sessions in a club or manage recurring activities within an organization, Planora provides a centralized environment to structure your planning process.

Instead of juggling multiple tools and disconnected documents, Planora brings the essential elements of your organization together.

### One platform. Better organization.

- **Centralized Planning** – Keep important planning information organized in one place.
- **People & Groups** – Structure your organization around instructors, members and groups.
- **Topics & Activities** – Organize learning content and planned activities.
- **Structured Data** – Maintain relationships between groups, topics and activities.
- **Desktop Experience** – Work in a dedicated application with a consistent user interface.

*These capabilities represent the product direction; individual features are being developed incrementally.*

---

## Who is Planora for?

Planora is designed for organizations that regularly plan activities involving people, groups and different topics.

| Target Group | Potential Use Cases |
|---|---|
| Schools | Organizing lessons, teachers and learning topics |
| Clubs & Associations | Planning activities, meetings and training sessions |
| Youth Organizations | Coordinating training, groups and educational activities |
| Training Organizations | Structuring instructors, courses and learning content |
| Teams & Communities | Keeping recurring activities and responsibilities organized |

The goal is to make structured planning accessible without requiring complicated enterprise software.

---

## Key Features

Planora is actively being developed. The following areas describe its current development focus and planned capabilities.

### Organization Management

- Manage groups and their associated information.
- Organize instructors and responsibilities.
- Maintain structured relationships between organizational entities.

### Topics & Learning Content

- Create and manage topics.
- Associate topics with relevant qualifications or learning objectives.
- Structure educational content for different groups.

### Activity Planning

- Organize training sessions and activities.
- Associate activities with groups, instructors and topics.
- Maintain structured attendance information.

### Data Management

- Persistent local data storage.
- Structured relational data management.
- A modular foundation for future functionality.

### User Interface

- Modern dark desktop interface.
- Reusable custom Swing components.
- Consistent navigation and component styling.
- Custom table components designed for structured data presentation.

---

## Technology Stack

Planora is built using established technologies with a focus on maintainability, modularity and long-term development.

| Technology | Purpose |
|---|---|
| Java 25 | Core application and business logic |
| Java Swing | Desktop user interface |
| FlatLaf | Modern Swing look and feel |
| Maven | Dependency and build management |
| SQLite | Local relational database |
| JDBC | Database connectivity |
| JUnit 5 | Automated testing |

### Architecture & Development Principles

Planora follows a modular development approach.

The project aims to maintain a clear separation between:

- User interface and presentation logic
- Application services and business logic
- Data access and persistence
- Reusable utilities and shared components

Maintainability, readable code and extensibility are important principles throughout development.

---

## Getting Started

Planora is currently in active development. The following instructions allow developers to obtain and build the project.

### Prerequisites

Make sure you have installed:

- [Java Development Kit 25](https://adoptium.net/)
- [Apache Maven 3.9 or newer](https://maven.apache.org/)
- [Git](https://git-scm.com/)

Verify your installations:

```bash
java -version
mvn -version
git --version
```

### Clone the Repository

```bash
git clone https://github.com/timonexus/Planora.git
```

Navigate into the project directory:

```bash
cd Planora
```

### Build the Project

Run the Maven verification lifecycle:

```bash
mvn clean verify
```

This compiles the project, executes the configured tests and verifies the build.

**Note:** A stable end-user installation package and distribution process are not yet available.

---

## Project Structure

Planora is organized into modular packages to keep responsibilities separated and the codebase maintainable.

The exact structure is evolving as development progresses.

```text
Planora/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── de/
│   │   │       └── timonexus/
│   │   │           └── planora/
│   │   │               ├── database/
│   │   │               ├── service/
│   │   │               ├── ui/
│   │   │               └── utils/
│   │   │
│   │   └── resources/
│   │       ├── icons/
│   │       └── sql/
│   │
│   └── test/
│       └── java/
│
├── pom.xml
└── README.md
```

---

## Roadmap

Planora is being developed incrementally. The roadmap describes the intended direction of the project and is subject to change.

- [x] Initialize the Maven project
- [x] Establish the Java desktop application foundation
- [x] Implement the initial application window
- [x] Establish the database foundation
- [x] Develop reusable UI components
- [ ] Complete core organization management
- [ ] Expand group and instructor management
- [ ] Complete topic management
- [ ] Develop the activity planning workflow
- [ ] Implement calendar functionality
- [ ] Add advanced search and filtering
- [ ] Improve data export capabilities
- [ ] Add reliable backup and recovery mechanisms
- [ ] Prepare a stable application release

---

## Development Status

<details>
<summary><strong>Current project status</strong></summary>

Planora is actively developed and has not yet reached its first stable release.

The current focus is on building a reliable technical foundation, implementing the core data structures and developing a consistent user interface.

Features, architecture and workflows may change as the project evolves.

The repository is primarily intended for development and technical evaluation at this stage.

</details>

---

## Contributing & Feedback

Feedback and ideas are valuable for making Planora better.

If you discover a bug, have an idea for an improvement or want to discuss a potential feature, feel free to open an issue.

- [Report a Bug](https://github.com/timonexus/Planora/issues)
- [Suggest a Feature](https://github.com/timonexus/Planora/issues)
- [Explore the Source Code](https://github.com/timonexus/Planora)

Please check existing issues before creating a new one.

---

## License

A formal license has not yet been published.

Until a license is added to the repository, all rights remain with the respective copyright holder. Do not assume that the source code is licensed for redistribution or modification.

---

<div align="center">

## Plan better. Work smarter.

**Planora — Bringing structure to your planning.**

<br/>

Developed with care by **[Timonexus](https://github.com/timonexus)**

</div>
