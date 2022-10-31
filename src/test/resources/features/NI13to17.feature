Feature: IN13-IN17 Tests

  Background:
    Given I open url of homepage
    When I fill out login form with following details:
      | email    | admin@yahoo.com |
      | password | admin123        |
    And I click a button "Login"
    And I click a button "Manage Access"

  @NI-13 @regression
  Scenario: Verify manage access form
    Then Verify the following fields are displayed
      | First Name |
      | Last Name  |
      | E-mail     |
      | Role       |
      | Batch      |

  @NI-14 @regression
  Scenario: Add a new user in Manage Access page
    And I fill out the following info to create a new user
      | First Name | Jaruwan |
      | Last Name  | Patt    |
      | E-mail     | jaruwanp@intwprac@demo.com |
      | Role       | Instructor                 |
      | Batch      | 6                          |
    Then verify the new user is displayed in the table

      