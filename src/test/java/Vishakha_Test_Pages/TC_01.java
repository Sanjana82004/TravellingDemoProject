package Vishakha_Test_Pages;
import org.testng.Assert;
import org.testng.annotations.Test;

import Vishakha_Page_Object_Package.POM_TC_01;


public class TC_01 extends Base_Test{
	
	@Test
    public void validateHomePage() {
		
        POM_TC_01 hp = new POM_TC_01(driver);
        
       
        String actualTitle = hp.getPageTitle();
        String expectedTitle = "MERN - Travel And Tourism"; 
        Assert.assertEquals(actualTitle, expectedTitle, "Page title match nahi hua!");

        
        boolean isLogoPresent = hp.isLogoDisplayed();
        Assert.assertTrue(isLogoPresent, "Logo webpage par display nahi ho raha hai!");

        
	}

}
