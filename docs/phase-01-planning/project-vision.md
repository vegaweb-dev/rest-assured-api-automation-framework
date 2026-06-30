# Project vision

## Purpose

This document defines the vision, objectives, engineering principles, and
quality goals of the API Automation Framework. It serves as the primary
reference for architectural and implementation decisions throughout the project
lifecycle.

## Project Objectives

The objective of this project is to design and implement a production-inspired
REST API automation framework using Java, REST Assured, and JUnit 5.
The framework is intended to demonstrate software engineering practices commonly
adopted by QA Automation and SDET teams, emphasizing maintainability,
scalability, readability, and reliability over rapid implementation.
The project aims to simulate the development process followed in professional
environments, where documentation, architecture, governance, and test strategy
are established before implementation begins.

## Scope

The framework will automate the stable GoRest API (`gorest.in`) and will include
functional, negative, contract, and integration tests for the Users resource.
The project also includes documentation, API client abstraction, JSON Schema
validation, WireMock integration, Allure reporting, GitHub Actions pipelines,
and engineering documentation required to support long-term maintainability.

## Non-Goals

This project is not intended to:

- Build performance or load tests.
- Replace dedicated security testing.
- Automate UI workflows.
- Cover business scenarios outside the exposed REST API.
- Demonstrate every REST Assured feature available.
- Build a generic automation framework for every possible API.
  Instead, the project focuses on building a high-quality automation framework
  around a realistic REST API.

## Quality Attributes

- Reliability
- Maintainability
- Scalability
- Readability
- Reusability
- Deterministic execution
- Low test flakiness
- Clear separation of responsibilities
- High documentation quality.

## Engineering Principles

The framework will be developed according to the following principles:

- Tests express business intent rather than implementation details.
- HTTP communication is encapsulated behind reusable API clients.
- Request and Response DTOs are separated.
- Test data is generated through Builders or Factories.
- Configuration is externalized.
- JSON contracts are validated using JSON Schema.
- WireMock recordings are used to support deterministic contract validation.
- Every class has a single responsibility.
- Duplicate logic is eliminated through reusable abstractions.
- Tests remain independent and executable in any order.
- Architectural decisions prioritize long-term maintainability over short-term
  convenience.
-

## Technology Stack

| Category            | Technology             |
|---------------------|------------------------|
| Language            | Java 21                |
| Build Tool          | Maven                  |
| Test Framework      | JUnit 5                |
| HTTP Client         | REST Assured           |
| Serialization       | Jackson                |
| Assertions          | AssertJ + REST Assured |
| Contract Validation | JSON Schema Validator  |
| API Virtualization  | WireMock               |
| Reporting           | Allure Report          |
| CI/CD               | GitHub Actions         |
| Version Control     | Git                    |
| IDE                 | IntelliJ IDEA          |

## Success Criteria

- A modular and extensible architecture.
- Stable and deterministic automated tests.
- Comprehensive documentation.
- High-quality engineering practices.
- Automated execution through GitHub Actions.
- Rich execution reports using Allure.
- Contract validation through JSON Schema.
- Support for future API resources without architectural redesign.

## Future Evolution

The architecture should allow future expansion to additional API resources,
environments, authentication mechanisms, reporting integrations, and testing
strategies without requiring significant structural changes.
Future enhancements should preserve backward compatibility whenever possible and
follow the engineering principles defined in this document.