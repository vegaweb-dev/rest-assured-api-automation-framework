# Contract governance

## Purpose

This document defines the governance model for API contract validation within
the API Automation Framework. It establishes the principles, policies, and
responsibilities that ensure API contracts remain consistent, reliable, and
maintainable throughout the framework lifecycle.

## Scope

This document applies to all API contract validations implemented by the
framework, including request and response schemas, validation rules, schema
versioning, and contract verification processes.

## Overview

API contracts define the expected structure and behavior of requests and
responses exchanged between the client and the API. Contract governance ensures
these expectations remain consistent over time, allowing automated tests to
detect unintended interface changes while minimizing maintenance effort.

## Contract Definition

Within this framework, an API contract consists of:

- Request structure.
- Response structure.
- Required and optional fields.
- Data types.
- Allowed values.
- HTTP status codes.
- Response headers when applicable.

The framework validates that every response complies with its expected contract.

## Validation Strategy

Contract validation follows these principles:

- Contract validation is automated.
- JSON Schema is the primary validation mechanism.
- Contract validation complements functional assertions.
- Functional validation and contract validation remain independent.
- Validation is deterministic and repeatable.

Contract validation does not replace business validation; both are required.

## Schema Management

JSON Schema files are maintained as version-controlled project artifacts.

The following principles apply:

- One schema per response contract.
- Schemas are human-readable.
- Schemas are reviewed together with application changes.
- Deprecated schemas are preserved when required for backward compatibility.
- Schema updates require corresponding test updates.

## Versioning Policy

Contract versions should evolve in a controlled manner.

The following principles apply:

- Backward-compatible changes may reuse the existing schema version.
- Breaking changes require a new schema version.
- Historical schema versions should remain available when supporting multiple
  API versions.
- Every schema modification should be traceable through version control.

## Compatibility Rules

The framework distinguishes between compatible and incompatible contract
changes.

Examples of compatible changes include:

- Adding optional fields.
- Expanding allowed enumeration values when supported.
- Improving field descriptions without altering structure.

Examples of incompatible changes include:

- Removing required fields.
- Changing field data types.
- Renaming existing fields.
- Modifying response structures.
- Changing expected HTTP status codes.

Breaking changes should cause contract validation failures until the framework
is intentionally updated.

## Contract Validation Workflow

The contract validation process follows these steps:

1. Execute the API request.
2. Verify the expected HTTP status code.
3. Load the corresponding JSON Schema.
4. Validate the response against the schema.
5. Report any validation failures.
6. Continue with functional assertions when applicable.

Contract validation failures should clearly identify the violated schema rule
whenever possible.

## Future Evolution

As the framework expands to additional API resources, new contracts and schemas
will be incorporated following the governance principles defined in this
document.

Future improvements may include automated schema generation, schema version
compatibility analysis, and enhanced contract reporting.

## Notes

Contract governance aims to provide confidence that API interfaces remain stable
while allowing controlled evolution. Every contract change should be
intentional, documented, reviewed, and validated through the automated test
suite.