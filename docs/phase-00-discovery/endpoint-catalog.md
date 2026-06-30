# Endpoint catalog

## Purpose
This document provides a centralized catalog of all REST endpoints exposed by
the GoRest API used in this project. It serves as the authoritative reference
for endpoint definitions, supported HTTP methods, authentication requirements,
query parameters, and expected successful responses.

## Scope
This catalog covers all publicly available endpoints exposed by the stable
GoRest environment (`gorest.in`) used by this project. It includes endpoint
definitions, supported HTTP methods, authentication requirements, query
parameters, media types, and expected successful HTTP responses.

## Overview
The GoRest API follows REST principles and exposes a resource-oriented interface
over HTTP. In the stable environment used by this project, all operations are
performed against the `Users` resource through standard CRUD endpoints.

The API supports multiple response formats, query parameters for filtering and
pagination, and Bearer Token authentication for write operations. Together,
these capabilities provide a realistic environment for designing and validating
REST API automation frameworks.

## Endpoint catalog
| Method | Endpoint               | Authentication | Description                         | Success Status |
|--------|------------------------|----------------|-------------------------------------|----------------|
| GET    | `/public/v2/users`     | No             | Retrieve a paginated list of users. | 200            |
| POST   | `/public/v2/users`     | Yes            | Create a new user.                  | 201            |
| GET    | `/public/v2/users/:id` | No             | Retrieve a specific user by id      | 200            |
| PUT    | `/public/v2/users/:id` | Yes            | Replace all fields required.        | 200            |
| PATCH  | `/public/v2/users/:id` | Yes            | Partially update a user.            | 200            |
| DELETE | `/public/v2/users/:id` | Yes            | Delete a user.                      | 204            |

## Query parameters
| Parameter | Description                   | Example                   |
|-----------|-------------------------------|---------------------------|
| name      | Filter by name.               | `?name=John`              |
| email     | Filter by email.              | `?email=test@example.com` |
| gender    | Filter by gender.             | `?gender=male`            |
| status    | Filter by status.             | `?status=active`          |
| page      | Requested page number.        | `?page=2`                 |
| per_page  | Page size (def 10 - max 100). | `?per_page=20`            |

## Supported media types
| Media Type       | Supported |
|------------------|-----------|
| application/json | Yes       |
| application/xml  | Yes       |

## Authentication summary
| Operation      | Authentication Required |
|----------------|-------------------------|
| GET Collection | No                      |
| GET Resource   | No                      |
| POST           | Yes                     |
| PUT            | Yes                     |
| PATCH          | Yes                     |
| DELETE         | Yes                     |
