package com.amazon.Test;


import com.amazon.BaseClass.BaseClass;
import com.amazon.Pages.AppleHomePage;
import com.amazon.Pages.AppleWatchQuickLookPage;
import com.amazon.Pages.HomePage;
import com.amazon.Pages.ProductPage;
import com.amazon.Utilities.DriverUtil;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AppleSearchTest extends BaseClass {
    private HomePage homePage;
    private ProductPage productPage;
    private DriverUtil driverUtil;
    private AppleHomePage appleHomePage;
    private AppleWatchQuickLookPage appleWatchQuickLookPage;

    @BeforeClass
    public void setUp() {
        super.setUp();
        homePage=new HomePage();
    }

    @Test
    public void testClickOnProduct() {
        test = extent.createTest("Test Click On Product and new window opened");
        homePage.openHomePage();
        //homePage.hoverOverElectronics();
        homePage.enterSearchTerm("IPhone 13 128 GB");
        homePage.clickOnSuggestion("iphone 13 128 gb 5g");
        productPage=homePage.clickOnProduct();
        String title=productPage.switchToWindow();
        boolean flag=true;
        //Assert.assertEquals("Apple iPhone 15 (128 GB) - Black : Amazon.in: Electronics",title);
        if(title.contains("Apple iPhone")){
            test.pass("New window is opened with title - "+ title);
            Assert.assertTrue(flag);
        }else{
            flag=false;
            test.fail("New window is not opened");
            Assert.assertTrue(flag);
        }
        appleHomePage=productPage.clickOnAppleStoreLink();
        appleHomePage.clickOnAppleWatchDropDown();
        appleHomePage.clickOnSuggestion("Apple Watch SE (GPS + Cellular)");
        String tooltip=appleHomePage.hoverOverAppleWatch();
        Assert.assertTrue(tooltip.contains("Apple Watch SE"));
        test.pass("Tooltip is verified "+tooltip);
        appleHomePage.clickOnQuickView();
        appleWatchQuickLookPage=appleHomePage.verifyQuickViewWindow();
        boolean result=appleWatchQuickLookPage.seeAllDetailsButtonCheck();
        Assert.assertTrue(result);
        if(result)
            test.pass("apple Watch Quick Look Page displayed");
        else
            test.fail("apple Watch Quick Look Page displayed");
    }

}
