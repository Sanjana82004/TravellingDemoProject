package Vishakha_Test_Pages;

import org.testng.Assert;
import org.testng.annotations.Test;

import Vishakha_Page_Object_Package.POM_TC_05;
import Vishakha_Page_Object_Package.POM_TC_06;

public class TC_06 extends Base_Test {
	
	@Test
    public void verifyInvalidSearchFunctionality() {
		POM_TC_06 hp = new POM_TC_06(driver);

		hp.clickHomeLink();
        String searchKeyword = "Bhopal";
        hp.enterSearchKeyword(searchKeyword);
        System.out.println("Searching for: " + searchKeyword);

        
        hp.clickGo();

        
        String actualMessage = hp.getNotFoundmessage();
        System.out.println("Result found: " + actualMessage);

        Assert.assertTrue(actualMessage.contains("No"), 
            "Search Error: Result doesn't contains" + searchKeyword );
    
	}


}
