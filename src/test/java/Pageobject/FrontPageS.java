package Pageobject;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FrontPageS extends basePage{

	public FrontPageS(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	@FindBy(xpath = "//a[normalize-space()='Home']") WebElement homeLink;
	
	@FindBy(xpath = "//a[normalize-space()='Packages']") WebElement packagesLink;
	@FindBy(xpath ="//a[normalize-space()='About']" )   WebElement aboutLink;
	@FindBy(xpath = "//img[@alt='rolly']")  WebElement profile;
	
	@FindBy(xpath = "//span[@class='shadow-xl rounded-lg text-slate-700 text-2xl absolute left-1 top-")  WebElement logo;
	@FindBy(xpath = "//input[@placeholder='Search']") WebElement searchButton;
	@FindBy(xpath = "//button[normalize-space()='Go']") WebElement goButton;
	
	@FindBy(xpath = "//button[contains(@class,'flex items-center justify-around gap-x-1 bg-slate-400 text-white p-2 py-1 text-[8px] xxsm:text-sm sm:text-lg border-e border-white rounded-s-full flex-1 hover:scale-105 transition-all duration-150')]") WebElement bestOffers;
	@FindBy(xpath = "//button[normalize-space()='Top Rated']")  WebElement topRatedButton;
	@FindBy(xpath = "//button[normalize-space()='Latest']")   WebElement latestButton;
	@FindBy(xpath = "//button[contains(@class,'flex items-center justify-around gap-x-1 bg-slate-400 text-white p-2 py-1 text-[8px] xxsm:text-sm sm:text-lg border-s border-white rounded-e-full flex-1 hover:scale-105 transition-all duration-150')]") WebElement mostRated;
	public boolean isClickHomeDisplayed() {
		return homeLink.isDisplayed();
	}
	
	public void clickPackages() {
		packagesLink.click();
	}
	 
	public void clickAbout() {
		aboutLink.click();
	}
	public boolean isLogoDisplayed() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		 boolean logoDisplayed = wait.until(ExpectedConditions.visibilityOf(logo)).isDisplayed();
		 return logoDisplayed;
		
	}
	
	public boolean isClickSearchDisplayed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		boolean searchDisplayed = wait.until(ExpectedConditions.visibilityOf(searchButton)).isDisplayed();
      
	    return searchDisplayed;
	}
	
	public boolean isClickGoDisplayed() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		boolean goDisplayed = wait.until(ExpectedConditions.visibilityOf(goButton)).isDisplayed();

	    return goDisplayed;
	}
	public void clickBestOffer() {
		
		bestOffers.click();
	}
	
	public void clicktopRated() {
		topRatedButton.click();
	}
  
	
	public void clickLatest() {
		latestButton.click();
	}
	public void clickMostRated() {
		mostRated.click();
	}
}
