package step_definitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import pages.CommonPage;
import pages.DashboardPage;
import utils.BrowserUtils;
import org.openqa.selenium.By;
import utils.CucumberLogUtils;

import java.util.ArrayList;
import java.util.List;


public class DashboardSteps implements CommonPage {
    DashboardPage page;
    public DashboardSteps() {
        page = new DashboardPage();
    }

    @And("I enter {string} I want to add")
    public void iEnterIWantToAdd(String topic) {
    }

    @Then("Verify {string} I added are accepted:")
    public void verifyIAddedAreAccepted(String topic) {
    }

    @Then("verify I can edit the topic {string} I've added")
    public void verifyICanEditTheTopicIVeAdded(String arg0) {
    }

    @Then("Verify following input button is displayed:")
    public void verifyFollowingInputButtonIsDisplayed(List<String> buttons) {
        for (String button: buttons){
            BrowserUtils.assertTrue(this.getElementByXpath(XPATH_TEMPLATE_BUTTON,button).isDisplayed());
        }
    }

    @Then("Verify {string} exists in the lasted row of Do's table")
    public void verifyExistsInTheLastedRowOfDoSTable(String txt) {
        BrowserUtils.sleep(3000);
        BrowserUtils.assertEquals(page.doLastRow.getText(),txt);

    }



    @And("I add input text Do: {string}")
    public void iAddInputTextDo(String txt) {
        BrowserUtils.sleep(1000);
        BrowserUtils.sendKeys(page.inputAreaDo,txt);
    }

    @And("I add input text Don't: {string}")
    public void iAddInputTextDonT(String txt) {
        BrowserUtils.sleep(1000);
        BrowserUtils.sendKeys(page.inputAreaDont,txt);
    }

    @And("I click Do Button")
    public void iClickADoButton() {
        BrowserUtils.click(page.btnEnterDo);
    }

    @And("I click Don't button")
    public void iClickDonTButton() {
        BrowserUtils.click(page.btnEnterDont);
    }

    @Then("Verify {string} exists in the lasted row of Dont's table")
    public void verifyExistsInTheLastedRowOfDontSTable(String txt) {
        BrowserUtils.sleep(3000);
        BrowserUtils.assertEquals(page.doLastRow.getText(),txt);
    }


    @Then("Verify {string} does not exist in the lasted row of Do's table")
    public void verifyDoesNotExistInTheLastedRowOfDoSTable(String txt) {
        BrowserUtils.sleep(3000);
        BrowserUtils.assertFalse(page.doLastRow.getText().equals(txt));
    }

    @Then("Verify {string} does not exist in the lasted row of Dont's table")
    public void verifyDoesNotExistInTheLastedRowOfDontSTable(String txt) {
        BrowserUtils.sleep(3000);
        BrowserUtils.assertFalse(page.dontLastRow.getText().equals(txt));


    }

    @And("Click edit the topic {string} I've added by adding the word {string}")
    public void clickEditTheTopicIVeAddedByAddingTheWord(String question, String extension) {
        BrowserUtils.click(page.getEditButtonByQuestion(question));
        BrowserUtils.sendKeys(page.textAreaEditQuestion,extension);
        BrowserUtils.click(page.btnUpdateTopic);
    }

    @Then("Verify the topic I've edited should be {string}")
    public void verifyTheTopicIVeEditedShouldBe(String updated_question) {
        BrowserUtils.sleep(1000);
        BrowserUtils.assertTrue(page.getQuestionsListByQuestion(updated_question).size() > 0);

    }

    @Then("Verify I can delete the question {string} I've created")
    public void verifyICanDeleteTheQuestionIVeCreated(String question) {
        page.deleteQuestionByQuestion(question);
        BrowserUtils.sleep(1000);
        BrowserUtils.assertTrue(page.getQuestionsListByQuestion(question).size() == 0);
    }

    @And("I enter coding question {string} I want to add")
    public void iEnter_IWantToAdd(String question) {
        BrowserUtils.sendKeys(page.textAreaAddQuestion,question);

    }

    @Then("Verify the {string} I entered to coding dashboard are accepted as they contain letter, numbers, and any special characters")
    public void verifyTheIEnteredAreAccepted(String question) {
        BrowserUtils.sleep(1000);
        BrowserUtils.assertTrue(page.getQuestionsListByQuestion(question).size() > 0);
        page.deleteQuestionByQuestion(question);
    }

    @And("I enter soft skill {string} I want to add")
    public void iEnterSoftSkillIWantToAdd(String question) {
        BrowserUtils.sendKeys(this.getElementByXpath(XPATH_TEMPLATE_INPUT_FIEDNAME,"question"),question);
    }

    @Then("Verify the {string} I entered to soft skill dashboard are accepted as they contain letter, numbers, and any special characters")
    public void verifyTheIEnteredToSoftSkillDashboardAreAcceptedAsTheyContainLetterNumbersAndAnySpecialCharacters(String question) {
        BrowserUtils.sleep(1000);
        BrowserUtils.assertTrue(page.getQuestionsListByQuestion(question).size() > 0);
        page.deleteQuestionByQuestion(question);
    }

    @And("I enter question {string}")
    public void iEnterQuestion(String question) {
        BrowserUtils.sendKeys(page.textAreaAddQuestion, question);
    }

    @Then("I verify all questions in following categories should be displayed in \"All Topics\"")
    public void iVerifyAllQuestionsInFollowingCategoriesShouldBeDisplayedIn(List<String> categories) {

        BrowserUtils.click(this.getElementByXpath(XPATH_TEMPLATE_BUTTON,"All Topics"));
        BrowserUtils.sleep(3000);

        //Step1: Add all the topic in an arraylist
        List<String>  allTopics  =new ArrayList<>();
        for(WebElement element:page.listOfAllQuestions){
            allTopics.add(element.getText());
        }
        //Step2: loop through the category you want to verify
        for (String category:categories){
            List<String> subTopics = new ArrayList<>();
            BrowserUtils.click(page.logo);
            //Click on that Dashboard Category
            BrowserUtils.click(this.getElementByXpath(XPATH_TEMPLATE_BUTTON,category));
            BrowserUtils.sleep(2000);
            //if found list of question , add to array
            if (page.listOfAllQuestions.size() > 0){
                for(WebElement element:page.listOfAllQuestions){
                    subTopics.add(element.getText());
                }
                //Verify that all topic contains sub topic
                for(String topic:subTopics){
                    CucumberLogUtils.logInfo(topic,false);
                    BrowserUtils.assertTrue(allTopics.contains(topic));
                }
            }
            else
            {
                CucumberLogUtils.logInfo("No question found in category:" + category ,false);
                BrowserUtils.assertTrue(true);
            }
        }

    }

    @And("I enter a search keyword {string}")
    public void iEnterASearchKeyword(String keyword) {
        BrowserUtils.sendKeys(this.getElementByXpath(XPATH_TEMPLATE_INPUT_FIEDNAME,"search"),keyword);
    }

    @Then("Verify that search function should not accept a long keyword")
    public void verifyThatSearchFunctionShouldNotAcceptTheLongKeyword() {
        //the result shouln't be the same as original
        BrowserUtils.sleep(1000);
        int totalQAfterFiltered = page.listOfAllQuestions.size();
        BrowserUtils.click(page.logo);
        BrowserUtils.click(this.getElementByXpath(XPATH_TEMPLATE_BUTTON,"All Topics"));
        BrowserUtils.sleep(1000);
        //total question result should be the same as original if the funtion didn't accept keyword
        BrowserUtils.assertTrue(totalQAfterFiltered==page.listOfAllQuestions.size());
    }

    @Then("Verify it brings back all the topic by removing the keyword")
    public void verifyItBringsBackAllTheTopicByRemovingTheKeyword() {
        String log="";
        BrowserUtils.sleep(2000);
        int totalQAfterFiltered = page.listOfAllQuestions.size();
        log += "Total questions after filter = " + totalQAfterFiltered;
        BrowserUtils.click(this.getElementByXpath(XPATH_TEMPLATE_BUTTON,"Show all"));
        BrowserUtils.sleep(2000);
        int totalQAfterReset = page.listOfAllQuestions.size();
        log += ", Total questions after clicking \"Show all\" = " + totalQAfterReset;

        BrowserUtils.assertTrue(totalQAfterFiltered < totalQAfterReset);
        BrowserUtils.click(page.logo);
        BrowserUtils.click(this.getElementByXpath(XPATH_TEMPLATE_BUTTON,"All Topics"));
        BrowserUtils.sleep(2000);
        int totalAfterReloaded = page.listOfAllQuestions.size();
        log += ", Total questions after reloading the \"All topics\" = " + totalAfterReloaded;
        CucumberLogUtils.logInfo(log,false);
        BrowserUtils.assertTrue(totalQAfterReset ==totalAfterReloaded);

    }
}

