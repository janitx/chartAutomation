package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import io.cucumber.java.en.When;
import org.junit.AfterClass;
import pages.ChartPage;

public class DefinitionSteps {
    ChartPage chartPage = new ChartPage();

    @Given("User opens site")
    public void openPage() {
        chartPage.openChartPage();
    }

    @When("User confirms cookies")
    public void confirmCookies() {
        chartPage.clickOnCookiesWindow();
    }

    @Then("User checks tooltips")
    public void checkTooltips() {
        chartPage.turnOffScales();
        chartPage.scrollToUp();
        chartPage.clickOnChartContextMenuButton();
        chartPage.clickOnViewInFullScreenLink();
        chartPage.clickOnDotChart();
    }

    @After
    public void closeBrowser() {
        chartPage.close();

        // Debug
        for (String element : chartPage.getTextTooltipList())
            System.out.println(element);
        System.out.println("SIZE = " + chartPage.getTextTooltipList().size());

    }

    @AfterClass
    public void closeDriver() {
        chartPage.quit();
    }
}
