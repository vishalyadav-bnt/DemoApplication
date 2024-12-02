# Static Application Security Testing with SonarQube and GitHub Actions

This repository demonstrates the implementation of a **GitHub Actions workflow** to perform **Static Application Security Testing (SAST)** using **SonarQube Community Edition**. The workflow leverages **TestContainers** to run a temporary SonarQube server and stores the output SARIF report in the **GitHub Packages**.

## Features

- **Automated Code Analysis**: Integrates SonarQube for static analysis of code quality and security vulnerabilities.
- **GitHub Actions Workflow**: Implements a CI pipeline for SAST directly within your GitHub repository.
- **TestContainers**: Uses TestContainers to run a lightweight, temporary SonarQube server for analysis.
- **SARIF Reports**: Generates and uploads SARIF reports to GitHub Packages for further review.

## Requirements

Before using this project, ensure you have the following:

1. A GitHub repository with your source code.
2. Docker installed locally (required for TestContainers).
3. SonarQube Community Edition Docker image pulled from the official repository.


## Workflow Overview

The GitHub Actions workflow performs the following steps:

1. **Checkout Repository**: Clones the source code for analysis.
2. **Set Up Java**: Configures Java 21 using Temurin distribution for Gradle builds.
3. **Start SonarQube**: Launches SonarQube Community Edition using Docker.
4. **Initialize SonarQube**:
   - Changes default `admin` password to `admin123`.
   - Creates a SonarQube project with the key `Demo`.
5. **Build and Test**: Runs the `Gradle` build process.
6. **Run SonarQube Analysis**:
   - Executes a static code analysis using SonarQube.
   - Ensures the results pass SonarQube's quality gate.
7. **Export Issues**: Retrieves unresolved issues from SonarQube as a JSON file.
8. **Convert Issues to SARIF**: Converts JSON issues into SARIF format using a shell script.
9. **Upload Reports**: Stores both JSON and SARIF reports as GitHub artifacts.

## Prerequisites

- **Docker**: Ensure Docker is installed locally to run TestContainers.
- **GitHub Secrets**:
  - `SONARQUBE_LOGIN`: SonarQube admin username (default: `admin`).
  - `SONARQUBE_PASSWORD`: SonarQube admin password (default: `admin123`).


## Usage Instructions

### Step 1: Clone the Repository
```bash
git clone [https://github.com/NimbusPay-Technologies-Inc/umesh-sast-demo.git]
cd Demo
```

## How to Use

1. Clone this repository and navigate to the `.github/workflows` directory to view the workflow file.
2. Push your code to your GitHub repository. The workflow will trigger automatically.
3. Review the results in the **Actions** tab and download the SARIF report from **GitHub Packages**.

## Demonstration

This repository includes:
- A working GitHub Action workflow file (`sonarqube-scan.yml`) in the `.github/workflows` directory.
- Code examples demonstrating the integration of SonarQube analysis.
- The SARIF report uploaded to GitHub Packages after each workflow run.

## Outputs

- **Code Quality Analysis**: Comprehensive feedback on code quality and potential vulnerabilities.
- **SARIF Report**: A report compatible with GitHub’s security tools, enabling detailed inspection of findings.







