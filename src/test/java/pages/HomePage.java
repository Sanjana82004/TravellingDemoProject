package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // HERO Section (More stable locator)
    @FindBy(xpath = "//section[contains(@class,'hero')]")
    WebElement heroSection;

    // Featured Tours Cards
    @FindBy(xpath = "//div[contains(@class,'tour__card')]")
    List<WebElement> featuredTours;

    // Explore Button (Instead of link text use partial match)
    @FindBy(xpath = "//a[contains(@href,'/tours')]")
    WebElement exploreButton;

    public boolean isHeroVisible() {
        return heroSection.isDisplayed();
    }

    public boolean isFeaturedToursVisible() {
        return featuredTours.size() > 0;
    }

    public void clickExplore() {
        exploreButton.click();
    }
}