# Risk register

## Purpose
This document identifies the functional and technical risks associated with the
GoRest API used in this project. It also defines mitigation strategies to reduce
flaky tests, improve reliability, and ensure maintainable API automation.

## Scope
This risk assessment covers the stable GoRest environment (`gorest.in`),
including API behavior, test data management, HTTP communication, and
environmental limitations that may affect automated test execution.

## Overview
Although the stable GoRest environment is designed for API automation practice,
automated tests may still be affected by incorrect assumptions, invalid test
data, network conditions, or changes in API behavior.
Identifying these risks before implementing the framework helps build reliable,
deterministic, and maintainable automated tests.

## Risk Register
| ID | Risk | Category | Impact | Probability | Mitigation Strategy |
|----|------|----------|--------|-------------|---------------------|
| R-001 | API contract changes without notice | Functional | High | Low | Validate responses using JSON Schema Validation and contract assertions. |
| R-002 | Invalid or inconsistent test data | Functional | High | Medium | Generate test data through Builders and Factories instead of hardcoded values. |
| R-003 | Incorrect authentication configuration | Technical | High | Medium | Centralize authentication in the API Client layer. |
| R-004 | Rate limiting reached during execution | Infrastructure | Medium | Low | Control execution frequency and avoid unnecessary requests. |
| R-005 | Network instability during test execution | Infrastructure | Medium | Low | Keep tests independent and avoid assumptions about execution timing. |
| R-006 | Incorrect request payloads | Functional | High | Medium | Validate DTO serialization and use strongly typed request models. |
| R-007 | Duplicate test logic | Maintainability | Medium | Medium | Centralize reusable assertions, builders and API client methods. |
| R-008 | Hardcoded environment configuration | Maintainability | High | Medium | Externalize configuration using properties and environment variables. |
| R-009 | Flaky tests caused by shared state | Functional | High | Low | Design independent tests and create fresh data whenever possible. |
| R-010 | Regression caused by API changes | Functional | High | Medium | Execute contract validation and regression suites in CI pipelines. |

## Risk Assessment Summary
| Risk Level | Definition |
|------------|------------|
| High | Can compromise the reliability or correctness of the automation framework. |
| Medium | May affect execution stability or increase maintenance effort. |
| Low | Limited impact with straightforward mitigation strategies. |