# Functional inventory
## Purpose
This document identifies the functional capabilities exposed by the GoRest REST API.

## Scope
This analysis covers the publicly available REST resources provided by GoRest.

## Overview

GoRest is a REST API designed for testing and API automation tasks. It exposes realistic business resources such as users, posts, comments, and todos through standard HTTP operations.

The original public service (https://gorest.co.in/) provides persistent data, authentication through Bearer Tokens, configurable rate limits, and supports both JSON and XML payloads. Since the data is shared across all users, test executions may be affected by changes introduced by external clients.

For this project, the primary target API will be https://gorest.in/, a stable drop-in replacement created specifically for QA engineers and SDET training. It provides the same CRUD capabilities while offering deterministic behavior suitable for automated testing without requiring authentication.

## Functional Capabilities
| Capability          | Business Value                    | Automation Priority |
| ------------------- | --------------------------------- | ------------------- |
| User Management     | Core business capability          | High                |
| Resource Filtering  | Supports data retrieval scenarios | High                |
| Pagination          | Required for large datasets       | High                |
| Content Negotiation | Ensures client compatibility      | Medium              |
| Authentication      | Protects write operations         | Critical            |
| Validation          | Preserves data integrity          | Critical            |
| Error Handling      | Ensures predictable API behavior  | High                |
| Rate Limiting       | Protects service availability     | Medium              |



## Out of Scope
| Capability               | Reason                                                                                    |
|--------------------------| ----------------------------------------------------------------------------------------- |
| GraphQL API              | Only REST endpoints are supported.                                                        |
| File upload              | The API does not support file or binary content uploads.                                  |
| Batch operations         | Resources must be created, updated, or deleted one at a time.                             |
| Real user authentication | Authentication is simulated using Bearer Tokens rather than a complete identity provider. |
| Role-based authorization | No user roles or permission model are implemented.                                        |
| WebSocket communication  | The API only supports synchronous HTTP communication.                                     |
| Resource relationships   | The stable environment exposes only the `Users` resource.                                 |

