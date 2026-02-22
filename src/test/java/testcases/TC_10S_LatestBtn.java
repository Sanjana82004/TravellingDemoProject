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

public class TC_10S_LatestBtn extends BaseClass {

	@Test
	public void verifyLatest() {
		
		
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
		fp.clickLatest();
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlContains("https://mern-travel-tourism-app.onrender.com/search?sort=createdAt"));
		String currentUrl =driver.getCurrentUrl();
		String expectedUrl = "https://mern-travel-tourism-app.onrender.com/search?sort=createdAt";
		Assert.assertEquals(currentUrl, expectedUrl);
	}
	
}
