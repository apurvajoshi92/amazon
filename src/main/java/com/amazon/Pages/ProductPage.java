package com.amazon.Pages;

import com.amazon.BaseClass.BaseClass;
import com.amazon.Utilities.DriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class ProductPage extends BaseClass {
    private DriverUtil driverUtil= new DriverUtil();

    private By appleStoreLink = By.xpath("//a[text()='Visit the Apple Store']");
    //Visit the Apple Store
    //private By appleStoreLink = By.linkText("Visit the Apple Store");
    public ProductPage() {

    }

    public AppleHomePage clickOnAppleStoreLink() {
        test.info("click On Apple Store Link");
        driverUtil.clickOnWebElement(appleStoreLink);
        return new AppleHomePage();
    }

    public boolean clickOnAppleStoreLinkDisplayed() {
        test.info("check if apple store link displayed");
        return driverUtil.checkIfWebelementIsDisplyed(appleStoreLink);
    }


    public String switchToWindow() {
        test.info("Switching window ");
        driverUtil.switchToWindow();
        wait.until(ExpectedConditions.visibilityOfElementLocated(appleStoreLink));
        return driverUtil.getWindowTitle();

    }
}
