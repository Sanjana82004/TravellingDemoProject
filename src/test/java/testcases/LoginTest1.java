package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pageobject.HomePage1;
import Pageobject.LoginPage1;
import base.BaseClass1;

public class LoginTest1 extends BaseClass1 {

    // Common method to navigate to login page
    public LoginPage1 navigateToLogin() {
        HomePage1 home = new HomePage1(driver);
        home.clickLogin();
        return new LoginPage1(driver);
    }

    @Test
    public void TC01_Pos_ValidLogin() {

        LoginPage1 login = navigateToLogin();

        login.enterEmail("annu123@gmail.com");
        login.enterPassword("Annu@123");
        login.clickLogin();

        String alertText = login.handleAlertIfPresent();

        // Valid login me alert nahi aana chahiye
        Assert.assertNull(alertText);
    }

    @Test
    public void TC02_Neg_WrongPassword() {

        LoginPage1 login = navigateToLogin();

        login.enterEmail("annu123@gmail.com");
        login.enterPassword("Wrong123");
        login.clickLogin();

        String alertText = login.handleAlertIfPresent();

        Assert.assertEquals(alertText, "Invalid credentials");
    }

    @Test
    public void TC03_Neg_WrongEmail() {

        LoginPage1 login = navigateToLogin();

        login.enterEmail("wrong@gmail.com");
        login.enterPassword("Annu@123");
        login.clickLogin();

        String alertText = login.handleAlertIfPresent();

        Assert.assertEquals(alertText, "Invalid credentials");
    }

    @Test
    public void TC04_Neg_EmptyEmail() {

        LoginPage1 login = navigateToLogin();

        login.enterEmail("");
        login.enterPassword("Annu@123");
        login.clickLogin();

        String alertText = login.handleAlertIfPresent();

        Assert.assertEquals(alertText, "All fields are required!");
    }

    @Test
    public void TC05_Neg_EmptyPassword() {

        LoginPage1 login = navigateToLogin();

        login.enterEmail("annu123@gmail.com");
        login.enterPassword("");
        login.clickLogin();

        String alertText = login.handleAlertIfPresent();

        Assert.assertEquals(alertText, "All fields are required!");
    }

    @Test
    public void TC06_Neg_AllFieldsEmpty() {

        LoginPage1 login = navigateToLogin();

        login.enterEmail("");
        login.enterPassword("");
        login.clickLogin();

        String alertText = login.handleAlertIfPresent();

        Assert.assertEquals(alertText, "All fields are required!");
    }
}