# ClaimHubDemo
# Selenium Test Script for Sample Web Application

This project contains a Selenium test script that automates the login process of a sample web application. It uses the Page Object Model (POM) for a structured and maintainable codebase, incorporates a retry function for handling flaky tests, and takes screenshots upon failures.

## Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Setup](#setup)
- [Usage](#usage)
- [Test Flow](#test-flow)
- [Code Structure](#code-structure)
- [Retry and Screenshot Mechanism](#retry-and-screenshot-mechanism)
- [License](#license)

## Overview
The Selenium test script covers the following actions on a sample web application (URL to be replaced with your demo app):
1. Navigate to the login page.
2. Enter valid user credentials and log in.
3. Verify that the user is redirected to the dashboard.
4. Log out and verify that the user is redirected back to the login page.

## Features
- **Automated Test Script**: Automates user login, navigation, and logout.
- **Retry Mechanism**: Automatically retries failed tests to handle flaky tests.
- **Screenshot on Failure**: Captures screenshots upon test failures for easy debugging.
- **Page Object Model (POM)**: Organized codebase for better maintainability.

## Technologies Used
- **Selenium WebDriver**: For browser automation.
- **JUnit/TestNG**: For writing and executing test cases.
- **Java**: Programming language used.
- **Maven/Gradle**: Dependency management and build tool.

## Setup
### Prerequisites
- Java JDK (8 or above)
- Maven or Gradle
- A code editor (e.g., IntelliJ IDEA, Eclipse)
- A web browser (Chrome, Firefox, etc.)


### Installation
1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/your-repository.git
    cd your-repository
    ```
2. Install the dependencies:
    - If using Maven:
        ```bash
        mvn clean install
        ```
    - If using Gradle:
        ```bash
        gradle build
        ```

## Usage
1. **Update the Configuration**:  
   - Set the correct demo URL and credentials in the configuration file (e.g., `config.properties`).
   - If using environment variables, ensure they are set correctly.

2. **Run the Test Script**:
    - If using Maven:
        ```bash
        mvn test
        ```
    - If using Gradle:
        ```bash
        gradle test
        ```

## Test Flow
1. **Navigate to the Login Page**:  
   The test script opens the browser and navigates to the login page of the sample web application.

2. **Enter Credentials and Log In**:  
   The script inputs valid user credentials and submits the login form.

3. **Verify Dashboard Access**:  
   After logging in, the script verifies that the user is successfully redirected to the dashboard.

4. **Log Out and Verify Redirection**:  
   The script performs a logout action and verifies that the user is redirected back to the login page.

## Code Structure
The code follows the Page Object Model (POM) pattern, which separates the page elements and actions from the test logic.

## Running with Jenkins
This project is configured to be integrated with Jenkins for Continuous Integration/Continuous Deployment (CI/CD). The script is executed using Maven with a specific profile.

### Jenkins Configuration
- In Jenkins, configure a new job or use an existing one.
- Set up the project to use the source code from this repository.
- In the **Build** section, add the following command to execute the test script using Maven:

    ```bash
    mvn test -PUAT
    ```

- The `-PUAT` flag specifies that the test should run with the `UAT` profile, which might include specific settings such as environment configuration, browser setup, or any other profile-specific configurations.
  
- **Post-Build Actions**: Optionally, add post-build actions in Jenkins to publish reports, notify on test failures, or archive screenshots.

- **Scheduling**: You can also set up a Jenkins schedule (cron) to automatically trigger the test suite at specific intervals.

### How It Works
1. **Source Code Checkout**: Jenkins pulls the latest code from the repository.
2. **Build and Test Execution**: Jenkins uses Maven to build the project and execute the test suite with the `UAT` profile.
3. **Test Results**: The results, including logs and screenshots, can be viewed in the Jenkins job dashboard.

By integrating Jenkins with this Selenium test project, you can automate test execution and ensure continuous testing with every code change or at scheduled intervals.

