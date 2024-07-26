package emulator;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import config.ConfigReader;
import io.appium.java_client.android.AndroidDriver;

public class EmulatorDriver {
    private static AndroidDriver driver;
    private static DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    private static final String DEVICE_NAME = ConfigReader.emulatorConfig.deviceName();
    private static final String PLATFORM_NAME = ConfigReader.emulatorConfig.platformName();
    private static String APP_PACKAGE = ConfigReader.emulatorConfig.appPackage();
    private static String APP_ACTIVITY = ConfigReader.emulatorConfig.appActivity();
    private static final String URL = ConfigReader.emulatorConfig.remoteURL();

    public static AndroidDriver getDriver() {
        return driver;
    }

    public static void setDriver(AndroidDriver driver) {
        EmulatorDriver.driver = driver;
    }

    public static java.net.URL getUrl() {
        try {
            return new URL(URL);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static AndroidDriver createDriver() {
        desiredCapabilities.setCapability("deviceName", DEVICE_NAME);
        desiredCapabilities.setCapability("platformName", PLATFORM_NAME);
        desiredCapabilities.setCapability("appPackage", APP_PACKAGE);
        desiredCapabilities.setCapability("appActivity", APP_ACTIVITY);
        driver = new AndroidDriver(getUrl(), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        setDriver(driver);
        return driver;
    }
}
