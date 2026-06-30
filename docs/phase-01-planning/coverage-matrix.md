# Coverage matrix

## Purpose

This document defines the test coverage planned for the GoRest API used in this
project. It maps each endpoint to the corresponding test suites, ensuring that
all relevant functionality is validated without unnecessary duplication.

## Scope

This matrix covers every endpoint exposed by the stable GoRest environment (
`gorest.in`) and identifies the types of automated tests that will validate each
operation throughout the framework lifecycle.

## Coverage Criteria

The framework provides coverage for the following testing categories:

- Smoke Testing
- CRUD Validation
- Negative Testing
- Contract Validation
- Integration Testing
- Regression Testing

## Coverage Matrix

| Endpoint           | Smoke | CRUD | Negative | Contract | Integration | Regression |
|--------------------|:-----:|:----:|:--------:|:--------:|:-----------:|:----------:|
| GET /users         |   ✓   |  ✓   |    ✓     |    ✓     |      ✓      |     ✓      |
| GET /users/{id}    |   ✓   |  ✓   |    ✓     |    ✓     |      ✓      |     ✓      |
| POST /users        |   ✓   |  ✓   |    ✓     |    ✓     |      ✓      |     ✓      |
| PUT /users/{id}    |   ✓   |  ✓   |    ✓     |    ✓     |      ✓      |     ✓      |
| PATCH /users/{id}  |   ✓   |  ✓   |    ✓     |    ✓     |      ✓      |     ✓      |
| DELETE /users/{id} |   ✓   |  ✓   |    ✓     |    ✓     |      ✓      |     ✓      |

## Coverage Summary

The framework provides complete functional coverage for all CRUD operations
exposed by the Users resource.
Each endpoint is validated through positive, negative, contract, integration,
and regression scenarios to ensure both functional correctness and API contract
compliance.
