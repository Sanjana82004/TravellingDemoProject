package testcases;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Pageobject.HomePageS;
import Pageobject.LoginPageS;
import Pageobject.SignupPageS;

public class TC_003S_signupTest extends BaseClass{
	@Test
	public void signup() throws InterruptedException {
		
		
		HomePageS hp = new HomePageS(driver);
		   hp.clickLogin();
		   
		   LoginPageS lp = new LoginPageS(driver);
		   lp.clickSignup();
		
		SignupPageS sp = new SignupPageS(driver);
		
		sp.clickUsername("rolly");
		sp.clickEmail("rolly123@gmail.com");
		sp.clickPassword("rolly123@");
		sp.clickAddress("indrapuri");
		sp.clickPhone("7643589353");
		sp.clickSignup();
		//Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		/*lp.clickEmail("rolly123@gmail.com");
		lp.clickPassword("rolly123@");
		lp.clickLoginBtn();*/
		
	}


}
