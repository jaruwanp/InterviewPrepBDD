Feature: Home page tests

Background: Navigate to Home Page
Given I open url of homepage

@IN-1 @regression
Scenario: Test header of the home page
Then Verify header text is "Interview App"

  @IN-11
  Scenario: Edit/Delete any question underInterview section
    When When I fill out login form with following details:
      | email    | admin@yahoo.com |
      | password | admin123        |
    And I click a button "Login"

  @IN-12
  Scenario: Add new dashboard
