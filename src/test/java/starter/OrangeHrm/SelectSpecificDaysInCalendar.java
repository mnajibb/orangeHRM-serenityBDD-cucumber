package starter.OrangeHrm;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SelectSpecificDaysInCalendar implements Task {

    private final List<Integer> daysToSelect;

    // Target for all working days in the calendar
    private static final Target WORKING_DAYS = Target.the("Working days in calendar")
            .locatedBy("//div[contains(@class, 'oxd-calendar-date-wrapper') and not(contains(@class, '--non-working-day'))]");

    // Constructor to accept a list of days to select
    public SelectSpecificDaysInCalendar(List<Integer> daysToSelect) {
        this.daysToSelect = daysToSelect;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Loop through each working day element in the calendar
        for (WebElement dayElement : WORKING_DAYS.resolveAllFor(actor)) {
            // Get the text of the date element (day number as Integer)
            int dayNumber = Integer.parseInt(dayElement.getText());

            // Click only if dayNumber is in daysToSelect list
            if (daysToSelect.contains(dayNumber)) {
                dayElement.click();
                // actor.attemptsTo(Click.on(dayElement));
            }
        }
    }

    // Static method to instantiate the Task
    public static SelectSpecificDaysInCalendar forDays(List<Integer> days) {
        return new SelectSpecificDaysInCalendar(days);
    }
}