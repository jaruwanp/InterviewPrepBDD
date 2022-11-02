Feature: User Access page test
  Background: Navigate to Login Page
    Given I open url of homepage
    When I fill out login form with following details:
      | email    | test@yahoo.com |
      | password | test123        |
    When I click a button "Login"

  @IN-2 @regression
  Scenario: Verify Sign out text
    Then Verify "Sign out" button is present
    Then Verify "Manage Access" Button is not displayed

  @IN-4a @regression
  Scenario: Verify Do's functionality is working as expected
    When I click a button "Add do "
    And I input text "Test1234"
    And I click a button "Enter"
    Then Verify "Test1234" exists in the lasted row of Do's table