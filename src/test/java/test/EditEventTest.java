package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pages.DayPage;
import pages.EventPage;
import pages.MainPage;
import pages.PreMainPage;

public class EditEventTest extends BaseTest {

    private PreMainPage preMainPage = new PreMainPage();
    private EventPage eventPage = new EventPage();
    private MainPage mainPage = new MainPage();
    private DayPage dayPage = new DayPage();
    private String todayDate = "";
    private final String eventName = "Test Event";
    private final String editEventName = "Edit test event";

    @BeforeEach
    public void beforeTest() {
        preMainPage
                .passingPreMainPage()
                .addEvent();

        todayDate = eventPage.getTodayDateFromCalendar();

        eventPage
                .addNewEvent(eventName);
    }

    @Test
    public void createCalendarEvent() {

        mainPage.openDayFormCalendarByDate(todayDate)
                .clickToEventByName(eventName)
                .clickEditBtn()
                .inputTitleEvent(editEventName)
                .clickSaveBtn()
                .openDayFormCalendarByDate(todayDate)
                .verifyCreateEvent(editEventName);

    }

    @AfterEach
    public void afterTest() {
        dayPage.clickToEventByName(editEventName)
                .deleteEvent()
                .verifyDeleteEvent(eventName);
    }
}
