package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CommonPage;
import pages.HomePage;
import utils.BrowserUtils;

public class HomeSteps implements CommonPage {
    HomePage page;

    public HomeSteps() {
        page = new HomePage();

    }

    @Given("I open url of homepage")
    public void i_open_url_of_homepage() {
        BrowserUtils.getDriver();
    }
    @Then("Verify header text is {string}")
    public void verify_header_text_is(String headerTitle) {
            BrowserUtils.assertEquals(BrowserUtils.getDriver().getTitle(),headerTitle);
        }

    @When("I click a button Sign out")
    public void iClickAButtonSignOut(String signOutBtn) {
        BrowserUtils.click(page.signOutBtn);
    }

//    @Then("I enter username {string}")
//    public void iEnterUsername(String username) {
//        BrowserUtils.sendKeys(getElementByXpath(XPATH_TEMPLATE_INPUT_FIELD,"Enter Username"),username);
//    }
//
//    @And("I enter password {string}")
//    public void iEnterPassword(String password) {
//        BrowserUtils.sendKeys(getElementByXpath(XPATH_TEMPLATE_INPUT_FIELD,"Enter Password"),password);
//    }

    @Then("Verify link text {string} is displayed")
    public void verifyLinkTextIsDisplayed() {
        BrowserUtils.isDisplayed(
                BrowserUtils.getDriver().findElement(By.xpath(
                        String.format(XPATH_TEMPLATE_LINKTEXT, "Manage Access"))));
    }
}


