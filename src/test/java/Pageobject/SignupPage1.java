package Pageobject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage1 {

    WebDriver driver;

    @FindBy(id = "username")
    WebElement usernameField;

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "address")
    WebElement addressField;

    @FindBy(id = "phone")
    WebElement phoneField;

    @FindBy(xpath = "//*[@id='root']/div[2]/form/div/button")
    WebElement signupButton;

    

    public SignupPage1(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUser(String username) {
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void enterEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void enterAddress(String address) {
        addressField.clear();
        addressField.sendKeys(address);
    }

    public void enterPhone(String phone) {
        phoneField.clear();
        phoneField.sendKeys(phone);
    }

    public void clickSignup() {
        signupButton.click();
    }

    public boolean isErrorDisplayed() {
        return driver.findElements(By.xpath("//p[contains(@class,'error')]")).size() > 0;
    }
    public String handleAlertIfPresent() {
        try {
            Alert alert = driver.switchTo().alert();
            String text = alert.getText();
            alert.accept();
            return text;
        } catch (Exception e) {
            return null;
        }
    }
}