Feature: Home page tests

Background: Navigate to Home Page
Given I open url of homepage

@IN-1 @regression
Scenario: Test header of the home page
Then Verify header text is "Interview App"