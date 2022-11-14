package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import manager.PageFactoryManager;
import org.junit.AfterClass;
import pages.ChartPage;

public class DefinitionSteps {

    ChartPage chartPage;
    PageFactoryManager pageFactoryManager;

    @Given("User opens {string}")
    public void openPage(String url) {
        pageFactoryManager = new PageFactoryManager(url);
        chartPage = pageFactoryManager.getChartPage();

        chartPage.clickOnAllowAllCookiesButton();

    }

    @After
    public void closeBrowser() {
        chartPage.close();
    }

    @AfterClass
    public void closeDriver() {
        chartPage.quit();
    }
}
