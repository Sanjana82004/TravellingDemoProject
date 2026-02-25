package Pageobject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageS extends basePage{

	public HomePageS(WebDriver driver) {
		super(driver);
		
	}
   
	@FindBy(xpath = "//a[normalize-space()='Home']") WebElement homeLink;
	@FindBy(xpath ="//a[normalize-space()='Packages']") WebElement packagesLink;
	@FindBy(xpath = "//a[normalize-space()='About']") WebElement aboutLink;
	@FindBy(xpath = "//a[normalize-space()='Login']") WebElement loginLink;
	
	public void clickHome() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(homeLink));
	    homeLink.click();
	   
		
	}
	public void clickPackages() {
		packagesLink.click();
	}
	public void clickAbout() {
		aboutLink.click();
	}
	public void clickLogin() {
		loginLink.click();
	}
	
	public boolean isHomeLinkDisplayed() {
		return homeLink.isDisplayed();
	}
	public boolean isPackageDisplayed() {
		return packagesLink.isDisplayed();
	}
	
	public boolean isAboutDisplayed() {
		return aboutLink.isDisplayed();
	}
	
	public boolean isLoginDisplayed() {
		return loginLink.isDisplayed();
	}
}
