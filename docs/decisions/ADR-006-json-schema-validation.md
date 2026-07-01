# ADR 006 JSON Schema Validation

## Status

Accepted

## Context

The API Automation Framework requires a reliable mechanism for validating the
structure of API responses.

Verifying individual response fields using assertions alone increases
maintenance effort, duplicates validation logic, and makes it difficult to
detect unintended contract changes.

The framework requires a standardized approach to validate response structures
independently from business behavior.

## Decision

The framework adopts JSON Schema Validation as the primary mechanism for
validating API response contracts.

Each API response subject to contract validation will be verified against its
corresponding JSON Schema document.

Contract validation will remain independent from functional assertions.

## Alternatives Considered

### Manual Field Assertions

**Advantages**

- Simple implementation.
- Easy to understand for small responses.
- No additional schema files.

**Disadvantages**

- High maintenance effort.
- Repetitive validation code.
- Difficult to detect structural regressions.
- Poor scalability.

### JSON Schema Validation

**Advantages**

- Standardized validation.
- Reduced assertion duplication.
- Clear separation between contract and functional validation.
- Easier maintenance.
- Excellent scalability.
- Broad industry adoption.

**Disadvantages**

- Requires maintaining schema files.
- Initial schema creation requires additional effort.

## Consequences

### Positive

- Consistent contract validation.
- Reduced duplicated validation logic.
- Improved maintainability.
- Early detection of contract regressions.
- Better separation of testing responsibilities.

### Negative

- Schema files require version control.
- Contract updates require corresponding schema updates.

## References

- JSON Schema Specification.
- REST Assured JSON Schema Validator.
- Contract Governance.