package com.amazon.Test;


import com.amazon.BaseClass.BaseClass;
import com.amazon.Pages.AppleHomePage;
import com.amazon.Pages.HomePage;
import com.amazon.Pages.ProductPage;
import com.amazon.Utilities.DriverUtil;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchResultsTest extends BaseClass {
    private WebDriver driver;
    private HomePage homePage;
    private ProductPage productPage;
    private DriverUtil driverUtil;
    private AppleHomePage appleHomePage;

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
        homePage.clickOnSuggestion("iphone 13 128 gb black");
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
    }

    @Test
    public void testClickOnAppleStoreLink() {
        test = extent.createTest("Test Click On Product and new window opened");
        homePage.openHomePage();
        //homePage.hoverOverElectronics();
        homePage.enterSearchTerm("IPhone 13 128 GB");
        homePage.clickOnSuggestion("iphone 13 128 gb black");
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
    }
}
