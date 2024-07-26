package pages;


import org.junit.jupiter.api.Assertions;

import java.util.logging.Logger;

public class DayPage extends BasePage {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    public void verifyCreateEvent(String expectedEventTitleText) {
        logger.info("Checking the creation of the event");
        Assertions.assertTrue(getElementByPartOfContentDesc(expectedEventTitleText).isDisplayed());
    }

    public void verifyDeleteEvent(String expectedDeleteEventTitleText) {
        logger.info("Checking the deletion of the event");
        Assertions.assertTrue(getElementsByPartOfContentDesc(expectedDeleteEventTitleText).isEmpty());
    }

    public EventPage clickToEventByName(String eventName) {
        logger.info("Click event by name " + eventName);
        getElementByPartOfContentDesc(eventName).click();
        return new EventPage();
    }

}
