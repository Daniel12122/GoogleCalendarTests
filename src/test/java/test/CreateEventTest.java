package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import pages.DayPage;
import pages.EventPage;
import pages.PreMainPage;

public class CreateEventTest extends BaseTest {


    private PreMainPage preMainPage = new PreMainPage();
    private EventPage eventPage = new EventPage();
    private DayPage dayPage = new DayPage();
    private String eventName = "Test Event";

    @Test
    public void createCalendarEvent() {
        preMainPage
                .passingPreMainPage()
                .addEvent();

        String todayDate = eventPage.getTodayDateFromCalendar();

        eventPage
                .addNewEvent(eventName)
                .openDayFormCalendarByDate(todayDate)
                .verifyCreateEvent(eventName);
    }

    @AfterEach
    public void afterTest() {
        dayPage.clickToEventByName(eventName)
                .deleteEvent()
                .verifyDeleteEvent(eventName);
    }
}
