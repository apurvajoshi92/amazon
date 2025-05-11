package com.amazon.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

public class DriverUtil {
    private static WebDriver driver;
    private static WebDriverWait wait;

    public static WebDriver getDriver()  {
        if (driver == null) {
            FirefoxOptions options = new FirefoxOptions();
            driver = new FirefoxDriver(options);
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        }
        return driver;
    }

    public static WebDriverWait getWait() {
        return wait;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
            wait = null;
        }
    }


    public static void switchToWindow() {
//Get handles of the windows
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();

        // Here we will check if child window has other child windows and will fetch the heading of the child window
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                String title=driver.getTitle();
                System.out.println(title);
                //WebElement text = driver.findElement(By.id("sampleHeading"));
                //System.out.println("Heading of child window is " + text.getText());
            }

        }
    }

    public void selectWebElementByValue(By searchSuggestions,String suggestion) {
        //test.info("Click on  "+suggestion);
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchSuggestions));
        List<WebElement> suggestions = driver.findElements(searchSuggestions);
        for (WebElement s : suggestions) {
            if (s.getText().equalsIgnoreCase(suggestion)) {
                s.click();
                break;
            }
        }
    }

    public String mouseOverWebElement(By appleWatchImage) {
        Actions hover = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        hover.moveToElement(driver.findElement(appleWatchImage)).build().perform();
        return driver.findElement(appleWatchImage).getText();

    }

    public void clickOnWebElement(By webElement){
        wait.until(ExpectedConditions.visibilityOfElementLocated(webElement));
        WebElement element = driver.findElement(webElement);
        element.click();
    }

    public boolean checkIfWebelementIsDisplyed(By webElement) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(webElement));
        return driver.findElement(webElement).isDisplayed();
    }

    public String getWindowTitle(){
        return driver.getTitle();
    }

    public void openWebpage(String url){
        driver.get(url);
    }

    public void enterValueInTextbox(By webelement,String searchTerm) {
        WebElement searchField = driver.findElement(webelement);
        searchField.clear();
        searchField.sendKeys(searchTerm);
    }

    public List<String> getAllTextValues(By Webelement) {
        //test.info("Select value "+searchBox);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Webelement));
        List<WebElement> suggestions = driver.findElements(Webelement);
        List<String> suggestionTexts = new ArrayList<>();
        for (WebElement suggestion : suggestions) {
            suggestionTexts.add(suggestion.getText());
        }
        return suggestionTexts;
    }

}
