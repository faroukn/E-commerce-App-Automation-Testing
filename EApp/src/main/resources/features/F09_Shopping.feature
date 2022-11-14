@smoke
Feature: add products to Wishlist
  Scenario: Logged user could add different products to shopping cart
    Given user login with "test@example.com" and "P@ssw0rd" then select shopping from 4 item
    When user click on add shopping for a product
    Then shopping message is displayed

  Scenario: Logged user could add different products to shopping cart and get number of it
    Given user login with "test@example.com" and "P@ssw0rd" then select shopping from 4 item
    Then check number of qty cart