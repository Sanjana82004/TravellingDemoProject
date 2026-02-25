package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class ContactPage {

    WebDriver driver;

    @FindBy(name = "name")
    WebElement name;

    @FindBy(name = "email")
    WebElement email;

    @FindBy(name = "message")
    WebElement message;

    @FindBy(xpath = "//button[contains(text(),'Send')]")
    WebElement sendBtn;

    public ContactPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void submitEmptyForm() {
        sendBtn.click();
    }

    public void submitValidForm() {
        name.sendKeys("Test User");
        email.sendKeys("annu12@gmail.com");
        message.sendKeys("Test message");
        sendBtn.click();
    }
}