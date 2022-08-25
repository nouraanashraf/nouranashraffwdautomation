@smoke
Feature: F08_WishList  |  User could add products to wishlist

  Background: user login first
    When      user navigates to login page
    And       user enter "nouranashraf@gmail.com" and "P123456"
    Then      user clicks on login button
    And       user could login successfully and go to home page


  Scenario: success message is visible after adding item to wishlist
    When    user add item to wishlist
    Then    wishlist notification success message is visible


  Scenario: number of wishlist items in home page is increased
    When    user add item to wishlist
    Then    wishlist notification success message is visible
    And     user get the number of wishlist items after adding item
    Then    the number of wishlist increased
