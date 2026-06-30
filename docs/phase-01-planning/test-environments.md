# Test environment

## Purpose

This document describes the environments used by the API Automation Framework,
including their configuration, authentication requirements, operational
constraints, and execution guidelines.

## Scope

This document applies to every automated test executed by the framework against
the GoRest Stable API and any future environments incorporated into the project.

## Available Environments

| Environment   | Purpose                                                   | Status  |
|---------------|-----------------------------------------------------------|---------|
| GoRest Stable | Primary environment for development and automated testing | Active  |
| WireMock      | Offline execution and contract validation                 | Planned |

## Environment Configuration

| Property       | Value                                |
|----------------|--------------------------------------|
| Base URL       | https://gorest.in/public/v2/users    |
| Protocol       | HTTPS                                |
| API Format     | JSON (default), XML (optional)       |
| Authentication | Bearer Token (write operations only) |

The framework will externalize all environment-specific configuration using
properties files and environment variables.

## Authentication

Authentication requirements are determined by the HTTP operation.

| Method | Authentication Required |
|--------|-------------------------|
| GET    | No                      |
| POST   | Yes                     |
| PUT    | Yes                     |
| PATCH  | Yes                     |
| DELETE | Yes                     |

For testing purposes, the stable GoRest environment accepts any non-empty bearer
token except the reserved value `blocked-token`, which intentionally returns
`403 Forbidden`.

## Data Management

The GoRest Stable API stores data in memory only.

As a result:

- Test data is not permanently persisted.
- The dataset may be reset when the server restarts.
- Seed users are available for read operations.
- Tests should create their own data whenever required.
- Tests must not depend on previous executions.

## Environment Constraints

The following operational limitations must be considered during test design.

| Constraint        | Description               |
|-------------------|---------------------------|
| Rate Limit        | 60 requests per minute    |
| Seed Data         | Users with IDs 1001–1020  |
| Pagination        | Default 10 items per page |
| Maximum Page Size | 100                       |
| Supported Formats | JSON and XML              |

## Execution Guidelines

All automated tests should:

- Execute against the configured environment only.
- Avoid hardcoded URLs.
- Avoid hardcoded authentication tokens.
- Remain independent of execution order.
- Respect rate-limiting constraints.
- Generate their own test data when applicable.

## Notes

Additional environments may be incorporated in future versions of the framework.
All environment-specific behavior must remain isolated from the test
implementation through externalized configuration.