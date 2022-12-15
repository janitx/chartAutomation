package stepdefinitions;

import constants.Constant;
import converter.CollectionToString;
import io.CsvToJavaReader;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import io.cucumber.java.en.When;
import model.TooltipModel;
import org.junit.AfterClass;
import pages.ChartPage;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;


public class DefinitionSteps {

    private static ArrayList<String> tooltips = new ArrayList<>();
    private static List<TooltipModel> csvModels = null;
    private static List<String> csvStrings = null;


    private static ChartPage chartPage = new ChartPage();

    @Given("User reads file")
    public static void readFile() {
        csvModels = CsvToJavaReader.read(Constant.PATH_CSV);
    }

    @When("User opens site")
    public void openPage() {
        chartPage.openChartPage();
    }

    @When("User confirms cookies")
    public void confirmCookies() {
        chartPage.clickOnCookiesWindow();
    }

    @When("User reads tooltips")
    public void readsTooltips() {
        chartPage.turnOffScales();
        chartPage.scrollToUp();
        chartPage.clickOnChartContextMenuButton();
        chartPage.clickOnViewInFullScreenLink();
        chartPage.clickOnDotChart();
    }

    @Then("User checks tooltips")
    public void checksTooltips() {

        for (String str : chartPage.getTextTooltipList()) {
            tooltips.add(str.trim());
        }

        csvStrings = CollectionToString.convert(csvModels);

        Collections.sort(tooltips);
        Collections.sort(csvStrings);


        assertThat(tooltips.get(0)).as("April 1,2011,Erik joined,3 is not equal").isEqualTo(csvStrings.get(0));
        assertThat(tooltips.get(1)).as("August 1,2011,Gert joined,4 is not equal").isEqualTo(csvStrings.get(1));
        assertThat(tooltips.get(2)).as("August 15,2011,Hilde joined,5 is not equal").isEqualTo(csvStrings.get(2));
        assertThat(tooltips.get(3)).as("June 1,2012,Guro joined,6 is not equal").isEqualTo(csvStrings.get(3));
        assertThat(tooltips.get(4)).as("September 1,2012,Erik left,5 is not equal").isEqualTo(csvStrings.get(4));
        assertThat(tooltips.get(5)).as("September 15,2012,Anne Jorunn joined,6 is not equal").isEqualTo(csvStrings.get(5));
        assertThat(tooltips.get(6)).as("January 1,2013,Hilde T. joined,7 is not equal").isEqualTo(csvStrings.get(6));
        assertThat(tooltips.get(7)).as("August 1,2013,Jon Arild joined,8 is not equal").isEqualTo(csvStrings.get(7));
        assertThat(tooltips.get(8)).as("August 20,2013,Øystein joined,9 is not equal").isEqualTo(csvStrings.get(8));
        assertThat(tooltips.get(9)).as("October 1,2013,Stephane joined,10 is not equal").isEqualTo(csvStrings.get(9));
        assertThat(tooltips.get(10)).as("October 1,2014,Anita joined,11 is not equal").isEqualTo(csvStrings.get(10));
        assertThat(tooltips.get(11)).as("November 27,2014,,11 is not equal").isEqualTo(csvStrings.get(11));
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
