package pages;

import constants.Constant;
import manager.BrowserFactory;
import org.openqa.selenium.*;

public class BasePage {

    protected static WebDriver driver;

    public BasePage() {

    }

    public void openChartPage() {
        this.driver = BrowserFactory.create(Constant.BROWSER, Constant.URL);
    }

    public void clickOnElement(String el) {

        try {
            driver.findElement(By.xpath(el)).click();
        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(el)));
        }

    }

    public void close() {
        driver.close();
    }

    public void quit() {
        driver.quit();
    }


}
