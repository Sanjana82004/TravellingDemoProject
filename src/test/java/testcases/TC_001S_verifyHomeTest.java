package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Pageobject.HomePageS;

public class TC_001S_verifyHomeTest extends BaseClass   {
  
   @Test
   public void verifiedLogin() {
	   HomePageS hp = new HomePageS(driver);
	   hp.clickLogin();
	   System.out.println(hp.isHomeLinkDisplayed());
	   System.out.println(hp.isPackageDisplayed());
	   System.out.println(hp.isAboutDisplayed());
	   System.out.println(hp.isLoginDisplayed());
   }
}
