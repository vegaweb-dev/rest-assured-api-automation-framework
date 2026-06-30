# Http status catalog

## Purpose

This document provides a centralized reference for all HTTP status codes
returned by the GoRest API used in this project. It describes the meaning of
each response code, the scenarios in which it is expected, and its relevance for
API test automation.

## Scope

This catalog covers all successful and error HTTP responses documented by the
stable GoRest environment (`gorest.in`). It serves as the primary reference for
designing positive, negative, and contract validation scenarios.

## Overview
The GoRest API follows standard HTTP semantics and uses status codes to
communicate the outcome of each request. Successful responses indicate that the
requested operation has been completed, while client and server error responses
provide information about validation failures, authentication issues,
unsupported requests, or unexpected server conditions.

## Successful Responses
| Status | Name | Typical Scenario | Automation Priority |
|---------|------|------------------|---------------------|
| **200** | OK | Successful GET, PUT and PATCH requests. | Critical |
| **201** | Created | Resource successfully created. | Critical |
| **204** | No Content | Resource successfully deleted. | High |
| **304** | Not Modified | Conditional request returned cached content. | Low |

## Client Error Responses
| Status | Name | Typical Scenario | Automation Priority |
|---------|------|------------------|---------------------|
| **400** | Bad Request | Invalid JSON payload or malformed request. | High |
| **401** | Unauthorized | Missing Bearer Token. | Critical |
| **403** | Forbidden | Blocked or invalid authentication token. | Medium |
| **404** | Not Found | Requested resource does not exist. | High |
| **405** | Method Not Allowed | Unsupported HTTP method. | Medium |
| **415** | Unsupported Media Type | Missing or invalid Content-Type header. | Medium |
| **422** | Unprocessable Entity | Business validation failed. | Critical |
| **429** | Too Many Requests | Rate limit exceeded. | Medium |

## Server Error Responses
| Status | Name | Typical Scenario | Automation Priority |
|---------|------|------------------|---------------------|
| **500** | Internal Server Error | Unexpected server-side failure. | Medium |

    