package Pageobject;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

public class SearchPage1 {

    WebDriver driver;
    WebDriverWait wait;

    public SearchPage1(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//input[@type='checkbox']")
    WebElement offerCheckbox;

    @FindBy(xpath="//select")
    WebElement sortDropdown;

    @FindBy(xpath="//button[contains(text(),'SEARCH')]")
    WebElement searchButton;

    @FindBy(xpath="(//a[contains(text(),'View Details')])[1]")
    WebElement firstPackage;

    public void selectOffer() {
        wait.until(ExpectedConditions.elementToBeClickable(offerCheckbox));
        offerCheckbox.click();
    }

    public void selectPriceHighToLow() {
        Select select = new Select(sortDropdown);
        select.selectByVisibleText("Price high to low");
    }

    public void clickSearch() {
        searchButton.click();
    }

    public void openFirstPackage() {
        wait.until(ExpectedConditions.elementToBeClickable(firstPackage));
        firstPackage.click();
    }
}