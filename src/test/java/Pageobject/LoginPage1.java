package Pageobject;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage1 {

    WebDriver driver;
    WebDriverWait wait;

    // ================= Constructor =================
    public LoginPage1(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    // ================= Locators =================

    @FindBy(linkText = "Signup")
    WebElement signupLink;

    @FindBy(xpath = "//input[@type='email']")
    WebElement emailField;

    @FindBy(xpath = "//input[@type='password']")
    WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    @FindBy(xpath = "//p[contains(@class,'error')]")
    WebElement errorMessage;

    // ================= Actions =================

    public void clickSignup() {
        wait.until(ExpectedConditions.elementToBeClickable(signupLink));
        signupLink.click();
    }

    public void enterEmail(String email) {

        // Ensure page loaded properly
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//input[@type='email']")));

        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {

        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLogin() {

        wait.until(ExpectedConditions.elementToBeClickable(loginButton));

        // Sometimes React apps need JS click
        try {
            loginButton.click();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", loginButton);
        }
    }

    // Clean login method
    public void login(String email, String password) {

        System.out.println("Current URL before login: " + driver.getCurrentUrl());

        enterEmail(email);
        enterPassword(password);
        clickLogin();
    }

    public boolean isErrorDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(errorMessage));
            return errorMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // ================= Alert Handling =================

    public String handleAlertIfPresent() {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            String text = alert.getText();
            alert.accept();
            return text;
        } catch (NoAlertPresentException e) {
            return null;
        }
    }
}