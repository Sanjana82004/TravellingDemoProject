package Vishakha_Test_Pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import Vishakha_Page_Object_Package.POM_TC_07;

public class TC_07 extends Base_Test {
	
	@Test
	public void verifyPriceLowToHighSorting() {
	POM_TC_07 hp = new POM_TC_07(driver);
	
	
	hp.clickPackageLink();
	hp.selectDropDown();
	hp.clickSearchButton();
	
	List<Double> actualPrices = hp.getPrice();

    
    List<Double> expectedPrices = new ArrayList<>(actualPrices);
    Collections.sort(expectedPrices);

   
    Assert.assertEquals(actualPrices, expectedPrices, "Sorting order match nahi kar raha!");
    Assert.assertEquals(actualPrices.get(0),1500,"Top price $2400 nahi hai!");

    
    
	}
}
