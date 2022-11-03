package step_definitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import pages.CommonPage;
import pages.UserAccessPage;
import utils.BrowserUtils;

public class UserAccessSteps implements CommonPage {

    UserAccessPage page;

    public UserAccessSteps() {
        page = new UserAccessPage();

    }

    @Then("Verify {string} button is present")
    public void verify_button_is_present(String signOutText) {
        BrowserUtils.isDisplayed(
                BrowserUtils.getDriver().findElement(
                        By.xpath(String.format(XPATH_TEMPLATE_TEXT, signOutText)))
        );
    }

    @Then("Verify {string} Button is not displayed")
    public void verify_button_is_not_displayed(String manageAccessText) {
        BrowserUtils.assertTrue(page.manageAccessText.size()==0);
    }
}
