package pages;

import constants.Constants;
import manager.BrowserFactory;
import org.openqa.selenium.*;

public class BasePage {

    protected static WebDriver driver;

    public BasePage() {

    }

    public void openChartPage() {
        this.driver = BrowserFactory.create(Constants.BROWSER, Constants.URL);
    }

    public void clickOnElement(String el) {

        try {
            driver.findElement(By.xpath(el)).click();
        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(el)));
        }

    }

    public static WebDriver getDriver() {
        if (driver == null) {
            return BrowserFactory.create(Constants.BROWSER, Constants.URL);
        }
        return driver;
    }

    public void close() {
        driver.close();
    }

    public void quit() {
        driver.quit();
    }


}
