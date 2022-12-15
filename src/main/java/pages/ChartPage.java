package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ChartPage extends BasePage {
    private static final String SHOW_REVENUE = "//button[contains(@aria-label,'Show Revenue')]";
    private static final String GOOGLE_SEARCH_FOR_HIGHCHARTS = "//button[contains(@aria-label,'Show Google search for highcharts')]";
    private static final String ALLOW_ALL_COOKIES_BUTTON = "//a[@id='CybotCookiebotDialogBodyButtonAccept']";
    public static final String HIGHSOFT_EMPLOYEES_DOT = "path.highcharts-point.highcharts-color-2";
    private static final String TOOLTIP_TEXT = "g.highcharts-label.highcharts-tooltip.highcharts-color-2 text";

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
        toolTipsList = driver.findElements(By.cssSelector(HIGHSOFT_EMPLOYEES_DOT));

        Set<WebElement> setCollection = new LinkedHashSet<>(toolTipsList);

        actions = new Actions(driver);

        for (WebElement element : setCollection) {
            actions.moveToElement(element).perform();


            try {
                String text = driver.findElement(By.cssSelector(TOOLTIP_TEXT)).getText().trim();
                textTooltipList.add(text);

            } catch (Exception e) {

                System.out.println(e.getMessage());
            }

        }

    }

}
