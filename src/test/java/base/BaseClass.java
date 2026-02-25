package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Properties prop;

    @BeforeMethod
    public void setup() throws IOException {

        prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
        prop.load(fis);

        System.setProperty("webdriver.chrome.driver",
                "C:\\Drivers\\chromedriver.exe");   // <- apna path yaha daalo

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get(prop.getProperty("baseUrl"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}