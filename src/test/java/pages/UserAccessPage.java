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
}
