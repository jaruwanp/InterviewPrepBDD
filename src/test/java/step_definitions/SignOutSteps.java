package step_definitions;

import io.cucumber.java.en.When;
import pages.SignOutPage;
import utils.BrowserUtils;

public class SignOutSteps {

    SignOutPage page;

    public SignOutSteps() {
        page = new SignOutPage();
    }


    @When("I click Sign out button")
    public void i_click_sign_out_button() {
        // Write code here that turns the phrase above into concrete actions
        BrowserUtils.click(page.signOutBtn);

    }
}
