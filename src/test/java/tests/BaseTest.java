package tests;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.DriverUtils;

import java.io.IOException;

public class BaseTest {
    private static AppiumDriverLocalService service;

    @BeforeSuite
    public void beforeSuite() {
        service = AppiumDriverLocalService.buildDefaultService();
        if (!service.isRunning()) {
            service.start();
            System.out.println("Server started");
            service.clearOutPutStreams();
        } else
            System.out.println("Appium Server is running");
    }

    @BeforeMethod
    public void setUp() throws IOException {
        DriverUtils.initializeDriver();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        DriverUtils.quitDriver();
    }

    @AfterSuite
    public void afterSuite() {
        if (service.isRunning()) {
            service.stop();
            System.out.println("Appium server started");
        }
    }
}
