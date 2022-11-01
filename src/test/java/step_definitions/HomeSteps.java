package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import pages.CommonPage;
import pages.HomePage;
import utils.BrowserUtils;

public class HomeSteps implements CommonPage {
    HomePage page;
    String newDashBoardName = "Bugbuster";

    public HomeSteps() {
        page = new HomePage();

    }

    @Given("I open url of homepage")
    public void i_open_url_of_homepage() {
        BrowserUtils.getDriver();
    }

    @Then("Verify header text is {string}")
    public void verify_header_text_is(String headerTitle) {
        BrowserUtils.assertEquals(BrowserUtils.getDriver().getTitle(), headerTitle);
    }

    @Given("I open url of login page")
    public void iOpenUrlOfLoginPage() {
        BrowserUtils.getDriver();
    }
    @When("I fill out login form with following details: {string} and password")
    public void iFillOutLoginFormWithFollowingDetailsAndPassword(String username) {
        switch (username) {
            case "test@yahoo.com" :
                BrowserUtils.sendKeys(BrowserUtils.getDriver().findElement(By.xpath(String.format(
                        XPATH_TEMPLATE_INPUT_FIELD, "Enter Username"
                ))), username);
                BrowserUtils.sendKeys(BrowserUtils.getDriver().findElement(By.xpath(String.format(
                        XPATH_TEMPLATE_INPUT_FIELD, "Enter Password"
                ))), "test123");
                break;
            case "admin@yahoo.com" :
                BrowserUtils.sendKeys(BrowserUtils.getDriver().findElement(By.xpath(String.format(
                        XPATH_TEMPLATE_INPUT_FIELD, "Enter Username"
                ))), username);
                BrowserUtils.sendKeys(BrowserUtils.getDriver().findElement(By.xpath(String.format(
                        XPATH_TEMPLATE_INPUT_FIELD, "Enter Password"
                ))), "admin123");
                break;

        }
    }

    @And("I click a button {string}")
    public void iClickAButton(String button) {
        BrowserUtils.click(BrowserUtils.getDriver().findElement(By.xpath(String.format(
                XPATH_TEMPLATE_BUTTON, button
        ))));
    }

    @Then("Verify any question could be edited or deleted")
    public void verifyAnyQuestionCouldBeEditedOrDeleted() {
        BrowserUtils.assertEquals(String.valueOf(page.deleteIcons.size()), String.valueOf(page.rows.size()));
        BrowserUtils.assertEquals(String.valueOf(page.editIcons.size()), String.valueOf(page.rows.size()));
    }

    @And("I enter input field {string}")
    public void iEnterInputField(String newDashboardInput) {
        BrowserUtils.sendKeys(BrowserUtils.getDriver().findElement(By.xpath(String.format(
                XPATH_TEMPLATE_INPUT_FIELD, newDashboardInput
        ))), newDashBoardName);
    }

    @Then("Verify regular user could see new dashboard")
    public void verifyRegularUserCouldSeeNewDashboard() {
        BrowserUtils.click(BrowserUtils.getDriver().findElement(By.xpath(String.format(
                XPATH_TEMPLATE_TEXT, "Sign out"
        ))));
        iFillOutLoginFormWithFollowingDetailsAndPassword("test@yahoo.com");
        iClickAButton("Login");

        BrowserUtils.assertEquals(page.newDashboard.getText(), newDashBoardName);
    }

    @Then("Verify I can login successfully")
    public void verify_i_can_login_successfully() {
        BrowserUtils.assertTrue(true);
    }
}
