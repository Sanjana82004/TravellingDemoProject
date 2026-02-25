package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class SearchPage {

    WebDriver driver;

    @FindBy(name = "search")
    WebElement searchBox;

    @FindBy(xpath = "//button[contains(text(),'Search')]")
    WebElement searchBtn;

    @FindBy(className = "tour__card")
    WebElement firstTour;

    @FindBy(xpath = "//a[contains(text(),'Next')]")
    WebElement nextBtn;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchTour(String city) {
        searchBox.clear();
        searchBox.sendKeys(city);
        searchBtn.click();
    }

    public boolean isResultDisplayed() {
        return firstTour.isDisplayed();
    }

    public void clickNextPage() {
        nextBtn.click();
    }
}