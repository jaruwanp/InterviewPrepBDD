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
      | First Name | Jaruwan           |
      | Last Name  | Patt              |
      | E-mail     | jaruwanp@demo.com |
      | Role       | Instructor        |
      | Batch      | 6                 |
    And I click a button "Add User"
    Then Verify the new user with the following info is displayed in the table
      | First Name | Jaruwan           |
      | Last Name  | Patt              |
      | E-mail     | jaruwanp@demo.com |
      | Role       | Instructor        |
      | Batch      | 6                 |

  @NI-15 @regression
  Scenario Outline: Test Filter-user functionality
    And I select the "<Filter-Option>" option
    And I enter "<Key>" I want to filter
    And I click a button "Search-Icon"
    Then Verify the result display as expected
    Examples:
      | Filter-Option | Key             |
      | All           | admin           |
      | Firstname     | John            |
      | Lastname      | admin           |
      | Email         | admin@yahoo.com |
      | Role          | Student         |
      | Batch         | 1               |
