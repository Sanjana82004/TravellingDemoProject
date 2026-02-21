package Vishakha_Test_Pages;

import org.testng.Assert;
import org.testng.annotations.Test;

import Vishakha_Page_Object_Package.POM_TC_05;

public class TC_05 extends Base_Test {
	
	@Test
    public void verifySearchFunctionality() {
		POM_TC_05 hp = new POM_TC_05(driver);

		hp.clickHomeLink();
        String searchKeyword = "Aswan";
        hp.enterSearchKeyword(searchKeyword);
        System.out.println("Searching for: " + searchKeyword);

        
        hp.clickGo();

        
        String actualResult = hp.getFirstResultTitle();
        System.out.println("Result found: " + actualResult);

        Assert.assertTrue(actualResult.contains(searchKeyword), 
            "Search Error: Result doesn't contains" + searchKeyword );
    
	}

}
