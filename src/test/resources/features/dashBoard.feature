Feature: Dashboard page tests

  Background:
    Given I open url of homepage
    When I fill out login form with following details:
      | email    | test@yahoo.com |
      | password | test123        |
    And I click a button "Login"

  @IN-3 @regression
  Scenario: Verify all 3 dashboards are displayed
    Then Verify following input button is displayed:
      | All Topics  |
      | Coding      |
      | Soft skills |

  @IN-4A @regression
  Scenario: Verify Do's functionality is working as expected
    When I click a button "Add do "
    And I add input text Do: "Test12344567"
    And I click a button "Enter"
    Then Verify "Test12344567" exists in the lasted row of Do's table

  @IN-4B @regression
  Scenario: Verify Dont's functionality is working as expected
    When I click a button "Add don't"
    And I add input text Don't: "Test12344567"
    And I click a button "Enter"
    Then Verify "Test12344567" exists in the lasted row of Dont's table

  @IN-4C @regression
  Scenario: Verify Do functionality that accepts only letters and numbers
    When I click a button "Add do "
    And I add input text Do: "Test%%12344567@##$%&&%%%"
    And I click a button "Enter"
    Then Verify "Test%%12344567@##$%&&%%%" does not exist in the lasted row of Do's table

  @IN-4D @regression
  Scenario: Verify Don't functionality that accepts only letters and numbers
    When I click a button "Add don't"
    And I add input text Don't: "Test%%12344567@##$%&&%%%"
    And I click a button "Enter"
    Then Verify "Test%%12344567@##$%&&%%%" does not exist in the lasted row of Dont's table