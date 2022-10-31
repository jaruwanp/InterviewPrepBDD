package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class UserAccessPage {
    public UserAccessPage(){
        PageFactory.initElements(BrowserUtils.getDriver(),this);
    }
    @FindBy(xpath = "//a/u[text()='Sign out']")
    public WebElement signOutBtn;

    @FindBy(xpath = "//a/u[text()='Manage Access']")
    public List<WebElement> manageAccessText;

    @FindBy(id = "Batch")
    public WebElement selectBatch;

    @FindBy(id = "Role")
    public WebElement selectRole;

   @FindBy(xpath = "//td[1]")
    public List<WebElement> firstNames;

   @FindBy(xpath = "//td[2]")
    public List<WebElement> lastNames;

    @FindBy(xpath = "//td[3]")
    public List<WebElement> emails;

    @FindBy(xpath = "//td[4]")
    public List<WebElement> rples;

    @FindBy(xpath = "//td[5]")
    public List<WebElement> batchs;

}
