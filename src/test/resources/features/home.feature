Feature: Homepage tests
  @IN-1 @regression
  Scenario: Verify header of current project
    Given I open url of homepage
    Then Verify header text is "Interview App"
