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

public class AppleHomePage extends BaseClass {
    private DriverUtil driverUtil= new DriverUtil();


    private By appleWatchDropDown = By.xpath("(//ul[@class='Navigation__navList__HrEra']//li//a[@role='button'])[4]");
    private By appleWatchQuickLook = By.xpath("(//button[@class='QuickLook__container__cchE1 QuickLook__container--showing-text__peGBL EditorialTileProduct__quickLook__cRlkW'])[1]");
    private By appleWatchImage = By.xpath("(//div[@class='EditorialTileProduct__inner__Px1QT EditorialTileProduct__rectangular__MqxNA'])[1]");
    private By searchSuggestions = By.xpath("(//div[@role='dialog' and @class='Navigation__navList__HrEra level2 Navigation__isOpen__aMUHj Navigation__subnav__CkMUI']/ul/li/a)[5]");

    public AppleHomePage() {

    }

    public void clickOnAppleWatchDropDown() {
        test.info("click On Apple Watch Drop Down");
        driverUtil.clickOnWebElement(appleWatchDropDown);
    }

    public void clickOnSuggestion(String suggestion) {
        driverUtil.selectWebElementByValue(searchSuggestions,suggestion);
    }
    public String hoverOverAppleWatch() {
        return driverUtil.mouseOverWebElement(appleWatchImage);
    }
    public void clickOnQuickView() {
        test.info("Click on quick look");
        driverUtil.clickOnWebElement(appleWatchQuickLook);
    }

    public AppleWatchQuickLookPage verifyQuickViewWindow() {
        return new AppleWatchQuickLookPage();
    }
}
