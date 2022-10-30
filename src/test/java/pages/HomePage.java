package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(xpath = "//title[text()='Interview App']")
    public WebElement headerTitle;

   @FindBy(xpath = "//*[text()='Sign out']")
    public WebElement signOutBtn;
}
