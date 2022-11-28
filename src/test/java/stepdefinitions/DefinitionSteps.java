package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import org.junit.AfterClass;
import org.openqa.selenium.WebElement;
import pages.ChartPage;

public class DefinitionSteps {
    ChartPage chartPage = new ChartPage();

    @Given("User opens site")
    public void openPage() {
        chartPage.clickOnCookiesWindow();
    }

    @Then("User checks tooltips")
    public void checkTooltips() {
        chartPage.turnOffScales();
        chartPage.clickOnDotChart();
    }

    @After
    public void closeBrowser() {
        // Debug
        for (String element : chartPage.getTextTooltipList())
            System.out.println(element);
        System.out.println("SIZE = " + chartPage.getTextTooltipList().size());

        chartPage.close();
    }

    @AfterClass
    public void closeDriver() {
        chartPage.quit();
    }
}
