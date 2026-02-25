package Pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignupPageS extends basePage{

	public SignupPageS(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath = "//input[@id='username']")  WebElement username;
	@FindBy(xpath = "//input[@id='email']")  WebElement Email;
	@FindBy(xpath = "//input[@id='password']") WebElement password;
	@FindBy(xpath = "//textarea[@id='address']")  WebElement address;
	@FindBy(xpath = "//input[@id='phone']")  WebElement phone;
	@FindBy(xpath = "//button[@class='p-3 text-white bg-slate-700 rounded hover:opacity-95']") WebElement signup;
	
	public void clickUsername(String user) {
		username.sendKeys(user);
	}
	
	public void clickEmail(String eml) {
		Email.sendKeys(eml);
	}
	public void clickPassword(String pwd) {
		password.sendKeys(pwd);
	}
   public void clickAddress(String add) {
	   address.sendKeys(add);
   }
   
   public void clickPhone(String num) {
	   phone.sendKeys(num);
   }
   
   public void clickSignup() {
	   signup.click();
   }

}
