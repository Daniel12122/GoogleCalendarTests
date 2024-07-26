package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pages.EventPage;
import pages.MainPage;
import pages.PreMainPage;

public class DeleteEventTest extends BaseTest {

    private PreMainPage preMainPage = new PreMainPage();
    private EventPage eventPage = new EventPage();
    private MainPage mainPage = new MainPage();
    private String todayDate = "";
    private String eventName = "Test Event";

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
                .deleteEvent()
                .verifyDeleteEvent(eventName);
    }
}
