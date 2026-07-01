# ADR 007 Wiremock Adoption

## Status

Accepted

## Context

The API Automation Framework requires a reliable strategy for executing
automated tests independently from external service availability.

Relying exclusively on the live GoRest API may introduce instability, rate
limiting, network variability, and external data modifications that reduce test
reliability and reproducibility.

The framework requires a mechanism that enables deterministic execution while
preserving the ability to validate real API behavior when necessary.

## Decision

The framework adopts WireMock as its service virtualization solution.

WireMock will be used to simulate HTTP services during automated testing
whenever deterministic behavior, offline execution, fault simulation, or
controlled API responses are required.

Tests may execute against either the real API or WireMock depending on the
testing objective.

## Alternatives Considered

### Real API Only

**Advantages**

- Simple implementation.
- Validates real integration behavior.
- No mock maintenance required.

**Disadvantages**

- External service instability.
- Network dependency.
- Rate limiting.
- Non-deterministic test execution.
- Difficult to reproduce specific error scenarios.

### WireMock + Real API

**Advantages**

- Deterministic execution.
- Stable automated tests.
- Offline development.
- Fault and latency simulation.
- Faster CI/CD execution.
- Controlled response scenarios.
- Preserves real integration validation when required.

**Disadvantages**

- Mock mappings require maintenance.
- Recorded responses must be updated when contracts change.

## Consequences

### Positive

- Improved test reliability.
- Reduced flaky tests.
- Faster automated execution.
- Better developer experience.
- Ability to simulate edge cases.
- Stable Continuous Integration pipelines.

### Negative

- Additional framework configuration.
- Mock definitions require version control.
- Contract changes require mock synchronization.

## References

- WireMock Documentation.
- WireMock Strategy.
- Contract Governance.
