Feature: UserAccess page test
  Background: Navigate to Login Page
    Given I open url of homepage
    When I fill out login form with following details:
      | email    | test@yahoo.com |
      | password | test123        |
    When I click a button "Login"

  @IN-2 @regression
  Scenario: Verify when user login will see "Sign out" button only
    Then Verify "Sign out" button is present
    Then Verify "Manage Access" Button is not displayed

  @IN-9 @regression
  Scenario: Verify "Sign out" button works as expected
    And I click a button "Sign out"
    Then verify I have been redirected to login page
