Feature: Test login functionality

  Scenario Outline: Test Login form with empty credentials
    Given browser is opened on Swag Labs login page
    When user enters username "<username>" and password "<password>"
    And user click login button
    Then user should get the expected message "<expected message>"

    Examples:
      | username            | password       | expected message     |
      |                     |                | Username is required |
      | standard_user       |                | Password is required |
      | standard_user       | secret_sauce   | Swag Labs            |