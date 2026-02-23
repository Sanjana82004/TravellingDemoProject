package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pageobject.BookingPage1;
import Pageobject.ConfirmationPage1;
import Pageobject.HomePage1;
import Pageobject.LoginPage1;
import Pageobject.PaymentPage1;
import Pageobject.TourDetailsPage1;
import base.BaseClass1;

public class BookingTest1 extends BaseClass1 {

    LoginPage1 login;

    @BeforeMethod
    public void loginBeforeTest() {

        // Login page pe jao
        driver.get(prop.getProperty("baseUrl") + "/login");

        // Login object banao
        LoginPage1 login = new LoginPage1(driver);

        // Login karo
        login.login("annu12@gmail.com", "annu@12");
    }

    // Navigate to first tour
    public void navigateToTour() {

        driver.get(prop.getProperty("baseUrl") + "/packages");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//a[contains(text(),'View Details')])[1]")))
                .click();
    }

    // Common booking method
    public void performBooking(String name, String phone, String persons) {

        navigateToTour();

        TourDetailsPage1 tour = new TourDetailsPage1(driver);
        tour.clickBookNow();

        BookingPage1 booking = new BookingPage1(driver);
        booking.enterName(name);
        booking.enterPhone(phone);
        booking.enterPersons(persons);
        booking.clickConfirmBooking();

        PaymentPage1 payment = new PaymentPage1(driver);
        payment.clickPayBtn();
    }

    // ===============================
    // Positive Test Cases
    // ===============================

    @Test
    public void TC01_Pos_ValidBooking() {
        performBooking("Annu", "9876543210", "2");

        ConfirmationPage1 confirm = new ConfirmationPage1(driver);
        Assert.assertTrue(confirm.isBookingConfirmed());
    }

    @Test
    public void TC02_Pos_MultiplePersons() {
        performBooking("Annu", "9876543210", "5");

        ConfirmationPage1 confirm = new ConfirmationPage1(driver);
        Assert.assertTrue(confirm.isBookingConfirmed());
    }

    @Test
    public void TC03_Pos_MinimumPersons() {
        performBooking("Annu", "9876543210", "1");

        ConfirmationPage1 confirm = new ConfirmationPage1(driver);
        Assert.assertTrue(confirm.isBookingConfirmed());
    }

    // ===============================
    // Negative Test Cases
    // ===============================

    @Test
    public void TC04_Neg_EmptyName() {
        performBooking("", "9876543210", "2");

        ConfirmationPage1 confirm = new ConfirmationPage1(driver);
        Assert.assertFalse(confirm.isBookingConfirmed());
    }

    @Test
    public void TC05_Neg_InvalidPhone() {
        performBooking("Annu", "123", "2");

        ConfirmationPage1 confirm = new ConfirmationPage1(driver);
        Assert.assertFalse(confirm.isBookingConfirmed());
    }

    @Test
    public void TC06_Neg_EmptyPhone() {
        performBooking("Annu", "", "2");

        ConfirmationPage1 confirm = new ConfirmationPage1(driver);
        Assert.assertFalse(confirm.isBookingConfirmed());
    }

    @Test
    public void TC07_Neg_ZeroPersons() {
        performBooking("Annu", "9876543210", "0");

        ConfirmationPage1 confirm = new ConfirmationPage1(driver);
        Assert.assertFalse(confirm.isBookingConfirmed());
    }

    @Test
    public void TC08_Neg_EmptyPersons() {
        performBooking("Annu", "9876543210", "");

        ConfirmationPage1 confirm = new ConfirmationPage1(driver);
        Assert.assertFalse(confirm.isBookingConfirmed());
    }

    @Test
    public void TC09_Neg_NegativePersons() {
        performBooking("Annu", "9876543210", "-2");

        ConfirmationPage1 confirm = new ConfirmationPage1(driver);
        Assert.assertFalse(confirm.isBookingConfirmed());
    }

    @Test
    public void TC10_Neg_SpecialCharName() {
        performBooking("@@@@", "9876543210", "2");

        ConfirmationPage1 confirm = new ConfirmationPage1(driver);
        Assert.assertFalse(confirm.isBookingConfirmed());
    }

    @Test
    public void TC11_Neg_WithoutPayment() {

        navigateToTour();

        TourDetailsPage1 tour = new TourDetailsPage1(driver);
        tour.clickBookNow();

        BookingPage1 booking = new BookingPage1(driver);
        booking.enterName("Annu");
        booking.enterPhone("9876543210");
        booking.enterPersons("2");
        booking.clickConfirmBooking();

        // Skip payment

        ConfirmationPage1 confirm = new ConfirmationPage1(driver);
        Assert.assertFalse(confirm.isBookingConfirmed());
    }

    @Test
    public void TC12_Neg_PaymentFailure() {

        performBooking("Annu", "9876543210", "2");

        ConfirmationPage1 confirm = new ConfirmationPage1(driver);

        // Replace when failure logic implemented
        Assert.assertTrue(confirm.isBookingConfirmed());
    }
}