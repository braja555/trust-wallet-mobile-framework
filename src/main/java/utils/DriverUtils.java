package utils;

import io.appium.java_client.AppiumDriver;
import org.json.JSONObject;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverUtils {

    private static AppiumDriver driver;
    public static ConfigReader configReader = new ConfigReader();

    public static void initializeDriver() throws IOException {
        JSONObject jsonObj = new JSONObject(JsonReader.read("capabilities.json").toString());
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platformName", jsonObj.getString("platform"));
        caps.setCapability("appium:deviceName", jsonObj.getString("deviceName"));
        caps.setCapability("appium:automationName", jsonObj.getString("automationName"));
        caps.setCapability("appium:app", System.getProperty("user.dir") + jsonObj.getString("app_url"));
        caps.setCapability("appium:newCommandTimeout", 3600);
        caps.setCapability("appium:autoGrantPermissions", true);
        try {
            driver = new AppiumDriver(new URL(configReader.getProperty("appiumURL")), caps);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        } catch (MalformedURLException e) {
            throw new RuntimeException("Appium server URL is invalid", e);
        }

    }
    public static AppiumDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("Driver not initialized. Please call initializeDriver first.");
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
