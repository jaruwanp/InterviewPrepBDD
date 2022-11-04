Feature: Dashboard page tests
  Background:
    Given I open url of homepage
    When I fill out login form with following details:
      | email    | test@yahoo.com |
      | password | test123        |
    And I click a button "Login"

  @IN-3 @regression
  Scenario: Verify all of the three dashboards are displayed
    Then Verify following dashboards are displayed
      | All Topics  |
      | Coding      |
      | Soft skills |

  @IN-4 @IN-4A @regression
  Scenario: Verify "Do's functionality" is working as expected
    When I click a button "Add do "
    And I add input text Do: "Test12344567"
    And I click a button "Enter"
    Then Verify "Test12344567" exists in the lasted row of Do's table

  @IN-4 @IN-4B @regression
  Scenario: Verify "Dont's functionality" is working as expected
    When I click a button "Add don't"
    And I add input text Don't: "Test12344567"
    And I click a button "Enter"
    Then Verify "Test12344567" exists in the lasted row of Dont's table

  @IN-4 @IN-4C @regression
  Scenario: Verify "Do functionality" accepts only letters and numbers
    When I click a button "Add do "
    And I add input text Do: "Test%%12344567@##$%&&%%%"
    And I click a button "Enter"
    Then Verify "Test%%12344567@##$%&&%%%" does not exist in the lasted row of Do's table

  @IN-4 @IN-4D @regression
  Scenario: Verify "Don't functionality" accepts only letters and numbers
    When I click a button "Add don't"
    And I add input text Don't: "Test%%12344567@##$%&&%%%"
    And I click a button "Enter"
    Then Verify "Test%%12344567@##$%&&%%%" does not exist in the lasted row of Dont's table

  @IN-5 @IN-5A @regression
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

  @IN-5 @IN-5B @regression
  Scenario Outline: Test adding questions on Soft skills dashboard
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

  @IN-6 @regression
  Scenario: Verify a user can edit or delete question he/she added
    When I click a button "Coding"
    And I click a button "Enter new question "
    And I enter question "Hello this is my new question today, by Grace"
    And I click a button "Enter"
    And Click edit the topic "Hello this is my new question today, by Grace" I've added by adding the word "-updated"
    Then Verify the topic I've edited should be "Hello this is my new question today, by Grace -updated"
    Then Verify I can delete the question "Hello this is my new question today, by Grace -updated" I've created

  @IN-7 @regression
  Scenario: Verify "All Topics" option will display all question from other dashboards
    Then I verify all questions in following categories should be displayed in "All Topics"
      | Coding        |
      | Soft skills   |
      | New Dashboard |
      | Prep          |
      | Java          |

  @IN-8 @IN-8A @regression
  Scenario: Verify search criteria should not accept keyword length more than 40 characters
    And I click a button "All Topics"
    And I enter a search keyword "123456789012345678901234567890123456789012345"
    And I click a button "Search icon"
    Then Verify that search function should not accept a long keyword

  @IN-8 @IN-8B @regression
  Scenario: Verify "Show all" button will bring back all question to view by removing the filter
    And I click a button "All Topics"
    And I enter a search keyword "java"
    And I click a button "Search icon"
    Then Verify it brings back all the topic by removing the keyword