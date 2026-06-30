# Wiremocks strategy

## Purpose

This document defines the strategy for using WireMock within the API Automation
Framework. It establishes when service virtualization should be used, how mock
services are managed, and the principles that govern their maintenance.

## Scope

This document applies to all automated tests that require service
virtualization, deterministic API behavior, or execution independent of external
system availability.

## Overview

WireMock provides a controllable HTTP server that simulates API behavior without
relying on external services. It enables deterministic, repeatable, and isolated
test execution by returning predefined responses under controlled conditions.

Within this framework, WireMock complements—but does not replace—testing against
the real API.

## Objectives

The WireMock strategy is designed to achieve the following objectives:

- Improve test reliability.
- Eliminate dependency on unstable external services.
- Enable deterministic test execution.
- Simulate edge cases that are difficult to reproduce.
- Support offline development.
- Accelerate automated test execution.
- Facilitate CI/CD pipeline execution.

## When WireMock Should Be Used

WireMock should be used when:

- External services are unavailable.
- API responses are unstable.
- Specific error scenarios must be reproduced.
- Response delays need to be simulated.
- Performance-independent functional testing is required.
- Development requires isolated execution.

## When the Real API Should Be Used

The real API should be used when:

- Verifying end-to-end behavior.
- Validating real business workflows.
- Executing smoke tests.
- Confirming production-like integration.
- Performing exploratory validation.

## Mock Management

Mock definitions should follow these principles:
- One mapping per endpoint behavior.
- Mock responses should remain human-readable.
- Response payloads should reflect realistic API behavior.
- Unused mappings should be removed.
- Mock data should remain deterministic.

## Recording Strategy

Whenever possible, mock responses should be based on real API interactions.

Recorded responses should be:
- Reviewed before inclusion.
- Cleaned of unnecessary information.
- Version controlled.
- Updated when API contracts change.

## Directory Organization

WireMock resources should be organized separately from the framework source
code.

A typical organization includes:

```text
wiremock
│
├── mappings
└── __files
```

## Maintenance Guidelines

The following maintenance practices apply:
- Keep mappings small and focused.
- Avoid duplicated mock definitions.
- Remove obsolete mappings.
- Synchronize mappings with API contract changes.
- Review mocks during pull requests.

## CI/CD Integration

WireMock may be executed during automated pipeline execution to provide stable
and repeatable test environments.

The CI/CD pipeline should be capable of executing tests against:

- Mock services.
- Real API environments.
- Both environments when required.

## Future Evolution

As the framework evolves, additional virtualization capabilities may be
incorporated, including dynamic response generation, fault simulation, and
advanced request matching.

The virtualization strategy should continue prioritizing determinism,
maintainability, and reproducibility.

## Notes

WireMock is intended to increase the reliability and stability of automated
testing. It complements real API validation by enabling controlled execution
scenarios that are difficult or impossible to reproduce consistently using live
services.