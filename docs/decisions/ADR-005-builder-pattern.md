# ADR 005 Build Pattern

## Status

Accepted

## Context

The API Automation Framework requires a consistent and maintainable approach for
creating request payloads used in automated tests.

Constructing request objects directly within test classes leads to duplicated
code, reduced readability, and increased maintenance effort as API models
evolve.

The framework requires a reusable mechanism for generating valid and
customizable test data while keeping test cases focused on business behavior.

## Decision

The framework adopts the Builder Pattern for constructing request objects used
in automated tests.

Builders will provide sensible default values while allowing individual fields
to be customized when required by specific test scenarios.

Test classes should obtain request objects through Builders rather than
instantiating model classes directly.

## Alternatives Considered

### Direct Object Construction

**Advantages**

- Simple implementation.
- No additional abstraction.

**Disadvantages**

- Repeated object initialization.
- Reduced readability.
- Difficult maintenance.
- High code duplication.

### Static Factory Methods

**Advantages**

- Centralized object creation.
- Simple implementation.

**Disadvantages**

- Limited flexibility.
- Large number of factory methods may be required.
- Difficult to support many object variations.

### Builder Pattern

**Advantages**

- Highly readable.
- Reusable.
- Flexible object customization.
- Reduces duplicated code.
- Simplifies maintenance.
- Encourages expressive test scenarios.

**Disadvantages**

- Additional implementation effort.
- More framework classes must be maintained.

## Consequences

### Positive

- Cleaner test code.
- Centralized test data creation.
- Improved maintainability.
- Reduced duplication.
- Easier evolution of request models.
- Better readability of test scenarios.

### Negative

- Additional Builder classes must be maintained.
- Small projects may not require this level of abstraction.

## References

- Effective Java (Joshua Bloch).
- Framework Architecture.
- Test Strategy.