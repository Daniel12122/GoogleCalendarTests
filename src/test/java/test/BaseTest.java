package test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import emulator.EmulatorDriver;
import io.appium.java_client.android.AndroidDriver;

public class BaseTest extends EmulatorDriver {
    protected static AndroidDriver driver;

    @BeforeAll
    public static void setUp() {
        driver = createDriver();
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
