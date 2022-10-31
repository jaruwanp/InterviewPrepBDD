package step_definitions;

import data.pojos.Person;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CommonPage;
import pages.UserAccessPage;
import utils.BrowserUtils;
import utils.CucumberLogUtils;

import java.util.List;
import java.util.Map;

public class NI13to17Steps implements CommonPage {
    UserAccessPage page;
    Person person;
    public  NI13to17Steps(){
        page = new UserAccessPage();
        person = new Person("Jaruwan","p","x","s","1");
    }
    @Then("Verify the following fields are displayed")
    public void verifyTheFollowingFieldsAreDisplayed(List<String> fields) {
        WebElement element = null;
       for (String each: fields){

           switch (each){
               case "Role":
                   element = page.selectRole;
                   break;
               case "Batch":
                   element = page.selectBatch;
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
        for (String key : userInfo.keySet()) {
            switch (key){
                case "Role":
                    BrowserUtils.selectByVisibleText(page.selectRole,userInfo.get(key));
                    break;
                case "Batch":
                    BrowserUtils.selectByVisibleText(page.selectBatch,userInfo.get(key));
                    break;
                default:
                    BrowserUtils.sendKeys(this.getElementByXpath(XPATH_TEMPLATE_INPUT_FIELD,key),userInfo.get(key));
            }

        }

    }


    @Then("Verify the new user with the following info is displayed in the table")
    public void verifyTheNewUserIsDisplayedInTheTable(Map<String,String> userInfo) {
       //must have no error message
        CucumberLogUtils.logInfo("Check if any error message",false);

        BrowserUtils.assertTrue(page.errorMessage.size()==0);

        // page.errorMessage.size()
    // BrowserUtils.sleep(2000);

        for(String key:userInfo.keySet()){
            CucumberLogUtils.logInfo(key + "=" + userInfo.get(key),false);
            BrowserUtils.assertTrue(page.checkExistingTextInTable(userInfo.get(key)));
            System.out.println(key + " | " + userInfo.get(key));
        }
        //Delete old data
       page.deleteUserByEmail(userInfo.get("E-mail"));
    }

    @And("I select the following filter option")
    public void iSelectTheFollowingFilterOption(Map<String,String> filterOptions) {
        for(String key:filterOptions.keySet()){
            System.out.println(key + " | " + filterOptions.get(key));
        }
    }
}
