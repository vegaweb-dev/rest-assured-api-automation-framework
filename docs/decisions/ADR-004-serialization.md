# ADR 004 Serialization

## Status

Accepted

## Context

The API Automation Framework exchanges JSON payloads with REST APIs and requires
a reliable mechanism to serialize Java objects into JSON requests and
deserialize JSON responses into Java objects.

The serialization solution should integrate seamlessly with the selected
technology stack while minimizing boilerplate code and ensuring maintainability.

## Decision

The framework adopts Jackson as the serialization and deserialization library.

Jackson will be responsible for converting Java objects into JSON request bodies
and mapping JSON responses back into Java objects.

The framework will rely on Jackson's annotations only when necessary, keeping
model classes as simple and readable as possible.

## Alternatives Considered

### Jackson

**Advantages**

- Industry-standard JSON library.
- Native integration with REST Assured.
- Excellent performance.
- Rich annotation support.
- Mature and actively maintained.
- Broad ecosystem adoption.

**Disadvantages**

- Large feature set may increase complexity when advanced features are used.

## Consequences

### Positive

- Simplified JSON serialization and deserialization.
- Reduced manual mapping code.
- Excellent compatibility with REST Assured.
- Improved maintainability of request and response models.
- Wide community support.

### Negative

- Framework models become dependent on the selected serialization library.
- Advanced mappings may require additional Jackson annotations.

## References

- Jackson Documentation.
- REST Assured Documentation.
