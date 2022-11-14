package manager;

import constants.DriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver;

public class BrowserFactory {
    public static WebDriver create(DriverType type, String url) {

        WebDriver driver = null;

        switch (type) {

            case CHROME:
                chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.get(url);
                return driver;

            case FIREFOX:
                firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                driver.get(url);
                return driver;
        }
        return driver;
    }

    private BrowserFactory() {
    }
}
