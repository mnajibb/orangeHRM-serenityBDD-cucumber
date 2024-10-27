package starter.OrangeHrm;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class selectNextCurrentWorkingDayInCalendar implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        // String nextDayText = Text.of(LeavePage.ApplyLeavePage.NEXT_WORKING_DAY).viewedBy(actor).asString();
        actor.attemptsTo(Click.on(LeavePage.ApplyLeavePage.NEXT_WORKING_DAY));
    }

    public static selectNextCurrentWorkingDayInCalendar fromCalendar() {
        return instrumented(selectNextCurrentWorkingDayInCalendar.class);
    }
}
