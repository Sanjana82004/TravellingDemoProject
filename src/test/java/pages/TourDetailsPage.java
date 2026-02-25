package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class TourDetailsPage {

    WebDriver driver;

    @FindBy(className = "tour__card")
    WebElement firstTour;

    @FindBy(xpath = "//button[contains(text(),'Book Now')]")
    WebElement bookNowBtn;

    public TourDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openFirstTour() {
        firstTour.click();
    }

    public void clickBookNow() {
        bookNowBtn.click();
    }
}