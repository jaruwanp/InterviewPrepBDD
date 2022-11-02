Feature: Home page tests
  Background: Navigate to Login Page

    Given I open url of homepage
    When I fill out login form with following details:
      | email    | test@yahoo.com |
      | password | test123        |
    When I click a button "Login"

  @IN-1 @regression
  Scenario: Log in form test
    Then Verify header text is "Interview App"
