Feature: Test Sign out page
  Background: Navigate to Home Page
    Given I open url of homepage
    When I fill out login form with following details:
      | email    | test@yahoo.com |
      | password | test123        |
    When I click a button "Login"
    Then Verify I can login successfully

  @IN-9 @regression
  Scenario: Test Sign Out button navigate back to login page
    When
    When I click Sign out button