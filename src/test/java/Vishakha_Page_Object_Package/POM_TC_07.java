package Vishakha_Page_Object_Package;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class POM_TC_07 extends Base_Page {

	public POM_TC_07(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//a[normalize-space()='Packages']")
	WebElement packageLink;
	
	@FindBy(xpath="//select[@id='sort_order']")
	WebElement sortOrderDropdown;
	
	@FindBy(xpath="//button[@class='bg-slate-700 rounded-lg text-white p-3 uppercase hover:opacity-95']")
	WebElement searchButton;
	
	
	@FindBy(xpath="//a[@class=\"w-full\"]//p[@class=\"font-medium text-green-700\"]")
	List<WebElement> priceElements;
	
	
	public void clickPackageLink() {
		packageLink.click();
	}
	
	public void selectDropDown() {
		Select sc= new Select(sortOrderDropdown);
		sc.selectByVisibleText("Price low to high");
	}
	
	public void clickSearchButton() {
		searchButton.click();
	}
	public List<Double> getPrice(){
		List<Double> prices=new ArrayList<>();
		for(WebElement a:priceElements){
			String text=a.getText().replace("$","").trim();
			prices.add(Double.parseDouble(text));	
		}
		return prices;
	}
	
	
	
	

}
