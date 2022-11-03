package step_definitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.CommonPage;
import pages.DashboardPage;
import utils.BrowserUtils;
import org.openqa.selenium.By;

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
}
