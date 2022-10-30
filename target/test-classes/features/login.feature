Feature: Login test

  @US000 @Smoke
  Scenario: Test title of the login page
    Given I open login page
    Then Verify the title is "Swag Labs"

   @US301 @Smoke
   Scenario: Verify standard_uer can login with the right password
     Given I open login page
     When I enter username "standard_user"
     And I enter password "secret_sauce"
     And I click a button "LOGIN"
     Then Verify I can login successfully
