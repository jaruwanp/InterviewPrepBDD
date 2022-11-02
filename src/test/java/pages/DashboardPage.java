package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

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

}