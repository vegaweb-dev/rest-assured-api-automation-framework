# 🧪 REST Assured API Automation Framework



---

## 📊 Test Reporting & Observability
### 🔗 [Live CI Dashboard (Github Actions)](https://github.com/vegaweb-dev/rest-assured-api-automation-framework/actions/workflows/ci.yaml)
### 🔗 [Open the latest Allure Report](https://vegaweb-dev.github.io/rest-assured-api-automation-framework/)

---
## 🎯 Project Goals

- Build a scalable API automation framework.
- Apply industry-standard test architecture.
- Cover functional, contract and schema validation.
- Integrate with CI/CD using GitHub Actions.
- Document every design decision.
---

## 🛠️ Core Tech Stack & Architecture

The framework is engineered around a scalable, modular architecture using modern
enterprise tools:

* **Java 21** – Leverages modern language features (such as Record types for
  immutable DTOs) to enforce type safety and maintainable payloads.
* **REST Assured (5.x)** – Utilizes fluent validations, centralized
  Request/Response Specifications, and automated schema assertion.
* **JUnit 5** – Manages the test lifecycle with parallel execution capabilities
  and custom test tags (`@Smoke`, `@Regression`).
* **Jackson (ObjectMapper)** – Handles robust JSON serialization/deserialization
  with custom naming strategies to match dynamic API payloads.
* **Allure Report** – Integrated via Maven compiler plugins to automatically
  generate rich, detailed execution reports including step-by-step logs and
  attachments.
* **GitHub Actions** – Orchestrates the CI/CD pipeline, triggering automated
  test execution on every Pull Request and main branch update.

---

## ▶️ Running the Tests

### 1. Clone the repository

```bash
git clone https://github.com/vegaweb-dev/rest-assured-api-automation-framework.git
cd rest-assured-api-automation-framework
```

### 2. Run the complete test suite

```bash
mvn clean test
```
--- 


## 🏛️ Architectural Governance & Strategy

Engineering decisions within this framework are strictly governed by formal **Architecture Decision Records (ADRs)** to track technical context, trade-offs, and design compliance.


| ADR Reference                                                     | Architecture Domain | Strategic Decision | Status |
|:------------------------------------------------------------------| :--- | :--- | :--- |
| **[ADR-001](./docs/decisions/ADR-001-java-version.md)**           | Core Language Specification | Java 21 LTS Adoption | `🟢 Approved` |
| **[ADR-002](./docs/decisions/ADR-002-build-tool.md)**             | Build & <br/>Dependency Management | Maven as Standard Build Lifecycle | `🟢 Approved` |
| **[ADR-003](./docs/decisions/ADR-003-rest-client.md)**            | HTTP Client Automation | REST Assured for Fluent Validation | `🟢 Approved` |
| **[ADR-004](./docs/decisions/ADR-004-serialization.md)**          | Serialization <br/>Engine | Jackson Data-Binding Framework | `🟢 Approved` |
| **[ADR-005](./docs/decisions/ADR-005-builder-pattern.md)**        | Creational Design Patterns | Builder Pattern for Immutable Payloads | `🟢 Approved` |
| **[ADR-006](./docs/decisions/ADR-006-json-schema-validation.md)** | Contract Compliance | JSON Schema Validation Strategy | `🟢 Approved` |
| **[ADR-007](./docs/decisions/ADR-007-wiremock-adoption.md)**      | Service Simulation | WireMock for Hermetic Test Isolation | `🟢 Approved` |

---


## 📂 Extended Project Documentation

Beyond core code architecture, the repository contains end-to-end strategic documentation mapped across development phases. Click on each domain to explore the full specification:

### 🎯 Phase 00: Discovery
* **[Endpoint Catalog](./docs/phase-00-discovery/endpoint-catalog.md)** – Comprehensive mapping of target endpoints and resource URIs.
* **[Functional Inventory](./docs/phase-00-discovery/functional-inventory.md)** – Functional mapping of business rules and application logic.
* **[HTTP Status Catalog](./docs/phase-00-discovery/http-status-catalog.md)** – Explicit dictionary of expected REST API response codes and payloads.
* **[Resource Map](./docs/phase-00-discovery/resource-map.md)** – Data dependency mapping between upstream and downstream services.
* **[Risk Register](./docs/phase-00-discovery/risk-register.md)** – Identification and mitigation strategies for testing bottlenecks.

### 📋 Phase 01: Planning
* **[Coverage Matrix](./docs/phase-01-planning/coverage-matrix.md)** – Traceability matrix ensuring strict alignment between test cases and endpoints.
* **[Project Vision](./docs/phase-01-planning/project-vision.md)** – Core automated testing principles, project scoping, and high-level milestones.
* **[Test Environment](./docs/phase-01-planning/test-environments.md)** – Topology, variables, and dynamic configurations for Dev, QA, and Staging.
* **[Test Strategy](./docs/phase-01-planning/test-strategy.md)** – Test scoping, execution boundaries, data state initialization, and constraints.

### ⚙️ Phase 02: Architecture
* **[Core Architecture Layout](./docs/phase-02-architecture/architecture.md)** – Technical blueprint of the framework abstraction layers and HTTP engine.
* **[Contract Governance](./docs/phase-02-architecture/contract-governance.md)** – Enterprise rules for automated schema verification and change detection.
* **[Folder Structure Guide](./docs/phase-02-architecture/folder-structure.md)** – Onboarding documentation detailing the logical design of packages.
* **[WireMocks Strategy](./docs/phase-02-architecture/wiremocks-strategy.md)** – Mocking layout for hermetic isolation from flaky third-party components.

### 🚀 Phase 03: CI/CD & Infrastructure Operations
* **[Allure Reporting Strategy](./docs/phase-03-ci-cd/allure-reporting.md)** – Implementation specifications for dynamic test results, execution analytics, and trends history.
* **[GitHub Actions Integration](./docs/phase-03-ci-cd/github-actions.md)** – Workflow architecture detailing triggers, runners, security context, and environmental secret mapping.
* **[Pipeline Definition](./docs/phase-03-ci-cd/pipeline.md)** – End-to-end automation cycle documentation, tracking job execution and test lifecycles.
---

## 📈 Project Status

### Completed

* [x] Project architecture and documentation foundation
* [x] API discovery and test planning
* [x] Test strategy and coverage documentation
* [x] Architecture Decision Records (ADRs 001–007)
* [x] Java 21 + Maven setup
* [x] REST Assured configuration & reusable request specifications
* [x] `UserClient` HTTP abstraction layer
* [x] User CRUD smoke tests (Happy Path Validation)
* [x] Test isolation and dynamic cleanup setup
* [x] GitHub Actions CI pipeline & quality gates
* [x] Allure reporting & GitHub Pages report publication

### 🚧 Next

* [x] Full CRUD suite expansion (Deep positive path checks for all 6 HTTP 
  methods)
* [ ] Negative testing & error response validations
* [ ] Contract testing & JSON Schema validation integration
* [ ] API virtualization with WireMock for hermetic isolation
* [ ] Environment-specific configuration profile swapping (Dev, QA, Prod)
* [ ] Parallel execution configuration via JUnit 5 engine
* [ ] Full Regression suite consolidation for automated execution

