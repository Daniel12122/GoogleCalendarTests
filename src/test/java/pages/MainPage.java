package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.logging.Logger;

import io.appium.java_client.android.AndroidDriver;

public class MainPage extends BasePage {

    @FindBy(how = How.ID, using = "com.google.android.calendar:id/floating_action_button")
    private WebElement addActionBtn;

    @FindBy(how = How.ID, using = "com.google.android.calendar:id/speed_dial_event_container")
    private WebElement addEventBtn;

    private Logger logger = Logger.getLogger(this.getClass().getName());

    public EventPage addEvent() {
        logger.info("Add event");
        return clickAddActionBtn()
                .clickAddEventBtn();
    }

    public MainPage clickAddActionBtn() {
        logger.info("Click add action button");
        addActionBtn.click();
        return this;
    }

    public EventPage clickAddEventBtn() {
        logger.info("Click add event button");
        addEventBtn.click();
        return new EventPage();
    }

    public DayPage openDayFormCalendarByDate(String date){
        logger.info("Open " + date + " in calendar");
        getElementByPartOfContentDesc(date).click();
        return new DayPage();
    }
}
