Feature: : 3 Dashboards Page Test

  Background:
    Given I open url of homepage
    When I fill out login form with following details:
      | email    | test@yahoo.com |
      | password | test123        |
    When I click a button "Login"

  @In-3 @regression
  Scenario: Verify all 3 dashboards are displayed

    Then Verify following input button is displayed:
      | All Topics  |
      | Coding      |
      | Soft skills |



