Feature: Home page tests

  Background: Navigate to Home Page
    Given I open url of homepage
    Then Verify header text is "Interview App"

  @IN-1 @regression
  Scenario: Contact Us form test
    When I fill out login form with following details:
      | email    | test@yahoo.com |
      | password | test123        |
    When I click a button "Login"
    Then Verify I can login successfully
