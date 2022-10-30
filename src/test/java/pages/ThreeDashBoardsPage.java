package pages;

import org.openqa.selenium.support.PageFactory;
import step_definitions.ThreeDashBoardsSteps;
import utils.BrowserUtils;

public class ThreeDashBoardsPage {
    public ThreeDashBoardsPage(){PageFactory.initElements(BrowserUtils.getDriver(),this);}
}
