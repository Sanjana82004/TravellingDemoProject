package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.HomePage;

public class HomeTests extends BaseClass {

    @Test(priority = 1)
    public void TC_HM_001_pageLoadsSuccessfully() {

        HomePage home = new HomePage(driver);
        Assert.assertTrue(home.isHeroVisible(), "Hero Section not visible");
    }

    @Test(priority = 2)
    public void TC_HM_002_featuredToursVisible() {

        HomePage home = new HomePage(driver);
        Assert.assertTrue(home.isFeaturedToursVisible(), 
                "Featured Tours not displayed");
    }

    @Test(priority = 3)
    public void TC_HM_003_CTA_NavigationWorks() {

        HomePage home = new HomePage(driver);
        home.clickExplore();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("tours"), 
                "Explore navigation failed");
    }
}