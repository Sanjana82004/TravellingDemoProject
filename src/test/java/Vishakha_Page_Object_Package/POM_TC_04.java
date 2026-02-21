package Vishakha_Page_Object_Package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class POM_TC_04 extends Base_Page {
	
	public POM_TC_04(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath="//span[@class='shadow-xl rounded-lg text-slate-700 text-2xl absolute left-1 top-[-10px] text-center']")
	WebElement logo;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement login;
	
	public int getLogoYPosition() {
	    return logo.getLocation().getY();
	}

	
	public int getHomeLinkYPosition() {
	    
	    return login.getLocation().getY();
	}

}
