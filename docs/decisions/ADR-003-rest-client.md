# ADR 003 Rest Client

## Status

Accepted

## Context

The API Automation Framework requires a consistent and maintainable mechanism
for communicating with REST APIs.

Directly invoking REST Assured from test classes would increase code
duplication, tightly couple tests to the HTTP library, and make future
maintenance more difficult.

The framework requires an abstraction that centralizes HTTP communication while
keeping test cases focused on business behavior.

## Decision

The framework adopts a dedicated REST Client layer that encapsulates all HTTP
communication.

This layer is responsible for interacting with REST Assured, exposing reusable
operations that hide implementation details from the test suites.

Test classes must communicate only with the REST Client and should never invoke
REST Assured directly.

## Alternatives Considered

### Direct REST Assured Usage

**Advantages**

- Simple initial implementation.
- Less abstraction.
- Faster for small projects.

**Disadvantages**

- High code duplication.
- Tight coupling between tests and REST Assured.
- Difficult maintenance.
- Reduced reusability.

### Dedicated REST Client Layer

**Advantages**

- Separation of concerns.
- Centralized HTTP communication.
- Improved maintainability.
- Better code reuse.
- Easier library replacement if required.
- Cleaner test implementation.

**Disadvantages**

- Additional abstraction layer.
- Slight increase in initial implementation effort.

## Consequences

### Positive

- Tests remain focused on business behavior.
- HTTP communication is centralized.
- REST Assured implementation details remain isolated.
- Future maintenance becomes easier.
- New API resources can be added consistently.

### Negative

- Additional classes must be maintained.
- Small projects may consider this abstraction unnecessary.

## References

- REST Assured Documentation.
