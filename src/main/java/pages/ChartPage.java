package pages;

import org.openqa.selenium.WebDriver;

public class ChartPage extends BasePage {
    private static final String ALLOW_ALL_COOKIES_BUTTON = "//a[@id='CybotCookiebotDialogBodyButtonAccept']";

    public ChartPage(WebDriver driver) {
        super(driver);
    }


    public void clickOnAllowAllCookiesButton() {
        waitForLoadElement(ALLOW_ALL_COOKIES_BUTTON);
    }


}
