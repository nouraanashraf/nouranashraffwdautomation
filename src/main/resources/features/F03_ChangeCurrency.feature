@smoke

Feature: F03_ChangeCurrency | user could switch between currencies [$, €]

  Scenario: user can change currency
    When    user selects “Euro” from currency dropdown list
    Then    All $ sign change to € sign

