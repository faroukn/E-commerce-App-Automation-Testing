@smoke
Feature: add products to Wishlist
  Scenario: Logged user could add different products to shopping cart
    Given user login with "test@example.com" and "P@ssw0rd" then select compare from 4 item
    When user click on add compare for a product
    Then compare message is displayed
