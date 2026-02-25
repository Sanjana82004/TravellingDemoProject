package testcases;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Pageobject.FrontPageS;
import Pageobject.HomePageS;
import Pageobject.LoginPageS;
import junit.framework.Assert;

public class TC_11S_MostRated extends BaseClass{
 
	@Test
	public void verifyMostRated() {
		
		
		HomePageS hp = new HomePageS(driver);
		   hp.clickLogin();
		
		   LoginPageS lp = new LoginPageS(driver);
		   lp.clickEmail("rolly123@gmail.com");
		   lp.clickPassword("rolly123@");
		   lp.clickLoginBtn();
		   
		   try {
			    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

			    Alert alert = wait.until(ExpectedConditions.alertIsPresent());

			    System.out.println("Alert Text: " + alert.getText());

			    alert.accept();  // Close alert

			} catch (Exception e) {
			    System.out.println("No Alert Present");
			} 
		
		
		
		
		FrontPageS fp = new FrontPageS(driver);
		fp.clickMostRated();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlContains("https://mern-travel-tourism-app.onrender.com/search?sort=packageTotalRatings"));
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = "https://mern-travel-tourism-app.onrender.com/search?sort=packageTotalRatings";
		Assert.assertEquals(currentUrl, expectedUrl);
	}
}
