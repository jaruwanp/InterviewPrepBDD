Feature: Home page tests

  Background: Navigate to Home Page
    Given I open url of login page
#    When I fill out login form with following details:
#      | email    | test@yahoo.com |
#      | password | test123        |
#    When I click a button "Login"
#    Then Verify I can login successfully
#    Then Verify header text is "Interview App"

@IN-1 @regression
Scenario: Test header of the home page
Then Verify header text is "Interview App"

  @IN-11
  Scenario: Edit/Delete any question under Interview section
    When I fill out login form with following details: "admin@yahoo.com" and password
    And I click a button "Login"
    Then Verify any question could be edited or deleted


  @IN-12
  Scenario: Add new dashboard
    When I fill out login form with following details: "admin@yahoo.com" and password
    And I click a button "Login"
    And I enter input field "New dashboard"
    And I click a button "+ Add"
    Then Verify regular user could see new dashboard

