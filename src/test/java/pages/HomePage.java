package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import step_definitions.HomeSteps;
import utils.BrowserUtils;

import java.util.List;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(BrowserUtils.getDriver(), this);
    }

    @FindBy(xpath = "//form[@class='form-inline']/*[last()]")
    public WebElement newDashboard;

    @FindBy(xpath = "//button[contains(@class,'danger ml')]")
    public List<WebElement> deleteIcons;

    @FindBy(xpath = "//button[contains(@class,'outline-warning')]")
    public List<WebElement> editIcons;

    @FindBy(xpath = "//div[contains(@class,'DoAndDont')]//div[@class='row']")
    public List<WebElement> rows;
}
