package Vishakha_Test_Pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Base_Test {

	
	public WebDriver driver;
    @BeforeClass
    public void setup() {
    	driver = new ChromeDriver();
    	driver.get("https://mern-travel-tourism-app.onrender.com/search");
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	
    }
    @AfterClass
    public void teardown() {
    	driver.quit();
    }
    
    
    
}
