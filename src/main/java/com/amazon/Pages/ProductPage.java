package com.amazon.Pages;

import com.amazon.BaseClass.BaseClass;
import com.amazon.Utilities.DriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class ProductPage extends BaseClass {
    private DriverUtil driverUtil= new DriverUtil();

    private By appleStoreLink1 = By.xpath("//a[text()='Visit the Apple Store']");
    //Visit the Apple Store//a[contains(text(),'Visit the')]
    private By appleStoreLink = By.xpath("//a[contains(text(),'Visit the')]");
    public ProductPage() {

    }

    public AppleHomePage clickOnAppleStoreLink() {
        test.info("click On Apple Store Link");
        driverUtil.clickOnWebElement(appleStoreLink);
        return new AppleHomePage();
    }

    public boolean checkIfAppleStoreLinkDisplayed() {
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
