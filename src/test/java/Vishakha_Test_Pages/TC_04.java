package Vishakha_Test_Pages;

import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.Test;

import Vishakha_Page_Object_Package.POM_TC_04;

public class TC_04 extends Base_Test {
	
	@Test
    public void verifyLayoutIntegrityOnSmallScreen() {
        POM_TC_04 hp = new POM_TC_04(driver);

        
        driver.manage().window().setSize(new Dimension(500, 800));
        
        System.out.println("Window resized to small view.");

       
        int logoY = hp.getLogoYPosition();
        int homeLinkY = hp.getHomeLinkYPosition();

        System.out.println("Logo Y: " + logoY);
        System.out.println("Home Link Y: " + homeLinkY);

        Assert.assertNotEquals(logoY, homeLinkY, "UI Bug: Logo aur Navbar links overlap ho rahe hain!");
        
        driver.manage().window().maximize();
	}
}
