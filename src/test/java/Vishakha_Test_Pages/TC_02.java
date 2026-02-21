package Vishakha_Test_Pages;

import org.testng.Assert;
import org.testng.annotations.Test;

import Vishakha_Page_Object_Package.POM_TC_02;


public class TC_02 extends Base_Test{
	
	@Test
	public void verifyPackagesPageNavigation() {
		POM_TC_02 hp = new POM_TC_02(driver);
		
		hp.goToPackagesPage();
		
		String expectedHeader="Package Results:";
		String actualHeader=hp.getResultsPageHeaderText();
		
		System.out.println(expectedHeader);
		System.out.println(actualHeader);
		
		Assert.assertEquals(expectedHeader, actualHeader,"package link did not worked properly Header is not matching");
		
	}

}
