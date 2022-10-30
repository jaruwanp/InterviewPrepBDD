Feature: Login test

  @US000 @Smoke
  Scenario: Test title of the login page
    Given I open login page
    Then Verify the title is "Interview App"

   @US301 @Smoke
   Scenario: Verify standard_uer can login with the right password
     Given I open login page
     When I enter username "test@yahoo.com"
     And I enter password "test123"
     And I click a button "Login"
     Then Verify I can login successfully
