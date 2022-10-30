package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BrowserUtils;

public interface CommonPage {
    String XPATH_TEMPLATE_BUTTON = "//button[text()='%s']";
    String XPATH_TEMPLATE_LINKTEXT = "//a[text()='%s']";
    String XPATH_TEMPLATE_TEXT = "//*[text()='%s']";
    String XPATH_TEMPLATE_TEXT_CONTAINS = "//*[contains(text(), '%s')]";
    String XPATH_TEMPLATE_INPUT_FIELD = "//input[@placeholder='%s']";

    String XPATH_TEMPLATE_INPUT_FIEDNAME = "//input[@name='%s']";
    ////input[@value='Login']


    public default WebElement getElementByXpath(String xpath, String keyword) {
        System.out.printf(xpath, keyword);
        return BrowserUtils.getDriver().findElement(By.xpath(String.format(xpath, keyword)));
    }

}
