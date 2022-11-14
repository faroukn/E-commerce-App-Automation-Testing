@smoke
Feature: add products to Wishlist
  Scenario: Logged user could add different products to wishlist
    Given user login with "test@example.com" and "P@ssw0rd" then select from 4 item
    When user click on add wishlist for a product
    Then wish message is displayed

  Scenario: Logged user could add different products to wishlist and get number of it
    Given user login with "test@example.com" and "P@ssw0rd" then select from 4 item
    Then check number of qty