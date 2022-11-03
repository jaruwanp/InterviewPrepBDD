Feature: UserAccess Admin Feature
  Background:
    Given I open url of homepage
    When I fill out login form with following details:
      | email    | admin@yahoo.com |
      | password | admin123        |
    And I click a button "Login"

  @IN-10 @regression
  Scenario: Verify when admin logs in "Manage Access" button should be visible
    Then Verify button "Manage Access" is visible

  @IN-11 @regression
  Scenario: Edit/Delete any question under Interview section
    Then Verify any question could be edited or deleted


  @IN-12 @regression
  Scenario: Add new dashboard
    When I enter input field "New dashboard"
    And I click a button "+ Add"
    Then Verify regular user could see new dashboard

  @IN-13 @regression
  Scenario: Verify manage access form
    When I click a button "Manage Access"
    Then Verify the following fields are displayed
      | First Name |
      | Last Name  |
      | E-mail     |
      | Role       |
      | Batch      |

  @IN-14 @regression
  Scenario: Add a new user in Manage Access page
    When I click a button "Manage Access"
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

  @IN-15 @regression
  Scenario Outline: Test Filter-user functionality
    When I click a button "Manage Access"
    And I select the "<Filter-Option>" option
    And I enter "<Key>" I want to filter
    And I click a button "Search Icon"
    Then Verify the result displayed related to keyword: "<Key>" and option: "<Filter-Option>"
    Examples:
      | Filter-Option | Key             |
      | All           | admin           |
      | Firstname     | John            |
      | Lastname      | admin           |
      | Email         | admin@yahoo.com |
      | Role          | Student         |
      | Batch         | 1               |
  @IN-16 @regression
  Scenario: Verify update user info functionality
    When I click a button "Manage Access"
    Then verify the following options are enable for each user
    | Edit |
    | Delete |
    | Reset Password |

  @IN-17 @regression
  Scenario: Test reset search filter option
    When I click a button "Manage Access"
    And I filtered data with email "admin@yahoo.com" and found 1 row
    And I click a button "Show all"
    Then Verify the result displayed all the data