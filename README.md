# SauceDemo Login Tests

## Description

This project contains automated tests for the login form on the [SauceDemo](https://www.saucedemo.com/) website. The tests cover various login scenarios, including validation of error messages and successful login.

## Running Tests

## Maven commands to execute tests

To execute final test for Edge browser use the following command:
```bash
mvn -Dbrowser=edge -Dtest=RunnerClass -Denvironment=qa clean test
```

To execute final test for Firefox browser use the following command:
```bash
mvn -Dbrowser=firefox -Dtest=RunnerClass -Denvironment=qa clean test
```

## Test Scenarios

- **UC-1**: Test login form with empty credentials.
  - Enter any text in the "Username" and "Password" fields.
  - Clear the input fields.
  - Click the "Login" button.
  - Verify the error message: "Username is required".

- **UC-2**: Test login form with only the username field filled.
  - Enter any text in the "Username" field.
  - Leave the "Password" field empty.
  - Click the "Login" button.
  - Verify the error message: "Password is required".

- **UC-3**: Test login form with valid credentials.
  - Enter valid credentials in the "Username" and "Password" fields.
  - Click the "Login" button.
  - Verify that the title "Swag Labs" appears on the dashboard.

