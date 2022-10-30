package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import pages.CommonPage;
import pages.LoginPage;
import utils.BrowserUtils;

public class LoginSteps implements CommonPage {
    LoginPage page;
    public LoginSteps(){
        page=new LoginPage();
    }

    @Given("I open login page")
    public void iOpenLoginPage() {
    }

    @Then("Verify the title is {string}")
    public void verifyTheTitleIs(String title) {
        BrowserUtils.assertEquals(BrowserUtils.getDriver().getTitle(),title);
    }

    @Then("I enter username {string}")
    public void enterUsername(String username) {
       BrowserUtils.sendKeys(getElementByXpath(XPATH_TEMPLATE_INPUT_FIELD,"Username"),username);
    }

    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        BrowserUtils.sendKeys(getElementByXpath(XPATH_TEMPLATE_INPUT_FIELD,"Password"),password);
    }

    @And("I click a button {string}")
    public void clickAButton(String button) {
        WebElement element = null;
        switch (button) {
            case "LOGIN":
                element=getElementByXpath(XPATH_TEMPLATE_INPUT_FIEDNAME,"login-button");
                break;
            default:
                element = getElementByXpath(XPATH_TEMPLATE_BUTTON, button);
        }
        BrowserUtils.click(element);
    }

    @Then("Verify I can login successfully")
    public void verifyICanLoginSuccessfully() {
        String expectedURL = "https://www.saucedemo.com/inventory.html";
        BrowserUtils.assertEquals(BrowserUtils.getDriver().getCurrentUrl(),expectedURL);
    }
}
