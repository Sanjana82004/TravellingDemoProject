package Pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class bestOfferPageS extends basePage {

	public bestOfferPageS(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//input[@id='searchTerm']") WebElement searchBox;
	@FindBy(xpath = "//input[@id='offer']")  WebElement offer;
	@FindBy(xpath = "//select[@id='sort_order']") WebElement sortSelection;
	
	@FindBy(xpath = "//button[@class='bg-slate-700 rounded-lg text-white p-3 uppercase hover:opacity-95']") WebElement searchButton;
	@FindBy(xpath = "//p[@class='text-xl text-slate-700']")  WebElement noPackageMessage;
	@FindBy(xpath = "//img[@alt='Package Image']") WebElement firstImg;
	
	public void enterSearchBox(String value) {
		searchBox.sendKeys(value);	
		}
	public void clickOffer() {
		offer.click();
	}
	
  public void clickSortSelection(String value) {
	  Select s = new Select(sortSelection);
	  s.selectByVisibleText(value);
  }
  public void clickSearchButton() {
	  searchButton.click();
  }
  
  public String getNoPackageMessage() {
	  return noPackageMessage.getText();
  }
  
  public void clickFirstPage() {
	  firstImg.click();
  }
  
}
