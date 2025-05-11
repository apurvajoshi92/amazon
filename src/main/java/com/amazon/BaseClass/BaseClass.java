package com.amazon.BaseClass;

import com.amazon.Utilities.DriverUtil;
import com.amazon.Utilities.Extent;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
    public static WebDriver driver;
    public static ExtentReports extent;
    public static ExtentTest test;
    public static WebDriverWait wait;


    public  void setUp() {
        // Initialize WebDriver
        driver = DriverUtil.getDriver();
        // Initialize wait
        wait=DriverUtil.getWait();
        // Initialize ExtentReports
        extent = Extent.getInstance();

    }

    @AfterClass
    public void tearDown() {
        // Flush the report
        if (extent != null) {
            extent.flush();
        }
        // Close the WebDriver
        DriverUtil.closeDriver();
    }
}
