package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utilities.ExtentManager1;
import utilities.ScreenshotUtil1;

public class TestListener1 implements ITestListener {

    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test = ExtentManager1.getInstance()
                .createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.log(Status.FAIL, "Test Failed");

        String path = ScreenshotUtil1.captureScreenshot(
                base.BaseClass1.driver,
                result.getMethod().getMethodName());

        test.addScreenCaptureFromPath(path);
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentManager1.getInstance().flush();
    }
}