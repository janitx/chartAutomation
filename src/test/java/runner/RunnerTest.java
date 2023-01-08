package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:report.html", "attributes.CustomAttributeReporter", "listener.CheckTooltipsListener"},
        features = "src/test/resources/chart.feature",
        glue = "stepdefinitions"
)
public class RunnerTest {

}
