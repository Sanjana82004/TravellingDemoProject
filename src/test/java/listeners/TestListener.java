package listeners;

import org.testng.*;
import com.aventstack.extentreports.*;
import utilities.*;
import base.BaseClass;

public class TestListener extends BaseClass implements ITestListener {

    ExtentReports extent = ExtentManager.getInstance();
    ExtentTest test;

    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed");
    }

    public void onTestFailure(ITestResult result) {
        test.fail(result.getThrowable());
        String path = ScreenshotUtil.captureScreenshot(driver, result.getName());
        test.addScreenCaptureFromPath(path);
    }

    public void onFinish(ITestContext context) {
        extent.flush();
    }
}