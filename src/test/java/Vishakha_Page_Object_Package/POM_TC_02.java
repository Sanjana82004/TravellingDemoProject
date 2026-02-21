package Vishakha_Page_Object_Package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class POM_TC_02 extends Base_Page {

	public POM_TC_02(WebDriver driver) {
		super(driver);
	}
	

	@FindBy(xpath="//a[normalize-space()='Packages']")
	WebElement packagesNavLink;
	
	@FindBy(xpath="//h1[@class='text-xl font-semibold border-b p-3 text-slate-700 mt-5']")
	WebElement resultsPageHeader;
	
	public void goToPackagesPage() {
	    packagesNavLink.click();
	}

	public String getResultsPageHeaderText() {
	    return resultsPageHeader.getText();
	}
	
	
	

}
