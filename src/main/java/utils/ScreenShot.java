package utils;

import constants.Constants;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class ScreenShot {

    public static void captureScreenshot(WebDriver driver, String fileName) {
        Date d = new Date();

        String date = d.toString().replace(":", "_").replace(" ", "_");

        try {
            new File(Constants.PATH_SCREENSHOT).mkdirs();
            try (FileOutputStream out = new FileOutputStream(Constants.PATH_SCREENSHOT + File.separator + "screenshot_" + fileName + "-" + date + ".png")) {
                out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            }
        } catch (IOException | WebDriverException e) {
            System.out.println("Screenshot failed:" + e.getMessage());
        }
    }
}
