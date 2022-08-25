@smoke
Feature: F02_Login | user should be able to login to the system


  Scenario: user login with valid data
    When    user navigates to login page
    And     user enter "nouranashraf@gmail.com" and "P123456"
    Then    user clicks on login button
    And     user could login successfully and go to home page


  Scenario: user login with invalid data
    When    user navigates to login page
    And     user enter "nouranashraf@gmail.com" and "Password"
    Then    user clicks on login button
    And     user couldn't login to the system