package Vishakha_Page_Object_Package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class POM_TC_01 extends Base_Page{
	
	public POM_TC_01(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath = "//span[@class='shadow-xl rounded-lg text-slate-700 text-2xl absolute left-1 top-[-10px] text-center']")
    private WebElement logoElement;

  
    public boolean isLogoDisplayed() {
        try {
            return logoElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

 
    public String getLogoText() {
        return logoElement.getText();
    }

    
    public String getPageTitle() {
        return driver.getTitle();
    }
	

}
