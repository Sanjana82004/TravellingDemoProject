package Vishakha_Test_Pages;

import org.testng.Assert;
import org.testng.annotations.Test;

import Vishakha_Page_Object_Package.POM_TC_03;


public class TC_03 extends Base_Test {
	
	
	
	@Test
	public void verifyHeaderUIAndAlignment() {
		POM_TC_03 hp=new POM_TC_03(driver);
		
		int actualLinkCount=hp.getLinkCount();
		int expectedLinkCount=4;
		
		Assert.assertEquals(actualLinkCount, expectedLinkCount,"link count is mismatched");
		
		int logoX = hp.getLogoPosition();
        int loginX = hp.getLoginPosition();
        
        Assert.assertTrue(logoX < loginX,"Alignment Error");
	}

}
