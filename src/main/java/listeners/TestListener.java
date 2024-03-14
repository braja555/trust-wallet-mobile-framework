package listeners;


import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reports.ExtentReport;
import utils.DriverUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.startTest(result.getName(), result.getMethod().getDescription())
                .assignCategory("Trust Wallet Android Automation")
                .assignAuthor("Raja");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentReport.getTest().log(Status.PASS, "Test Passed");
    }

    public void onTestFailure(ITestResult result) {
            DriverUtils driverManager = new DriverUtils();
            File file = driverManager.getDriver().getScreenshotAs(OutputType.FILE);

            byte[] encoded = null;
            try {
                encoded = Base64.encodeBase64(FileUtils.readFileToByteArray(file));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            ExtentReport.getTest().fail("Test Failed",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(new String(encoded, StandardCharsets.US_ASCII)).build());
            ExtentReport.getTest().fail(result.getThrowable());
        }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentReport.getTest().log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ExtentReport.getTest().log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
    }

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReport.getReporter().flush();
    }
}
