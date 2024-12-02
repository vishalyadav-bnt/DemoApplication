# **Automated Performance Testing with K6 And Static Application Security Testing with SonarQube.**
This repository demonstrates the implementation of **Automated Performance Testing** with K6 and **Static Application Security Testing (SAST)** with SonarQube using GitHub Actions. It provides examples of performance and security testing frameworks, showcasing workflows that ensure high-quality and secure code deployment.

## Table of Contents

1. [Static Application Security Testing (SAST)](#static-application-security-testing-sast)
2. [Automated Performance Testing Using K6](#automated-performance-testing)

---
# 🌟  Static Application Security Testing with SonarQube and GitHub Actions


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
- **SARIF Report**:A report compatible with GitHub’s security tools, enabling detailed inspection of findings. The SARIF report will be stored in the artifacts section for download and further analysis.




---
# 🌟 Automated Performance Testing with K6 and GitHub Actions

This repository implements an automated performance testing framework using **K6**, **TestContainers**, and **GitHub Actions**. It includes a Spring Boot application (WebService) and uses Dockerized K6 to run performance tests. Test results are pushed to **GitHub Packages**.



## Project Features
1. **Spring Boot Application**:
   - A RESTful web service running inside a container.
2. **Performance Testing**:
   - Uses [K6](https://k6.io/) to test the application's performance.
3. **Automated Orchestration**:
   - Orchestrated using **GitHub Actions**.
4. **Externalized Test Configurations**:
   - Input parameters for tests are defined in external files for flexibility.
5. **Result Publishing**:
   - Performance results are saved and uploaded to GitHub as artifacts.

---

## Prerequisites
- **GitHub Account**: A GitHub repository to host the workflow.
- **Docker Installed**: Required to build and run containers locally (optional).
- **Java JDK 21**: Used to build the Spring Boot application.
- **Gradle**: To build and package the Spring Boot application.
- **GitHub Actions Enabled**: To run the CI/CD pipeline.

---

## Repository Structure
```
.
├── Demo/         # Spring Boot application
│   ├── Dockerfile               # Dockerfile to containerize the application
│   ├── gradlew                  # Gradle wrapper
│   ├── build.gradle             # Gradle build file
│   ├── src/                     # Application source code
│   └── results/                 # Directory to store test results
├── k6/
│   ├── script/
│      └── performance-test.js  # K6 performance test script   
├── .github/
│   └── workflows/
│       └── performance-test.yml # GitHub Actions workflow file
└── README.md                    # This documentation
```

## Setup and Configuration
### Step 1: Clone the Repository
```
git clone (https://github.com/NimbusPay-Technologies-Inc/umesh-sast-demo.git)
cd Demo
```
### Step 2:  Build the Project Using Gradle
```
./gradlew clean build
```
- Once the repository is cloned, you can trigger the GitHub Actions workflow for automated performance testing.
### step 3: Trigger GitHub Actions Workflow
- Verify Repository Setup:
Ensure all required files are in the repository, including the K6 test scripts, Dockerfile, and GitHub Actions workflow (.github/workflows).
- Commit and Push Changes:
If you make any updates or changes to the repository, push them to the main branch to trigger the GitHub Actions workflow:
```
git add .
git commit -m "Updated configuration or code"
git push origin main
```
### step 4: Monitor Workflow Execution:

- Go to your repository on GitHub.
- Click on the Actions tab.
- Select the latest workflow run to view the logs and status of each step.

## How It Works
1. **Web Service Deployment**:
- The Spring Boot application is built and deployed in a container.
2. **K6 Performance Tests**:
- K6 simulates a predefined load on the service and evaluates performance.
3. **Result Validation**:
- Test results are validated against thresholds.
4. **Artifact Upload**:
- Detailed test results are saved and uploaded to GitHub.

### Workflow Steps
1. **Checkout Code**:
  - Clones the repository.
2. **Set up JDK**:
  - Configures Java 21 for the project.
3. **Build Application**:
  - Builds the Spring Boot application using Gradle.
4. **Run Dockerized Service**:
  - Deploys the application in a container.
5. **Run K6 Performance Tests**:
  - Executes tests using the parameters in test-config.env.
6. **Upload Results**:
  - Uploads test results (tk6-test-result.json, report.txt) as GitHub artifacts.

## Test Results and Reporting
### Artifacts:
- k6-test-result.json: Detailed JSON test report.
- report.txt: Human-readable test summary.
### Result Comparison:
You can compare test results using both the summary.json and report.txt files:
summary.json: This file provides data in a structured JSON format, making it ideal for automated comparisons or further processing using tools or scripts.
report.txt: This file offers a simple, human-readable summary that you can manually review to spot differences or trends in test performance or results.

##  References
## Documentation Links

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)  
  Comprehensive guide for developing applications with Spring Boot, including setup, configuration, and deployment.

- [K6 Documentation](https://k6.io/docs/)  
  Official documentation for K6, covering load testing concepts, scripting, metrics, and more.

- [GitHub Actions Documentation](https://docs.github.com/en/actions)  
  Detailed guide on using GitHub Actions to automate workflows, including examples for CI/CD pipelines.

- [Docker Documentation](https://docs.docker.com/)  
  Complete reference for Docker, from installation to building and managing containers.


  









