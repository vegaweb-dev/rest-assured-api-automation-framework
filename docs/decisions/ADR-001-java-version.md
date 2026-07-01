# ADR 001 Java version

## Status

Accepted

## Context

The API Automation Framework requires a stable, long-term supported Java
platform that ensures compatibility with the selected technology stack, build
tools, testing libraries, and Continuous Integration environment.

The Java version will influence framework maintainability, developer experience,
dependency compatibility, and future upgrades.

## Decision

The framework adopts Java 21 as the primary development platform.

Java 21 is the latest Long-Term Support (LTS) release and provides modern
language improvements while maintaining excellent compatibility with the
framework's planned technology stack.

## Alternatives Considered

### Java 17

**Advantages**

- Long-Term Support (LTS).
- Excellent enterprise adoption.
- Mature ecosystem.
- Broad library compatibility.

**Disadvantages**

- Does not include the language enhancements introduced in Java 21.

### Java 21

**Advantages**

- Latest Long-Term Support (LTS) release.
- Improved language features.
- Long maintenance lifecycle.
- Modern development experience.
- Strong compatibility with current tooling.

**Disadvantages**

- Some organizations continue standardizing on Java 17.

## Consequences

### Positive

- Long-term platform stability.
- Reduced need for future Java upgrades.
- Access to the latest language improvements.
- Compatibility with modern Java tooling.

### Negative

- Contributors using older Java versions must upgrade their development
  environment.

## References

- Oracle Java LTS Roadmap.
- Maven Java Compatibility Documentation.