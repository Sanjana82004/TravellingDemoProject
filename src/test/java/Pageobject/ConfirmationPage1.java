package Pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage1 {
    WebDriver driver;
    
    public ConfirmationPage1(WebDriver driver) {
    	this.driver=driver;
    	PageFactory.initElements( driver,this);
    }
    
    @FindBy(xpath="//h2[contains(text(),'Booking Confirmed')]")
    WebElement successMsg;
    
    
    public boolean isBookingConfirmed() {
    	return successMsg.isDisplayed();
    }
}
