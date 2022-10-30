Feature: Home page tests

  Background: Navigate to Home Page
    Given I open url of homepage
    When I fill out login form with following details:
      | email    | test@yahoo.com |
      | password | test123        |
    When I click a button "Login"
    Then Verify I can login successfully
    Then Verify header text is "Interview App"

  @IN-1 @regression
  Scenario: Contact Us form test
    Then Verify header text is "Interview App"

@IN-9 @regression
Scenario: Test Sign Out button navigate back to login page
  When I click a button Sign out
#  Then
#
@IN-10 @regression
Scenario: Test admin logs in Manage Access button is visible
  Given I open login page
  Then I enter username "admin@yahoo.com"
  And I enter password "admin123"
  And I click a button "LOGIN"
  Then Verify link text "Manage Access" is displayed
