package starter.OrangeHrm;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AssertLeave {
    public static Performable withLeaveBalanceFullDayShouldBe(String expectedLeaveBalance) {
        return Task.where("{0} assert leave balance after submitting leave for 1 daye",

                // insert leave type -> CAN - FMLA
                // Click input leave type
                WaitUntil.the(LeavePage.ApplyLeavePage.INPUT_LEAVE_TYPE, isVisible())
                        .forNoMoreThan(5).seconds()
                        .then(Ensure.that(LeavePage.ApplyLeavePage.INPUT_LEAVE_TYPE).isDisplayed()),
                Click.on(LeavePage.ApplyLeavePage.INPUT_LEAVE_TYPE),

                // wait until dropdown list appear
                WaitUntil.the(LeavePage.ApplyLeavePage.DROPDOWN_LISTBOX_LEAVE_TYPE, isVisible())
                        .forNoMoreThan(5).seconds()
                        .then(Ensure.that(LeavePage.ApplyLeavePage.DROPDOWN_LISTBOX_LEAVE_TYPE).isDisplayed()),

                // wait until 1st dropdown list also appear to make sure
                WaitUntil.the(LeavePage.ApplyLeavePage.DROPDOWN_LISTBOX_LEAVE_TYPE_1ST_LIST, isVisible())
                        .forNoMoreThan(5).seconds()
                        .then(Ensure.that(LeavePage.ApplyLeavePage.DROPDOWN_LISTBOX_LEAVE_TYPE_1ST_LIST).isDisplayed()),

                // choose 2nd dropdown -> CAN FMLA
                WaitUntil.the(LeavePage.ApplyLeavePage.DROPDOWN_LISTBOX_LEAVE_TYPE_2ND_LIST, isVisible())
                        .forNoMoreThan(5).seconds()
                        .then(Ensure.that(LeavePage.ApplyLeavePage.DROPDOWN_LISTBOX_LEAVE_TYPE_2ND_LIST).isDisplayed()),
                Click.on(LeavePage.ApplyLeavePage.DROPDOWN_LISTBOX_LEAVE_TYPE_2ND_LIST),

                // make sure that 2nd list of dropdown from input leave type is clicked
                WaitUntil.the(LeavePage.ApplyLeavePage.INPUT_LEAVE_TYPE, isVisible())
                        .forNoMoreThan(5).seconds()
                        .then(Ensure.that(LeavePage.ApplyLeavePage.INPUT_LEAVE_TYPE).hasText("CAN - FMLA")),

                // wait until leave number quotas changed
                WaitUntil.the(LeavePage.ApplyLeavePage.LEAVE_QUOTA, isVisible()).forNoMoreThan(5).seconds(),
                WaitUntil.the(LeavePage.ApplyLeavePage.LEAVE_QUOTA, containsText(expectedLeaveBalance))
                        .forNoMoreThan(5).seconds()
                        .then(Ensure.that(LeavePage.ApplyLeavePage.LEAVE_QUOTA).isDisplayed()),

                // make sure current balance for CAM FMLA is correct - should be -1
                WaitUntil.the(LeavePage.ApplyLeavePage.LEAVE_QUOTA, isVisible())
                        .forNoMoreThan(5).seconds()
                        .then(Ensure.that(LeavePage.ApplyLeavePage.LEAVE_QUOTA).hasText(expectedLeaveBalance))
        );
    }
}
