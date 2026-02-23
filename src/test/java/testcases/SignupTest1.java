package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pageobject.HomePage1;
import Pageobject.LoginPage1;
import Pageobject.SignupPage1;
import base.BaseClass1;

public class SignupTest1 extends BaseClass1 {

    public void navigateToSignup() {
        HomePage1 home = new HomePage1(driver);
        home.clickLogin();

        LoginPage1 login = new LoginPage1(driver);
        login.clickSignup();
    }

    @Test
    public void TC01_Pos_ValidSignup() {

        navigateToSignup();

        SignupPage1 signup = new SignupPage1(driver);

        signup.enterUser("Annu");
        String uniqueEmail = "annu" + System.currentTimeMillis() + "@gmail.com";
        signup.enterEmail(uniqueEmail);
        signup.enterPassword("A#9kLp@78Zx!Q");
        signup.enterAddress("Lucknow");
        signup.enterPhone("9876543210");
        signup.clickSignup();

        Assert.assertFalse(signup.isErrorDisplayed());
    }

    @Test
    public void TC02_Neg_EmptyUsername() {

        navigateToSignup();

        SignupPage1 signup = new SignupPage1(driver);

        signup.enterUser("");
        signup.enterEmail("test@gmail.com");
        signup.enterPassword("Test@123");
        signup.enterAddress("Delhi");
        signup.enterPhone("9876543210");
        signup.clickSignup();

        String alertText = signup.handleAlertIfPresent();

        Assert.assertEquals(alertText, "All fields are required!");
    }

    @Test
    public void TC03_Neg_InvalidEmail() {

        navigateToSignup();

        SignupPage1 signup = new SignupPage1(driver);

        signup.enterUser("Test");
        signup.enterEmail("invalidemail");
        signup.enterPassword("Test@123");
        signup.enterAddress("Delhi");
        signup.enterPhone("9876543210");
        signup.clickSignup();

        Assert.assertTrue(signup.isErrorDisplayed());
    }

    @Test
    public void TC04_Neg_EmptyPassword() {

        navigateToSignup();

        SignupPage1 signup = new SignupPage1(driver);

        signup.enterUser("Test");
        signup.enterEmail("test@gmail.com");
        signup.enterPassword("");
        signup.enterAddress("Delhi");
        signup.enterPhone("9876543210");
        signup.clickSignup();

        Assert.assertTrue(signup.isErrorDisplayed());
    }

    @Test
    public void TC05_Neg_InvalidPhone() {

        navigateToSignup();

        SignupPage1 signup = new SignupPage1(driver);

        signup.enterUser("Test");
        signup.enterEmail("test@gmail.com");
        signup.enterPassword("Test@123");
        signup.enterAddress("Delhi");
        signup.enterPhone("123");
        signup.clickSignup();

        Assert.assertTrue(signup.isErrorDisplayed());
    }

    @Test
    public void TC06_Neg_AllFieldsEmpty() {

        navigateToSignup();

        SignupPage1 signup = new SignupPage1(driver);

        signup.enterUser("");
        signup.enterEmail("");
        signup.enterPassword("");
        signup.enterAddress("");
        signup.enterPhone("");
        signup.clickSignup();

        Assert.assertTrue(signup.isErrorDisplayed());
    }
}