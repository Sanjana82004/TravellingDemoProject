package utilities;

import java.io.File;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver driver, String testName) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            String path = "test-output/screenshots/" + testName + ".png";
            FileHandler.copy(src, new File(path));
            return path;
        } catch (Exception e) {
            return null;
        }
    }
}