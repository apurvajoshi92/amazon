package com.amazon.Pages;

import com.amazon.BaseClass.BaseClass;
import com.amazon.Utilities.DriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class AppleWatchQuickLookPage extends BaseClass {
    private DriverUtil driverUtil=new DriverUtil();
    // Locators for elements on the product page
    private By productDetailTooltip = By.xpath("//a[@class='ProductShowcase__title__SBCBw']");
    private By appleWatchImage = By.xpath("(//div[@class='EditorialTileProduct__inner__Px1QT EditorialTileProduct__rectangular__MqxNA'])[1]");
    private By seeAllDetails = By.xpath("//span[text()='See all details']");
    public AppleWatchQuickLookPage() {

    }
    public void hoverOverAppleWatchTooltip() {
        Actions hover = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //s.executeScript("window.scrollBy(0,350)", "");
        hover.moveToElement(driver.findElement(productDetailTooltip)).build().perform();
        String tooltip=driver.findElement(appleWatchImage).getText();
        Assert.assertTrue(tooltip.contains("Apple Watch SE"));
        test.pass("product is correct "+tooltip);
    }

    public boolean seeAllDetailsButtonCheck(){
        return driverUtil.checkIfWebelementIsDisplyed(seeAllDetails);
    }
}
