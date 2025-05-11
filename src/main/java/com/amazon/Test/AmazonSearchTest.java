package com.amazon.Test;

import com.amazon.BaseClass.BaseClass;
import com.amazon.Pages.HomePage;
import com.amazon.Pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class AmazonSearchTest extends BaseClass {
    HomePage homePage;
    ProductPage productPage;
    @BeforeClass
    public void setUp() {
        super.setUp();
        homePage= new HomePage();

    }

    @Test
    public void validateAllAreRelatedToSearchedProduct() {

        test = extent.createTest("Validate All Are Related To Searched Product");
        homePage.openHomePage();
        homePage.enterSearchTerm("IPhone 13");
        List<String> list= homePage.getSearchSuggestions();
        test.info("validating drop down products");
        boolean flag=homePage.validateAllAreRelatedToSearchedProduct(list,"iphone 13");
        if(flag){
            test.pass("All products in drop down are related to searched product");
        }else{
            test.fail("All products in drop down are not related to searched product");
        }
        Assert.assertTrue(flag);
    }

    @Test
    public void validateNewTabIsOpened() {

        test = extent.createTest("Validate New Tab Is Opened");
        homePage.openHomePage();
        //homePage.hoverOverElectronics();
        homePage.enterSearchTerm("IPhone 13 128 GB");
        homePage.clickOnSuggestion("iphone 13 128 gb black");
        productPage=homePage.clickOnProduct();
        boolean result=productPage.clickOnAppleStoreLinkDisplayed();
        Assert.assertTrue(result);
        if(result)
            test.pass("Clicked on iphone 13 128 gb black");
        else
            test.fail("Apple phone detail page is not displyed");
    }
}
