@smoke
Feature: F06 | Hover and select different Categories
  Scenario: Logged user could select different Categories
    Given user go to login page to login then hover
    When user login with "test@example.com" and "P@ssw0rd" then homepage to hover
    When user select and hover from main menu and user click on sub menu
    Then Assert that the sub-category title is the one you get it while selecting random sub-category
