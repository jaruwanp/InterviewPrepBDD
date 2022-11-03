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

  @IN-5A
  Scenario Outline: Test adding questions on Coding dashboard
    When I click a button "Coding"
    And I click a button "Enter new question "
    And I enter coding question "<questions>" I want to add
    And I click a button "Enter"
    Then Verify the "<questions>" I entered to coding dashboard are accepted as they contain letter, numbers, and any special characters
    Examples:
      | questions                                                            |
      | What is Java? - Letter only - by Grace                               |
      | What is Selenium - 1234567890 - Letter and Numbers - by Grace        |
      | What is Cucumber - @#$$$$&**~)_+&&^% - special characters - by Grace |

  @IN-5B
  Scenario Outline: Test adding questions on Coding dashboard
    When I click a button "Soft skills"
    And I click a button "Enter new question "
    And I enter soft skill "<questions>" I want to add
    And I click a button "Enter"
    Then Verify the "<questions>" I entered to soft skill dashboard are accepted as they contain letter, numbers, and any special characters
    Examples:
      | questions                                                                            |
      | What are soft skills is Java? - Letter only - by Grace                               |
      | What are these numbers: 1234567890990000 - Letter and Numbers - by Grace             |
      | What are these special characters: @#$$$$&**~)_+&&^% - special characters - by Grace |

  @IN-6
  Scenario: Verify a user can edit or delete the question I have added
    When I click a button "Coding"
    And I click a button "Enter new question "
    And I enter question "Hello this is my new question today, by Grace"
    And I click a button "Enter"
    And Click edit the topic "Hello this is my new question today, by Grace" I've added by adding the word "-updated"
    Then Verify the topic I've edited should be "Hello this is my new question today, by Grace -updated"
    Then Verify I can delete the question "Hello this is my new question today, by Grace -updated" I've created