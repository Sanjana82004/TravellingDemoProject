package testcases;

import org.testng.annotations.Test;

import Pageobject.FrontPageS;
import Pageobject.HomePageS;
import Pageobject.LoginPageS;
import junit.framework.Assert;

public class TC_005S_homeLinkTest extends BaseClass{
   
	@Test
	public void verifyHome() {
		HomePageS hp = new HomePageS(driver);
		   hp.clickLogin();
		
		   LoginPageS lp = new LoginPageS(driver);
		   lp.clickEmail("rolly123@gmail.com");
		   lp.clickPassword("rolly123@");
		   lp.clickLoginBtn();
		
		
		FrontPageS fp = new FrontPageS(driver);
		
		Assert.assertTrue("home link is not displayed after login",fp.isClickHomeDisplayed());
	}
}
