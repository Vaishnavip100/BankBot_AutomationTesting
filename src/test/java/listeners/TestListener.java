package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utils.ExtentManager;

public class TestListener implements ITestListener {
    ExtentReports extent=ExtentManager.getInstance();
    ExtentTest test;

    public static ThreadLocal<ExtentTest> tl=new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        test=extent.createTest(result.getMethod().getMethodName());
        tl.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        tl.get().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        tl.get().fail(result.getThrowable());
        WebDriver driver=base.BaseTest.getDriver();
        String screenshotPath=utils.ScreenshotUtil.captureScreenshot(driver, result.getName());
        try {
            tl.get().addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(org.testng.ITestContext context) {
        extent.flush();
    }
}