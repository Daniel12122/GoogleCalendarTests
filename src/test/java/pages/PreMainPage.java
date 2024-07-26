package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.logging.Logger;


public class PreMainPage extends BasePage {

    @FindBy(how = How.ID, using = "com.google.android.calendar:id/next_arrow")
    private WebElement nextArrow;

    @FindBy(how = How.ID, using = "com.google.android.calendar:id/in_page_done_button")
    private WebElement doneBtn;

    private Logger logger = Logger.getLogger(this.getClass().getName());

    public MainPage passingPreMainPage() {
        logger.info("Passing pre-main page");
        return clickNextArrow()
                .clickDoneButton();
    }

    public PreMainPage clickNextArrow() {
        logger.info("Click next arrow");
        nextArrow.click();
        return this;
    }

    public MainPage clickDoneButton() {
        logger.info("Click done button");
        doneBtn.click();
        return new MainPage();
    }
}
