# SauceDemo Login Tests

## Description

This project contains automated tests for the login form on the [SauceDemo](https://www.saucedemo.com/) website. The tests cover various login scenarios, including validation of error messages and successful login.

![image](https://github.com/user-attachments/assets/30d1589b-6719-4d5f-973c-bc97794dc9a2)


## Running Tests

### Maven commands to execute tests

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

## Testing Features

  - **Parallel Execution**: Tests can be executed simultaneously, which accelerates the testing process.
  - **Logging**: Logging is implemented to enhance traceability and simplify debugging during test execution.
  - **Data Provider**: Tests are parameterized using Data Providers, making it easier to handle various input scenarios.

# Optional Tasks

## 1. Pastebin Test №1
 
### Test Scenario

- **UC-1**: Test creation form of paste.
  - Enter any text in the "Username" and "Password" fields.
  - Clear the input fields.
  - Click the "Login" button.
  - Verify the error message: "Username is required".

To execute final test for Chrome browser use the following command:
```bash
mvn -Dbrowser=chrome -Dtest=WebDriverPastebinTest1 -Denvironment=qa clean test
```

## 2. Pastebin Test №2
 
### Test Scenario

- **UC-1**: Test creation form of paste and verification of inputed data.
- Open https://pastebin.com/ or a similar service in any browser.
- Create 'New Paste' with the following attributes:
   * Code:
            git config --global user.name  "New Sheriff in Town"
            git reset $(git commit-tree HEAD^{tree} -m "Legacy code")
            git push origin master --force
   * Syntax Highlighting: "Bash"
   * Paste Expiration: "10 Minutes"
   * Paste Name / Title: "how to gain dominance among developers"
- Save 'paste' and check the following:
   * Browser page title matches 'Paste Name / Title'
   * Syntax is suspended for bash
   * Check that the code matches the one from paragraph 2.


To execute final test for Chrome browser use the following command:
```bash
mvn -Dbrowser=chrome -Dtest=WebDriverPastebinTest2 -Denvironment=qa clean test
```

## 3. Cloud google calculator test
 
### Test Scenario

- **UC-1**: Test evaluation of compute engine estimated cost.
-  Open https://cloud.google.com/.
-  Click on "Add to estimate" button.
-  Select "Compute Engine".
-  Fill out the form with the following data:
   * Number of instances: 4
   * Operating System / Software: Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)
   * Provisioning model: Regular
   * Machine Family: General purpose 
   * Series: N1 
   * Machine type: n1-standard-8 (vCPUs: 8, RAM: 30 GB)
   * Select “Add GPUs“
   * GPU type: NVIDIA V100
   * Number of GPUs: 1
   * Local SSD: 2x375 Gb
   * Region: Netherlands (europe-west4)
   * Other options leave in the default state.
-  Click "Share" to see Total estimated cost
-  Click "Open estimate summary" to see Cost Estimate Summary, will be opened in separate tab browser.
-  Verify that the 'Cost Estimate Summary' matches with filled values in Step 4.



To execute final test for Chrome browser use the following command:
```bash
mvn -Dbrowser=chrome -Dtest=GoogleCloudPriceCalculatorTest -Denvironment=qa clean test
```
