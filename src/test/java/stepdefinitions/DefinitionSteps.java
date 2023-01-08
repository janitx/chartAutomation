package stepdefinitions;

import constants.Constants;
import converter.CollectionToString;
import io.CsvToJavaReader;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import io.cucumber.java.en.When;
import model.TooltipModel;
import org.assertj.core.api.SoftAssertions;
import org.junit.AfterClass;
import pages.ChartPage;

import java.util.*;

public class DefinitionSteps {

    private static ArrayList<String> tooltips = new ArrayList<>();
    private static List<TooltipModel> csvModels = null;
    private static List<String> csvStrings = null;


    private static ChartPage chartPage = new ChartPage();

    @Given("User opens site")
    public void openPage() {
        chartPage.openChartPage();
    }

    @When("User confirms cookies")
    public void confirmCookies() {
        chartPage.clickOnCookiesWindow();
    }

    @Then("User checks tooltips")
    public void checksTooltips() {

        csvModels = CsvToJavaReader.read(Constants.PATH_CSV);
        chartPage.turnOffScales();
        chartPage.scrollToUp();
        chartPage.clickOnChartContextMenuButton();
        chartPage.clickOnViewInFullScreenLink();
        chartPage.clickOnDotChart();

        for (String str : chartPage.getTextTooltipList()) {
            tooltips.add(str.trim());
        }

        csvStrings = CollectionToString.convert(csvModels);

        Collections.sort(tooltips);
        Collections.sort(csvStrings);


        SoftAssertions softAssertions = new SoftAssertions();

        for (int i = 0; i < csvStrings.size() - 1; i++) {
            softAssertions.assertThat(tooltips.get(i)).as("Tooltips are not equal").isEqualTo(csvStrings.get(i));
        }

    }

    @After
    public void closeBrowser() {
        chartPage.close();
    }

    @AfterClass
    public static void closeDriver() {
        chartPage.quit();
    }
}
