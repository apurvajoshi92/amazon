package com.amazon.Pages;

import com.amazon.BaseClass.BaseClass;
import com.amazon.Utilities.DriverUtil;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BaseClass {
    private DriverUtil driverUtil= new DriverUtil();
    // Locators for elements on the homepage
    private By searchBox = By.id("twotabsearchtextbox");
    private By searchSuggestions = By.xpath("//div[@class='two-pane-results-container']//div[@role='button']");
    private By product=By.xpath("//*[contains(text(),'Apple iPhone')]");
    private By categoryDropDown=By.xpath("//div[@id='nav-search-dropdown-card']");
    private By categoryDropDownOptions=By.xpath("//div[@id='nav-search-dropdown-card']//select//option");

    public HomePage() {
    }

    public void openHomePage() {
        test.info("Opening home page");
        driverUtil.openWebpage("https://www.amazon.in");
    }

    public void enterSearchTerm(String searchTerm) {
        test.info("Enter search "+searchTerm);
        driverUtil.enterValueInTextbox(searchBox,searchTerm);
    }

    public List<String> getSearchSuggestions() {
        return driverUtil.getAllTextValues(searchSuggestions);
    }
    public void clickOnSuggestion(String suggestion) {
        test.info("Click on  "+suggestion);
        driverUtil.selectWebElementByValue(searchSuggestions,suggestion);
    }

    public boolean validateAllAreRelatedToSearchedProduct(List<String> list,String productName) {
        test.info("validate All Are Related To Searched Product - "+ productName);
        boolean flag=true;
        for(String str:list){
            if(!str.contains(productName)){
                flag=false;
                break;
            }
        }
        return flag;

    }

    public ProductPage clickOnProduct(){
        driverUtil.clickOnWebElement(product);
        return new ProductPage();
    }
}
