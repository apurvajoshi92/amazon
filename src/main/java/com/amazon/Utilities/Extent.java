package com.amazon.Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Extent {
    private static ExtentReports extent;
    static String formattedDateTime;

    public static ExtentReports getInstance() {
        if (extent == null) {
            // Set the path for the report
            String reportPath = "C:\\Users\\thora\\IdeaProjects\\testAmazon\\Result\\ExtentReport.html";
            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportPath);
            htmlReporter.config().setDocumentTitle("Amazon Automation Report");
            htmlReporter.config().setReportName("Amazon Test Automation");
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
        }
        return extent;
    }
}
