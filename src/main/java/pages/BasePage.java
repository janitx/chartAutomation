package pages;

import constants.Constant;
import manager.BrowserFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected static WebDriver driver;

    public BasePage() {
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

    public void waitForElement(String element) {
        new WebDriverWait(driver, 3).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(element)));
    }

    public void close() {
        driver.close();
    }

    public void quit() {
        driver.quit();
    }


}
