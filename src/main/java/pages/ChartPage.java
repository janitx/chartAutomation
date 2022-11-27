package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class ChartPage extends BasePage {
    private static final String SHOW_REVENUE = "//button[contains(@aria-label,'Show Revenue')]";

    private static final String GOOGLE_SEARCH_FOR_HIGHCHARTS = "//button[contains(@aria-label,'Show Google search for highcharts')]";
    private static final String ALLOW_ALL_COOKIES_BUTTON = "//a[@id='CybotCookiebotDialogBodyButtonAccept']";

    public static final String HIGHSOFT_EMPLOYEES_DOT = "//*[local-name()='svg']//*[name()='g' and @class='highcharts-markers highcharts-series-2 highcharts-area-series highcharts-color-2 highcharts-tracker']//*[name()='path']";
    private static final String TOOLTIP_TEXT = "//*[local-name()='svg']//*[name()='g' and @class='highcharts-label highcharts-tooltip highcharts-color-undefined highcharts-color-2']//*[name()='text']";

    private static final String CHART_CONTEXT_MENU_BUTTON = "//button[contains(@aria-label,'View chart menu, Highcharts and Highsoft timeline')]";

    private static final String VIEW_IN_FULL_SCREEN_LINK = "//*[text()=\"View in full screen\"]";
    private List<WebElement> toolTipsList = new ArrayList<>();

    private List<String> textTooltipList = new ArrayList<>();

    public List<String> getTextTooltipList() {
        return textTooltipList;
    }

    private Actions actions;

    public ChartPage() {
        super();
    }

    public void turnOffScales() {
        clickOnElement(GOOGLE_SEARCH_FOR_HIGHCHARTS);
        clickOnElement(SHOW_REVENUE);
    }


    public void clickOnCookiesWindow() {
        clickOnElement(ALLOW_ALL_COOKIES_BUTTON);
    }


    public void clickOnChartContextMenuButton() {
        clickOnElement(CHART_CONTEXT_MENU_BUTTON);
    }

    public void clickOnViewInFullScreenLink() {
        driver.findElement(By.xpath(VIEW_IN_FULL_SCREEN_LINK)).click();
    }

    public void scrollToUp() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,-250)");
    }

    public void clickOnDotChart() {
        toolTipsList = driver.findElements(By.xpath(HIGHSOFT_EMPLOYEES_DOT));
        actions = new Actions(driver);

        for (WebElement element : toolTipsList) {
            actions.moveToElement(element).perform();

            try {
                String text = driver.findElement(By.xpath(TOOLTIP_TEXT)).getText();
                textTooltipList.add(text);

            } catch (Exception e) {

                clickInLoop(element);

            }

        }
    }

    /**
     * The function is called if the element is not stable
     *
     * @param element - unstable element
     */
    private void clickInLoop(WebElement element) {

        int index = 0;

        while (index < 5) {
            actions.moveToElement(element).perform();
            try {
                String text = driver.findElement(By.xpath(TOOLTIP_TEXT)).getText();
                textTooltipList.add(text);
                break;

            } catch (Exception e) {

                System.err.format(e.getMessage());
            }

            index++;

            waitForElement(TOOLTIP_TEXT);

        }
    }


}
