@smoke
Feature: F05 | switch between currencies
  Scenario: Looged user could switch between currencies US-Euro
    Given user go to login page then homepage
    When user login with "test@example.com" and "P@ssw0rd" then homepage
    When user witch between currencies US-Euro
    Then 4 products have the €