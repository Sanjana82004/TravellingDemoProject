package Pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingPage1 {
	WebDriver driver;

	public BookingPage1(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Locators

	@FindBy(name = "name")
	WebElement nameField;

	@FindBy(name = "phone")
	WebElement phoneField;

	@FindBy(name = "persons")
	WebElement personsField;

	@FindBy(xpath = "//button[contains(text(),'Confirm Booking')]")
	WebElement confirmBookingButton;

	// Actions

	public void enterName(String uname) {
		nameField.clear();
		nameField.sendKeys(uname);
	}
	
	public void enterPhone(String phone) {
		nameField.clear();
		nameField.sendKeys(phone);
	}

	

	public void enterPersons(String persons) {
		personsField.clear();
		personsField.sendKeys(persons);
	}

	public void clickConfirmBooking() {
		confirmBookingButton.click();
	}
}
