# Folder Structure

## Purpose

This document defines the physical organization of the API Automation Framework.
It establishes the directory structure, package organization, and
responsibilities of each component to ensure consistency, maintainability, and
scalability.

## Scope

This document applies to the entire project structure, including source code,
test code, configuration files, documentation, schemas, reports, and supporting
resources.

## Overview

The framework is organized into logical directories that separate production
code,
test code, configuration, documentation, and generated artifacts. This
organization promotes separation of concerns and provides a consistent structure
for future framework evolution.

## Project Structure

The framework follows the standard Maven directory layout.

```text
rest-assured-api-automation-framework
│
├── docs/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   └── resources/
│   │
│   └── test/
│       ├── java/
│       └── resources/
│
├── target/
│
├── .gitignore
├── pom.xml
└── README.md
```

## Directory Responsibilities

| Directory          | Responsibility                                                   |
|--------------------|------------------------------------------------------------------|
| docs               | Framework documentation and architectural decisions.             |
| src/main/java      | Framework implementation and reusable components.                |
| src/main/resources | Configuration files, schemas, and shared resources.              |
| src/test/java      | Automated test implementation.                                   |
| src/test/resources | Test data, request payloads, and environment-specific resources. |
| target             | Generated build artifacts.                                       |

## Package Organization

The source code is organized into packages according to their responsibilities.
The package organization may evolve as the framework grows. Minor structural
changes are acceptable provided they preserve the architectural principles
defined for the project.

```text
src
│
├── main
│   ├── java
│   └── resources
│
└── test
    ├── java
    └── resources
```

The internal package organization will be defined during the framework
implementation phase. The structure may evolve as architectural decisions are
finalized, while preserving the organizational principles described in this
document.

Automated tests are organized by execution purpose.

```text
src/test/java
│
├── smoke
├── crud
├── negative
├── contract
└── integration
```

## Organization Principles

The project structure follows these principles:

- One responsibility per package.
- Production code and test code remain separated.
- Shared utilities are centralized.
- Test resources are isolated from framework implementation.
- Generated artifacts are never committed to version control.
- Documentation is maintained independently from the source code.

## Directory Rules

The following rules govern the project organization:

- Source code belongs under `src/main/java`.
- Automated tests belong under `src/test/java`.
- Configuration files belong under the appropriate `resources` directory.
- Documentation is stored under the `docs` directory.
- Build output is generated exclusively under `target`.
- Temporary or generated files must not be committed.

## Future Evolution

As the framework grows, new packages and directories may be introduced without
altering the overall organizational principles defined in this document.

Any structural change should preserve readability, maintainability, and
separation of concerns.

## Notes

This document defines the intended physical organization of the framework. Minor
structural adjustments may occur during implementation as new requirements
emerge, provided they remain consistent with the architectural principles
established in the project.