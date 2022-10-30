package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.BrowserType;
import pages.CommonPage;
import utils.BrowserUtils;

import java.util.List;

public class ThreeDashBoardsSteps implements CommonPage {

    @Then("Verify following input button is displayed:")
    public void verifyFollowingInputButtonIsDisplayed(List<String> dataTable) {
        for (String each : dataTable) {
            BrowserUtils.getDriver().findElement(
                    By.xpath(String.format(XPATH_TEMPLATE_BUTTON, each))
            );
        }
    }

//        BrowserUtils.isDisplayed(
//                BrowserUtils.getDriver().findElement(By.xpath(
//                        String.format(XPATH_TEMPLATE_LINKTEXT, "All Topics")
//                ))
//        );


}
