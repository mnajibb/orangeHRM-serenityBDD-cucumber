package starter.OrangeHrm;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class getCurrentLeaveQuotaForCanFmla {
    // Create a question to retrieve text from the Target
    public static Question<String> myElementText() {
        return Text.of(LeavePage.ApplyLeavePage.LEAVE_QUOTA).asString();
    }
}
