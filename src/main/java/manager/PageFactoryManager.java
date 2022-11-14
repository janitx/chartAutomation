package manager;

import constants.Constant;
import org.openqa.selenium.WebDriver;
import pages.ChartPage;


public class PageFactoryManager {
    WebDriver driver;

    public PageFactoryManager(String url) {
        driver = BrowserFactory.create(Constant.BROWSER, url);

    }

    public ChartPage getChartPage() {
        return new ChartPage(driver);

    }

}
