# ADR 002 Build Tool

## Status

Accepted

## Context

The API Automation Framework requires a build automation tool capable of
managing project dependencies, compiling the source code, executing automated
tests, generating reports, and integrating seamlessly with Continuous
Integration pipelines.

The selected tool should be stable, widely adopted in the Java ecosystem, and
compatible with the framework's planned technology stack.

## Decision

This project intentionally uses Maven because it is the build tool I currently
use professionally and want to master before exploring alternatives such as
Gradle.

## Alternatives Considered

### Apache Maven

**Advantages**

- Industry-standard build tool.
- Convention over configuration.
- Excellent dependency management.
- Native support for testing plugins.
- Wide IDE compatibility.
- Strong CI/CD integration.
- Extensive plugin ecosystem.

**Disadvantages**

- XML configuration can become verbose.
- Less flexible than script-based build tools.

### Gradle

**Advantages**

- Faster incremental builds.
- Flexible build scripting.
- Concise configuration using Kotlin or Groovy.
- Powerful customization capabilities.

**Disadvantages**

- Steeper learning curve.
- Greater configuration flexibility may reduce consistency.
- Less commonly used in API automation frameworks.

## Consequences

### Positive

- Standard Maven project layout.
- Predictable build lifecycle.
- Simplified dependency management.
- Straightforward integration with GitHub Actions.
- Broad compatibility with Java libraries and testing tools.

### Negative

- XML configuration files require manual maintenance.
- Advanced customizations may require additional plugins.

## References

- Apache Maven Documentation.
