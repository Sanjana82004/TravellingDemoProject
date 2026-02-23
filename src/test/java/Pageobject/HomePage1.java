package Pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage1 {

    WebDriver driver;

    public HomePage1(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Header Links
    @FindBy(linkText = "Login")
    WebElement loginLink;

    @FindBy(linkText = "Packages")
    WebElement packagesLink;

    @FindBy(linkText = "Home")
    WebElement homeLink;

    @FindBy(linkText = "About")
    WebElement aboutLink;

    // Methods
    public void clickLogin() {
        loginLink.click();
    }

    public void clickPackages() {
        packagesLink.click();
    }

    public void clickHome() {
        homeLink.click();
    }

    public void clickAbout() {
        aboutLink.click();
    }

    // Booking ke liye kisi specific tour par click karna ho
    public void selectTourByName(String tourName) {
        driver.findElement(By.xpath("//h5[contains(text(),'" + tourName + "')]")).click();
    }
}