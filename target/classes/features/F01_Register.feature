
@smoke
Feature: F01_Register | user should be able to create a new account

  Scenario: user registers with valid data

    Given   user navigate to register page
    And     user chooses male or female
    When    user enters valid data
    Then    user presses on register button
    And     user could register successfully