package step_definitions;

import data.pojos.Person;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import pages.CommonPage;
import pages.UserAccessPage;
import utils.BrowserUtils;

import java.util.List;
import java.util.Map;

public class NI13to17Steps implements CommonPage {
    UserAccessPage userAccessPage;
    Person person;
    public  NI13to17Steps(){
        userAccessPage = new UserAccessPage();
        person = new Person("Jaruwan","p","x","s","1");
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

    @And("I fill out the following info to create a new user")
    public void iFillOutTheFollowingInfoToCreateANewUser(Map<String,String> userInfo) {
    }


    @Then("verify the new user is displayed in the table")
    public void verifyTheNewUserIsDisplayedInTheTable() {
    }
}
