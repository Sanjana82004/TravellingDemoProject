package Pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageS  extends basePage{

	public LoginPageS(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath = "//input[@id='email']") WebElement Email;
	@FindBy(xpath = "//input[@id='password']") WebElement Password;
	@FindBy(xpath = "//button[@class='p-3 text-white bg-slate-700 rounded hover:opacity-95']") WebElement loginBtn;
	@FindBy(xpath = "//a[normalize-space()='Dont have an account? Signup']") WebElement signupBtn;
	
	public void clickEmail(String s) {
		Email.sendKeys(s);
	}
  
	
	public void clickPassword(String pwd) {
		Password.sendKeys(pwd);
	}
	
	public void clickLoginBtn() {
		loginBtn.click();
	}
	
	public void clickSignup() {
		signupBtn.click();
	}
}
