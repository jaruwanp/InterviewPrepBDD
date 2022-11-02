package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CommonPage;
import pages.DashboardPage;
import pages.HomePage;
import pages.UserAccessPage;
import utils.BrowserUtils;

import java.util.Map;


public class HomeSteps implements CommonPage {
    HomePage page;

    DashboardPage dashboardPage;
    UserAccessPage userAccessPage;

    public HomeSteps() {
        page = new HomePage();
        userAccessPage = new UserAccessPage();
        dashboardPage = new DashboardPage();
    }

    @Given("I open url of homepage")
    public void i_open_url_of_homepage() {
        BrowserUtils.getDriver();
    }

    @Then("Verify header text is {string}")
    public void verify_header_text_is(String headerTitle) {
        BrowserUtils.assertEquals(BrowserUtils.getDriver().getTitle(), headerTitle);
    }

    @When("I fill out login form with following details:")
    public void iFillOutLoginFormWithFollowingDetails(Map<String, String> map) {
        for (String key : map.keySet()) {
            BrowserUtils.sendKeys(
                    BrowserUtils.getDriver().findElement(By.name(key)), map.get(key)
            );
        }
    }

    @And("I click a button {string}")
    public void iClickAButton(String button) {

        WebElement element;
        switch (button) {
            case "Manage Access":
                element = userAccessPage.manageAccessText.get(0);
                break;
            case "Search Icon":
                element = userAccessPage.btnSearchIcon;
                break;
            case "Add don't":
                element = dashboardPage.btnAddDont;
                break;
            case "Sign out":
                element = userAccessPage.signOutBtn;
                break;
            default:
                element = getElementByXpath(XPATH_TEMPLATE_BUTTON, button);
        }
        BrowserUtils.click(element);
    }
}
