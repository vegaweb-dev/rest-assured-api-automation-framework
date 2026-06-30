# Github Actions

## Purpose

This document defines the Continuous Integration (CI) strategy based on GitHub
Actions. It describes how automated workflows are triggered, executed, and
maintained to ensure consistent, reliable, and repeatable validation of the API
Automation Framework.

## Scope

This document applies to all GitHub Actions workflows implemented for the
project, including automated builds, test execution, reporting, artifact
generation, and quality verification.

## Overview

GitHub Actions provides the automation platform responsible for executing the
Continuous Integration pipeline. Every workflow is designed to validate code
quality, execute automated tests, and provide immediate feedback after each
relevant repository event.

The CI strategy emphasizes fast feedback, deterministic execution, and
reproducible builds.

## Objectives

The GitHub Actions strategy is designed to achieve the following objectives:

- Automate framework validation.
- Detect regressions early.
- Execute tests consistently.
- Produce reproducible builds.
- Generate execution reports.
- Support collaborative development.
- Reduce manual verification effort.

## Workflow Triggers

Workflows may be triggered by the following repository events:

- Pull Request creation.
- Pull Request update.
- Push to the main branch.
- Manual execution.
- Scheduled execution.

Each workflow should execute only the validations appropriate for its trigger.

## Workflow Responsibilities

GitHub Actions is responsible for:

- Checking out the repository.
- Setting up the Java environment.
- Restoring project dependencies.
- Building the project.
- Executing automated test suites.
- Generating execution reports.
- Publishing build artifacts.
- Reporting execution status.

## Execution Strategy

Different workflows may execute different test suites depending on the execution
context.

Typical execution includes:

| Trigger       | Typical Execution                      |
|---------------|----------------------------------------|
| Pull Request  | Smoke, CRUD, Negative, Contract        |
| Push to Main  | Complete validation                    |
| Scheduled Run | Full regression and integration suites |
| Manual Run    | User-selected workflow execution       |

The execution strategy may evolve as the framework grows.

## Artifact Management

GitHub Actions may generate execution artifacts including:

- Test reports.
- Build logs.
- Allure results.
- Test evidence.
- Execution summaries.

Artifacts should be retained only for the period required by the project.

## Security Considerations

The following security principles apply:

- Secrets must never be hardcoded.
- Credentials are stored using GitHub Secrets.
- Sensitive information must never appear in workflow logs.
- Least-privilege access should be applied whenever possible.

## Maintenance Guidelines

Workflow definitions should remain:

- Simple.
- Readable.
- Modular.
- Version controlled.
- Consistently documented.

Unused workflows should be removed to reduce maintenance effort.

## Future Evolution

As the framework evolves, additional workflows may be introduced to support new
validation stages, deployment environments, quality gates, and release
processes.

Workflow complexity should increase only when justified by project requirements.

## Notes

GitHub Actions serves as the primary Continuous Integration platform for this
framework. All workflow definitions should prioritize reliability,
maintainability, fast feedback, and deterministic execution.