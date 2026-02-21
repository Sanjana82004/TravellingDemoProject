package Vishakha_Page_Object_Package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class POM_TC_05 extends Base_Page {

	public POM_TC_05(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//a[normalize-space()='Home']")
    WebElement home;
	
	@FindBy(xpath = "//input[@placeholder='Search']")
    WebElement searchBox;

    @FindBy(xpath = "//button[@class='bg-white w-10 h-10 flex justify-center items-center text-xl font-semibold rounded-full hover:scale-95']")
    WebElement goButton;

    @FindBy(xpath = "//p[@class='text-green-700 text-lg capitalize']")
    WebElement CardPlace;
    
    public void clickHomeLink() {
    	home.click();
    }
    
    public void enterSearchKeyword(String city) {
        searchBox.clear();
        searchBox.sendKeys(city);
    }

    public void clickGo() {
        goButton.click();
    }

    public String getFirstResultTitle() {
        return CardPlace.getText();
    }

}
