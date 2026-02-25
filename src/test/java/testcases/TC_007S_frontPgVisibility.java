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

public class TC_007S_frontPgVisibility extends BaseClass{
  @Test
  public void verifyElement() {
	  
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
	// Assert.assertTrue("logo not displayed", fp.isLogoDisplayed());
	  Assert.assertTrue("go button not displayed", fp.isClickGoDisplayed());
	  Assert.assertTrue("search field not displayed", fp.isClickSearchDisplayed());
  }
}
