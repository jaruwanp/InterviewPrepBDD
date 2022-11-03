Feature: Home page tests
  Background: Navigate to Home Page
    Given I open url of homepage
    When I fill out login form with following details:
      | email    | test@yahoo.com |
      | password | test123        |
    When I click a button "Login"

  @IN-1 @regression
  Scenario: Log in form test
    Then Verify header text is "Interview App"

  @IN-9 @regression
  Scenario: Verify Sign Out button works as expected
    And I click a button "Sign out"
    Then verify I have been redirected to login page