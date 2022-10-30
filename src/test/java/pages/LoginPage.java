package pages;

import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class LoginPage {
    public  LoginPage(){
        PageFactory.initElements(BrowserUtils.getDriver(),this);
    }
}
