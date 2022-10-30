package step_definitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import pages.CommonPage;
import pages.UserAccessPage;
import utils.BrowserUtils;

import java.util.List;

public class NI13to17Steps implements CommonPage {
    UserAccessPage userAccessPage;
    public  NI13to17Steps(){
        userAccessPage = new UserAccessPage();
    }
    @Then("Verify the following fields are displayed")
    public void verifyTheFollowingFieldsAreDisplayed(List<String> fields) {
        WebElement element = null;
       for (String each: fields){

           switch (each){
               case "Role":
                   element = userAccessPage.selectRole;
                   break;
               case "Batch":
                   element = userAccessPage.selectBatch;
                   break;
               default:
                  element = this.getElementByXpath(XPATH_TEMPLATE_INPUT_FIELD,each);
           }
           BrowserUtils.highlightElement(element);
           BrowserUtils.assertTrue(element.isDisplayed());
       }

    }
}
