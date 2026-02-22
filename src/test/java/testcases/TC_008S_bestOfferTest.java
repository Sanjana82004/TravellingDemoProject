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

public class TC_008S_bestOfferTest extends BaseClass{
  
	@Test
	public void verifyBestOffer() throws InterruptedException {
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
		fp.clickBestOffer();
		//Thread.sleep(5000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.urlContains("https://mern-travel-tourism-app.onrender.com/search?offer=true"));
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = "https://mern-travel-tourism-app.onrender.com/search?offer=true";
		Assert.assertEquals(currentUrl, expectedUrl);
	}
}
