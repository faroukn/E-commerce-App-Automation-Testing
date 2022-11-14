@smoke
Feature: F04_Search | Logged user could search for any product
  Scenario Outline: user could search with words
    Given user go to login page to login
    When user login with "test@example.com" and "P@ssw0rd" then go to homepage
    When user search for <word>
    And clicks Enter to search
    Then search shows results with word
    Examples:
      | word   |
      | book   |
      | laptop |
      | nike   |

  Scenario Outline: user could search with sku
    Given user go to login page to login
    When user login with "test@example.com" and "P@ssw0rd" then go to homepage
    When user search for <sku>
    And clicks Enter to search
    And clicks on the item
    Then search shows results with sku
    Examples:
      | sku       |
      | SCI_FAITH |
      | APPLE_CAM |
      | SF_PRO_11 |
