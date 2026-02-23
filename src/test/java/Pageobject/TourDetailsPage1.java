package Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TourDetailsPage1 {
     WebDriver driver;
     
     @FindBy(xpath="//button[contains(text(),'Book Now')]")
     WebElement bookNowBtn;
     
     public TourDetailsPage1(WebDriver driver) {
    	 this.driver=driver;
    	 PageFactory.initElements( driver,this);
     }
     
     public void clickBookNow() {
    	 bookNowBtn.click();
     }
     public void openFirstTour() {
         driver.findElement(By.xpath("(//a[contains(text(),'View Details')])[1]")).click();
     }

	
     
     
     
}
