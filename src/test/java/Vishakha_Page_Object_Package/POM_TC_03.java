package Vishakha_Page_Object_Package;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class POM_TC_03 extends Base_Page {

	public POM_TC_03(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//ul[@class='flex flex-wrap items-center justify-end gap-2 text-white font-semibold list-none']/li")
	List<WebElement> navMenuList;
	
	@FindBy(xpath="//span[@class='shadow-xl rounded-lg text-slate-700 text-2xl absolute left-1 top-[-10px] text-center']")
	WebElement logo;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement login;
	
	public int getLinkCount() {
		return navMenuList.size();
	}
	
	public int getLogoPosition() {
		return logo.getLocation().getX();
	}
	
	public int getLoginPosition() {
		return login.getLocation().getY();
	}

}
