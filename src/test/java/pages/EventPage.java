package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.logging.Logger;

public class EventPage extends BasePage {

    @FindBy(how = How.ID, using = "com.google.android.calendar:id/confirm_button")
    private WebElement confirmBtn;

    @FindBy(how = How.ID, using = "com.google.android.calendar:id/title")
    private WebElement titleEventInput;

    @FindBy(how = How.ID, using = "com.google.android.calendar:id/save")
    private WebElement saveBtn;

    @FindBy(how = How.ID, using = "com.google.android.calendar:id/info_action_edit_hit")
    private WebElement editBtn;

    @FindBy(how = How.ID, using = "com.google.android.calendar:id/info_action_overflow")
    private WebElement actionBtn;

    @FindBy(how = How.CSS, using = "android.widget.TextView[text='Delete']")
    private WebElement deleteEventBtn;

    @FindBy(how = How.CSS, using = "android.widget.Button[text='Delete']")
    private WebElement confirmDeleteEventBtn;

    private Logger logger = Logger.getLogger(this.getClass().getName());

    public EventPage clickStartEventDateBtn() {
        logger.info("Click start event date button");
        getElementByPartOfContentDesc("Start date").click();
        return this;
    }

    public String getTodayDate() {
        logger.info("Get today date");
        return getElementByPartOfContentDesc("Today")
                .getAttribute("content-desc");
    }

    public EventPage clickConfirmBtn() {
        logger.info("Click confirm button");
        confirmBtn.click();
        return this;
    }

    public EventPage clickEditBtn() {
        logger.info("Click edit button");
        editBtn.click();
        return this;
    }

    public MainPage clickSaveBtn() {
        logger.info("Click save button");
        saveBtn.click();
        return new MainPage();
    }

    public EventPage inputTitleEvent(String eventTitleText) {
        logger.info("Input " + eventTitleText + " in title field");
        titleEventInput.sendKeys(eventTitleText);
        return this;
    }

    public EventPage clickActionBtn() {
        logger.info("Click action button");
        actionBtn.click();
        return this;
    }

    public EventPage clickDeleteEventBtn() {
        logger.info("Click delete event button");
        deleteEventBtn.click();
        return this;
    }

    public DayPage clickConfirmDeleteEventBtn() {
        logger.info("Click confirm delete event button");
        confirmDeleteEventBtn.click();
        return new DayPage();
    }

    public MainPage addNewEvent(String eventTitleText) {
        logger.info("Add new event");
        return inputTitleEvent(eventTitleText)
                .clickSaveBtn();
    }

    public String getTodayDateFromCalendar() {
        clickStartEventDateBtn();
        String originalDate = getTodayDate();
        clickConfirmBtn();
        logger.info("Get today date from calendar");
        return dateConversion(originalDate);
    }

    public DayPage deleteEvent() {
        logger.info("Delete event");
        return clickActionBtn()
                .clickDeleteEventBtn()
                .clickConfirmDeleteEventBtn();
    }

    private String dateConversion(String originalDate) {
        String dateString = originalDate.replace("Today ", "");
        String dateString2 = dateString.replace(",", "");
        String[] parts = dateString2.split(" ");
        logger.info("Conversion date from " + originalDate + " to " + parts[0] + " " + parts[2] + " " + parts[1]);
        return parts[0] + " " + parts[2] + " " + parts[1];
    }
}
