@smoke
Feature: F03 | user could reset his/her password
  Scenario: user could reset his/her password successfully
    Given user go to reset password page
    When user enter "valid" "test@example.com"
    And user clicks on recover button
    Then reset message display

  Scenario: user could not reset his/her password successfully
    Given user go to reset password page
    When user enter "invalid" "wrong@example.com"
    And user clicks on recover button
    Then error message display