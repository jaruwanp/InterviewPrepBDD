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

    @FindBy(xpath = "//div[@class='error_message']")
    public List<WebElement> errorMessage;

    @FindBy(xpath = "(//button[@type='submit'])[2]")
    public WebElement btnSearchIcon;

    @FindBy(xpath = "(//select[@class='form-control'])[3]")
    public WebElement selectFilter;

    @FindBy(xpath = "//tbody/tr")
    public List<WebElement> rows;

    @FindBy(xpath = "//table[@class='table table-striped table-hover']")
    public WebElement tblUsers;

    @FindBy(xpath ="//button[@class='btn btn-danger mt-3' and text()='Delete']")
    public WebElement btnConfirmDeleteUser;

    @FindBy(xpath = "//a[@class='navbar-brand']")
    public WebElement logo;

    public boolean checkExistingTextInTable(String str){
        System.out.println("//td[text()='" + str + "']");
        return  (BrowserUtils.getDriver().findElements(By.xpath("//td[text()='" + str + "']")).size() > 0);
    }


    //Delete button in each row
    public WebElement getDeleteBtnByEmail(String email){
        return BrowserUtils.getDriver().findElement(
                By.xpath("//td[text()='" + email + "']/following::button[1]")
        );
    }

    //Edit button in popup window
    public WebElement getEditPopUpBtnByEmail(String email){
        return BrowserUtils.getDriver().findElement(
                By.xpath("//td[text()='" + email + "']/following::button[text()='Edit']")
        );
    }
    //Delete button in popup window
    public WebElement getDeletePopUpBtnByEmail(String email){
        return BrowserUtils.getDriver().findElement(
                By.xpath("//td[text()='" + email + "']/following::button[text()='Delete']")
        );
    }

    //Reset button in popup window
    public WebElement getResetPSWPopUpBtnByEmail(String email){
        return BrowserUtils.getDriver().findElement(
                By.xpath("//td[text()='" + email + "']/following::button[text()='Reset Password']")
        );
    }

    public int getNumberOfTotalUser(){
        WebDriver driver = BrowserUtils.getDriver();
        logo.click();
        manageAccessText.get(0).click();
        BrowserUtils.waitForElementVisibility(rows.get(0));
        BrowserUtils.sleep(3000);
        return rows.size();
    }

    public boolean deleteUserByEmail(String email){
        String path="//td[text()='" + email + "']/following::button[1]";
        WebDriver driver = BrowserUtils.getDriver();
        if (driver.findElements(By.xpath(path)).size() > 0 ){
            BrowserUtils.click(driver.findElement(By.xpath(path)));
            BrowserUtils.click(getDeletePopUpBtnByEmail(email));
            BrowserUtils.click(btnConfirmDeleteUser);
            return true;
        }
        else {
            return false;
        }

    }
}

