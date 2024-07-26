package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.logging.Logger;

import emulator.EmulatorDriver;
import io.appium.java_client.android.AndroidDriver;

public class BasePage extends EmulatorDriver {
    protected AndroidDriver driver;
    private Logger logger = Logger.getLogger(this.getClass().getName());

    public BasePage() {
        PageFactory.initElements(EmulatorDriver.getDriver(), this);
        this.driver = EmulatorDriver.getDriver();
    }

    public WebElement getElementByPartOfContentDesc(String partOfContentDesk) {
        logger.info("Get element by part of the content desk " + partOfContentDesk);
        return driver
                .findElement(By.xpath("//*[starts-with(@content-desc, '" + partOfContentDesk + "')]"));
    }

    public List getElementsByPartOfContentDesc(String partOfContentDesk) {
        logger.info("Get list elements by part of the content desk " + partOfContentDesk);
        return driver
                .findElements(By.xpath("//*[starts-with(@content-desc, '" + partOfContentDesk + "')]"));
    }

}
