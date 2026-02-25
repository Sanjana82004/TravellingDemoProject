package utilities;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {
            ExtentSparkReporter spark =
                new ExtentSparkReporter("test-output/ExtentReport.html");

            spark.config().setReportName("Travel Automation Report");
            spark.config().setDocumentTitle("Guest Flow Testing");

            extent = new ExtentReports();
            extent.attachReporter(spark);
        }

        return extent;
    }
}