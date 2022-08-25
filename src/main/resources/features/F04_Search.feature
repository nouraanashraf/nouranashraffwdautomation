@smoke
Feature: F04_Search | users will be able to search for products with different parameters
  Scenario: user could search using product name
    Given user click on search bar
    When user search for product like "htc"
    And user click on search Button
    Then user could search successfully and go to search page


  Scenario: user could search using SKU
    Given   user click on search bar
    When    user search for product like "M8_HTC_5L"
    And     user click on search Button
    Then    user could search successfully with SKU
