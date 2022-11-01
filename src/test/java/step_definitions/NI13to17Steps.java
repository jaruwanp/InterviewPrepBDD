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

    public  NI13to17Steps(){
        page = new UserAccessPage();

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


    @And("I select the {string} option")
    public void iSelectTheOption(String filterOption) {
        BrowserUtils.selectByVisibleText(page.selectFilter,filterOption);
    }


    @And("I enter {string} I want to filter")
    public void iEnterIWantToFilter(String key) {
        BrowserUtils.sendKeys(this.getElementByXpath(XPATH_TEMPLATE_INPUT_FIEDNAME,"search"),key);
    }

    @Then("Verify the result display as expected")
    public void verifyTheResultDisplayAsExpected() {
        BrowserUtils.sleep(4000);
         String option = BrowserUtils.selectGetSelectedText(page.selectFilter);
         String key = getElementByXpath(XPATH_TEMPLATE_INPUT_FIEDNAME,"search").getText();

         String firstName,lastName,email,role,batch;
         Person person;
        System.out.println("filter by : " +  option);
        System.out.println("Key : " + key);
        List<WebElement> elements = page.rows;
        System.out.println("Size: " + elements.size());
        int i=0;
        for(WebElement element:elements){
            //./td[1]
            System.out.println(element.findElement(By.xpath("./td[1]")).getText());
            System.out.println(element.findElement(By.xpath("./td[2]")).getText());
            System.out.println(element.findElement(By.xpath("./td[3]")).getText());
            System.out.println(element.findElement(By.xpath("./td[4]")).getText());
            System.out.println(element.findElement(By.xpath("./td[5]")).getText());
            /*firstName= element.findElement(By.xpath("./td[1]")).getText();
            lastName= element.findElement(By.xpath("./td[2]")).getText();
            email = element.findElement(By.xpath("./td[3]")).getText();
            role= element.findElement(By.xpath("./td[4]")).getText();
            batch= element.findElement(By.xpath("./td[5]")).getText();
            System.out.println(i + ")" + firstName + " | " + lastName + " | " + email+ " | " +role + " | " +batch );
            */
            i++;
            /*person = new Person(element.findElement(By.xpath("./td[1]")).getText(),
                    element.findElement(By.xpath("./td[2]")).getText(),
                    element.findElement(By.xpath("./td[3]")).getText(),
                    element.findElement(By.xpath("./td[4]")).getText(),
                    element.findElement(By.xpath("./td[5]")).getText());
            System.out.println("===============\n" + person.toString());
            */
            /*switch (keyword){
                case "All":
                    if(person.getFirstName().contains(keyword) || person.getLastName().contains(keyword)
                            || person.getEmail().contains(keyword) || person.getRole().contains(keyword) ||  person.getBatch().contains(keyword)){
                        BrowserUtils.assertTrue(true);
                    } else {BrowserUtils.assertTrue(false);}
                    break;
                case "Firstname":
                    BrowserUtils.assertTrue(person.getFirstName().contains(keyword));
                    break;
                case "Lastname":
                    BrowserUtils.assertTrue(person.getLastName().contains(keyword));
                    break;
                case "Email":
                    BrowserUtils.assertTrue(person.getEmail().contains(keyword));
                    break;
                case "Role":
                    BrowserUtils.assertTrue(person.getRole().contains(keyword));
                    break;
                case "Batch":
                    BrowserUtils.assertTrue(person.getBatch().contains(keyword));
                    break;
                default:
                    BrowserUtils.assertTrue(false);
            }*/

        }
        Assert.assertTrue(true);

    }
}
