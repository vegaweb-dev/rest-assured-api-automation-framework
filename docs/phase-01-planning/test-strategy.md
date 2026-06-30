# Test strategy

## Purpose

This document defines the testing approach adopted by the API Automation
Framework. It establishes the scope, test organization, execution strategy,
quality criteria, and engineering principles that govern all automated tests
developed in this project.

## Objectives

The testing strategy aims to:

- Verify the functional behavior of the GoRest API.
- Detect regressions as early as possible.
- Validate API contracts.
- Ensure deterministic and reliable automated execution.
- Minimize flaky tests.
- Maximize long-term maintainability.

## Testing Scope

The automation suite covers the Users resource exposed by the stable GoRest
environment (`gorest.in`).
The strategy includes:

- CRUD operations
- Positive scenarios
- Negative scenarios
- Contract validation
- Integration scenarios
- HTTP protocol validation

## Test Levels

- Smoke Testing
- Functional Testing
- Integration Testing
- Contract Testing
- Regression Testing

## Test Types

- Positive tests
- Negative tests
- Boundary validations
- HTTP protocol validations
- Contract validations
- Error response validations

## Test Suites

The automated tests are organized into the following suites:

| Suite       | Purpose                                                                      |
|-------------|------------------------------------------------------------------------------|
| Smoke       | Verify that the API is operational and critical endpoints respond correctly. |
| CRUD        | Validate complete resource lifecycle operations.                             |
| Negative    | Verify validation rules and error handling.                                  |
| Contract    | Validate response structures against JSON Schemas.                           |
| Integration | Validate interactions across multiple API operations.                        |
| Regression  | Execute the complete automation suite before releases.                       |

## Test Data Strategy

Test data will be generated dynamically through Builders and Factories.
Tests must avoid hardcoded values whenever possible and remain independent from
previously executed scenarios.

## Test Independence

Every automated test must:

- Execute independently.
- Be repeatable.
- Be deterministic.
- Avoid dependencies on execution order.
- Create its own test data when required.

## Entry Criteria

A test may be implemented only when:

- The endpoint is documented.
- Expected behavior is understood.
- Test data requirements are defined.
- Expected HTTP responses are documented.

## Exit Criteria

A test is considered complete when:

- Assertions validate functional behavior.
- Contract validation passes.
- Test data is properly managed.
- No flaky behavior is observed.
- The test follows the project's engineering principles.

## Execution Strategy

| Suite       | Execution Frequency         |
|-------------|-----------------------------|
| Smoke       | Every Pull Request          |
| CRUD        | Every Pull Request          |
| Negative    | Every Pull Request          |
| Contract    | Every Pull Request          |
| Integration | Nightly                     |
| Regression  | Nightly and before releases |

## CI/CD Strategy

GitHub Actions will execute automated test suites according to the defined
execution strategy.
Execution results will be published through Allure Reports.

## Quality Gates

A Pull Request should not be merged when:

- Any Smoke test fails.
- Contract validation fails.
- Critical CRUD scenarios fail.
- Flaky tests are detected.

## Test Design Principles

The framework follows these principles:

- Tests express business intent.
- HTTP communication is encapsulated.
- Request and Response models are separated.
- Assertions are reusable.
- Configuration is externalized.
- JSON contracts are validated.
- WireMock supports deterministic contract testing.
- Every class has a single responsibility.
- Tests remain readable and maintainable.
-

## Out of Scope

- Performance testing
- Security testing
- UI automation
- Mobile automation
- Database validation
- Accessibility testing