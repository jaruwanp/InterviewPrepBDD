package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class UserAccessPage {

    public UserAccessPage() {
        PageFactory.initElements(BrowserUtils.getDriver(), this);
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
    public List<WebElement> tdFirstNames;

    @FindBy(xpath = "//td[2]")
    public List<WebElement> tdLastNames;

    @FindBy(xpath = "//td[3]")
    public List<WebElement> tdEmails;

    @FindBy(xpath = "//td[4]")
    public List<WebElement> tdRples;

    @FindBy(xpath = "//td[5]")
    public List<WebElement> tdBatchs;

    @FindBy(xpath = "//td[6]")
    public List<WebElement> tdBtnsAction;

    @FindBy(xpath = "//div[@class='error_message']")
    public List<WebElement> errorMessage;

    @FindBy(xpath = "(//button[@type='submit'])[2]")
    public WebElement btnSearchIcon;

    @FindBy(xpath = "(//select[@class='form-control'])[3]")
    public WebElement selectFilter;

    @FindBy(xpath = "//tbody/tr")
    public List<WebElement> rows;

    public boolean checkExistingTextInTable(String str){
        System.out.println("//td[text()='" + str + "']");
        return  (BrowserUtils.getDriver().findElements(By.xpath("//td[text()='" + str + "']")).size() > 0);
    }
    public boolean deleteUserByEmail(String email){
        String path="//td[text()='" + email + "']/following::button[1]";
        WebDriver driver = BrowserUtils.getDriver();
        if (driver.findElements(By.xpath(path)).size() > 0 ){
            BrowserUtils.click(driver.findElement(By.xpath(path)));
            path = "//td[text()='" + email + "']/following::button[text()='Delete']";
            BrowserUtils.click(driver.findElement(By.xpath(path)));
            path ="//button[@class='btn btn-danger mt-3' and text()='Delete']";
            BrowserUtils.click(driver.findElement(By.xpath(path)));
            return true;
        }
        else {
            return false;
        }

    }
}
