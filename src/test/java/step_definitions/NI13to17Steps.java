package step_definitions;

import data.pojos.Person;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

//
//    @And("I click Search Icon button")
//    public void iClickSearchIconButton() {
//        String key = getElementByXpath(XPATH_TEMPLATE_INPUT_FIEDNAME,"search").getText();
//        System.out.println("key=" + key);
//       BrowserUtils.click(page.btnSearchIcon);
//       getElementByXpath(XPATH_TEMPLATE_INPUT_FIEDNAME,"search").sendKeys(key);
//    }

//Verify the result displayed related to keyword: "<Key>" and option: "<Filter-Option>"
    @Then("Verify the result displayed related to keyword: {string} and option: {string}")
    public void verifyTheResultDisplayedRelatedToTheAnd(String key ,String filterOption) {
        BrowserUtils.sleep(2000);
        CucumberLogUtils.logInfo("Filter option: " + filterOption + " | Keyword: " + key ,false);
        if (page.rows.size() > 0 ) {

            System.out.println("filter by : " +  filterOption);
            System.out.println("Key : " + key);
            List<WebElement> elements = page.rows;
            System.out.println("Size: " + elements.size());
            int i=0;
            for(WebElement element:elements){
                //BrowserUtils.highlightElement(element);
                i++;
                Person person = new Person(element.findElement(By.xpath("./td[1]")).getText(),
                        element.findElement(By.xpath("./td[2]")).getText(),
                        element.findElement(By.xpath("./td[3]")).getText(),
                        element.findElement(By.xpath("./td[4]")).getText(),
                        element.findElement(By.xpath("./td[5]")).getText());
              //  System.out.println("===============\n" + person.toString());
                CucumberLogUtils.logInfo("Verify data: [" + i + "] " + person.toString(),false);
            switch (filterOption){
                case "All":
                    if(person.getFirstName().contains(key) || person.getLastName().contains(key)
                            || person.getEmail().contains(key) || person.getRole().contains(key)
                            ||  person.getBatch().contains(key)) {
                        BrowserUtils.assertTrue(true);
                    } else {BrowserUtils.assertTrue(false);}
                    break;
                case "Firstname":
                    BrowserUtils.assertTrue(person.getFirstName().contains(key));
                    break;
                case "Lastname":
                    BrowserUtils.assertTrue(person.getLastName().contains(key));
                    break;
                case "Email":
                    BrowserUtils.assertTrue(person.getEmail().contains(key));
                    break;
                case "Role":
                    BrowserUtils.assertTrue(person.getRole().contains(key));
                    break;
                case "Batch":
                    BrowserUtils.assertTrue(person.getBatch().contains(key));
                    break;
                default:
                    BrowserUtils.assertTrue(false);
            }
            }
        }
        else {
            CucumberLogUtils.logInfo("No data found, bypassed assertion" ,false);
            BrowserUtils.assertTrue(true);
        }

    }


    @Then("verify the following options are enable for each user")
    public void verifyTheFollowingOptionsAreEnableForEachUser(List<String> options) {
        String path,email;
       // System.out.println(option);
        BrowserUtils.waitScollAndHightlight(page.tblUsers);
        List<WebElement> elements = page.rows;
        System.out.println(page.rows.size());

        //loop to verify each function
        for(String option:options){
            if (page.rows.size() > 0){
                WebDriver driver = BrowserUtils.getDriver();
                for(WebElement element:elements){
                    email = element.findElement(By.xpath("./td[3]")).getText();
                    //Click Delete Button in each row
                    BrowserUtils.click(page.getDeleteBtnByEmail(email));

                    WebElement btnElement;
                    //When the popup presented , verify 3 bouttons are displayed
                    switch (option){
                        case "Edit":
                            btnElement = page.getEditPopUpBtnByEmail(email);
                            break;
                        case "Delete":
                            btnElement = page.getDeletePopUpBtnByEmail(email);
                            break;
                        case "Reset Password":
                            btnElement = page.getResetPSWPopUpBtnByEmail(email);
                            break;
                        default:
                            btnElement = null;
                    }
                    BrowserUtils.highlightElement(btnElement);
                    BrowserUtils.assertTrue(btnElement.isDisplayed());
                    BrowserUtils.sleep(1000);

                    //cancel clicking delele button, needs to click any element in the page
                    element.findElement(By.xpath("./td[3]")).click();

                }
            }
            else {
                CucumberLogUtils.logInfo("No data found, bypassed assertion" ,false);
                BrowserUtils.assertTrue(true);
            }

        }



        BrowserUtils.assertTrue(true);
    }

    @And("I filtered data with email {string} and found {int} row")
    public void iFilteredDataWithEmailAndFoundRow(String email, int total) {
        BrowserUtils.sendKeys(this.getElementByXpath(XPATH_TEMPLATE_INPUT_FIEDNAME,"search"),email);
        BrowserUtils.click(page.btnSearchIcon);
        BrowserUtils.sleep(1000);
        BrowserUtils.assertTrue(page.rows.size() ==total);
    }

    @Then("Verify the result displayed all the data")
    public void verifyTheResultDisplayedAllTheData() {
        BrowserUtils.sleep(3000);
        BrowserUtils.waitForElementVisibility(page.rows.get(0));
        int totalRow = page.rows.size();
        String log = "Result =" + totalRow;
        int totalUser = page.getNumberOfTotalUser();
        CucumberLogUtils.logInfo("Result =" + totalRow + " | Actual users=" + totalUser,false);
        BrowserUtils.assertTrue(totalRow == totalUser);
        BrowserUtils.sleep(1000);

    }
}
