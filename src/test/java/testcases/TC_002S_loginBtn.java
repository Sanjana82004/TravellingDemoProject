package testcases;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Pageobject.HomePageS;
import Pageobject.LoginPageS;

public class TC_002S_loginBtn extends BaseClass {
   @Test
   public void verifyLogin() throws InterruptedException {
	   
	   HomePageS hp = new HomePageS(driver) ;
	   hp.clickLogin();
	   
	   
	   LoginPageS lp = new LoginPageS(driver);
	   lp.clickEmail("rolly123@gmail.com");
	   lp.clickPassword("rolly123@");
	   lp.clickLoginBtn();
	   
	   Thread.sleep(2000);
	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
   }
}
