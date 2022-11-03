package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class DashboardPage {
    public DashboardPage() {
        PageFactory.initElements(BrowserUtils.getDriver(), this);
    }


    @FindBy(id = "inputArea1")
    public WebElement inputAreaDo;

    @FindBy(id = "inputArea2")
    public WebElement inputAreaDont;

    @FindBy(xpath = "(//div[@class='anyClass']/div[last()])[1]/div[2]")
    public WebElement doLastRow;


    @FindBy(xpath = "(//div[@class='anyClass']/div[last()])[2]/div[2]")
    public WebElement dontLastRow;

    @FindBy(xpath = "(//button[text()='Enter'])[1]")
    public WebElement btnEnterDo;

    @FindBy(xpath = "(//button[text()='Enter'])[2]")
    public WebElement btnEnterDont;

    @FindBy(xpath = "//button[text()=\"Add don't \"]")
    public WebElement btnAddDont;

    @FindBy(id="question")
    public WebElement textAreaAddQuestion;

    @FindBy(xpath = "//textarea[@name='newQuestion']")
    public WebElement textAreaEditQuestion;

    @FindBy(xpath = "//button[@class='btn btn-sm-outline-success']")
    public WebElement btnUpdateTopic;

    public WebElement getEditButtonByQuestion(String question){
        return BrowserUtils.getDriver().findElement(By.xpath("//p[normalize-space()='" + question + "']/following::button[2]"));
    }
    public List<WebElement> getQuestionsListByQuestion(String topic){
        System.out.println("//p[normalize-space()=\"" + topic + "\"]");
        return BrowserUtils.getDriver().findElements(By.xpath("//p[normalize-space()=\"" + topic + "\"]"));
    }

    public void  deleteQuestionByQuestion(String question){
        BrowserUtils.getDriver().findElement(By.xpath("//p[normalize-space()='" + question + "']/following::button[1]")).click();
    }
}