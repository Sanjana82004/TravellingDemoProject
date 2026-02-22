package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pageobject.FrontPageS;
import Pageobject.HomePageS;
import Pageobject.LoginPageS;

public class TC_006S_PackagesTest extends BaseClass {
   @Test
   public void verifyPackage() throws InterruptedException {
	   
	   HomePageS hp = new HomePageS(driver);
	   hp.clickLogin();
	
	   LoginPageS lp = new LoginPageS(driver);
	   lp.clickEmail("rolly123@gmail.com");
	   lp.clickPassword("rolly123@");
	   lp.clickLoginBtn();
	  
	   
	   FrontPageS fp = new FrontPageS(driver);
	   fp.clickPackages();
	   
	   String actualUrl = driver.getCurrentUrl();
	   String expectedUrl = "https://mern-travel-tourism-app.onrender.com/search";
	   Assert.assertEquals(actualUrl,expectedUrl);
   }
}
