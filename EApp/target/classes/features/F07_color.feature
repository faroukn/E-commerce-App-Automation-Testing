@smoke
Feature: user could filter with color
  Scenario: Logged user could filter with color
    Given user login with "test@example.com" and "P@ssw0rd" then select item
    Then user click on specific color