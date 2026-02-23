package Pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage1 {

    WebDriver driver;

    // Constructor
    public PaymentPage1(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // WebElement
    @FindBy(xpath = "//button[contains(text(),'Pay Now')]")
    WebElement payBtn;

    // Action Method
    public void clickPayBtn() {
        payBtn.click();
    }
}