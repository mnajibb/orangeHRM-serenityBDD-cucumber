package starter.OrangeHrm;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.targets.Target;
import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ApplyLeave {
    public static Performable submitLeaveTypeOnNextWorkingDayByFullDay(String currentLeaveBalance, Target selectedDate) {
        return Task.where("{0} try to submit leave",
                // access submit leave page
                WaitUntil.the(LeavePage.TOPBAR_APPLY, isVisible()).forNoMoreThan(5).seconds().then(
                        Click.on(LeavePage.TOPBAR_APPLY)),

                // wait until sub page - apply leave appear
                WaitUntil.the(LeavePage.ApplyLeavePage.PAGE_TITLE_APPLY_LEAVE, isVisible()).forNoMoreThan(5).seconds().then(
                        Ensure.that(LeavePage.ApplyLeavePage.PAGE_TITLE_APPLY_LEAVE).isDisplayed()),

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

                // make sure current balance for CAM FMLA is correct - should be 23.00 Days
                WaitUntil.the(LeavePage.ApplyLeavePage.LEAVE_QUOTA, isVisible()).forNoMoreThan(5).seconds(),
                WaitUntil.the(LeavePage.ApplyLeavePage.LEAVE_QUOTA, containsText(currentLeaveBalance))
                        .forNoMoreThan(5).seconds()
                        .then(Ensure.that(LeavePage.ApplyLeavePage.LEAVE_QUOTA).hasText(currentLeaveBalance)),

                // choose calendar - from date
                WaitUntil.the(LeavePage.ApplyLeavePage.INPUT_CALENDAR_FROM_DATE, isVisible())
                        .forNoMoreThan(5).seconds()
                        .then(Ensure.that(LeavePage.ApplyLeavePage.INPUT_CALENDAR_FROM_DATE).isDisplayed()),
                Click.on(LeavePage.ApplyLeavePage.INPUT_CALENDAR_FROM_DATE),

                // wait until calendar from_date appear
                WaitUntil.the(LeavePage.ApplyLeavePage.CALENDAR_FROM_DATE, isVisible())
                        .forNoMoreThan(5).seconds()
                        .then(Ensure.that(LeavePage.ApplyLeavePage.CALENDAR_FROM_DATE).isDisplayed()),

                // choose today button - not used if current day is on holiday
//                WaitUntil.the(LeavePage.ApplyLeavePage.CALENDAR_TODAY, isVisible())
//                        .forNoMoreThan(30).seconds()
//                        .then(Ensure.that(LeavePage.ApplyLeavePage.CALENDAR_TODAY).isDisplayed()),
//                Click.on(LeavePage.ApplyLeavePage.CALENDAR_TODAY)

                // choose targeted date working day on the current opened calendar
                WaitUntil.the(selectedDate, isVisible())
                        .forNoMoreThan(5).seconds()
                        .then(Ensure.that(selectedDate).isDisplayed()),
                Click.on(selectedDate)
                // new selectNextCurrentWorkingDayInCalendar(),
                // new SelectSpecificDaysInCalendar(selectedDate),
        );
    }

    public static Performable submitLeaveTypeOnNextWorkingDayByFullDayWithComments(String currentLeaveBalance, Target selectedDate, String comments) {
        return Task.where("{0} try to submit leave",
                // access submit leave page
                WaitUntil.the(LeavePage.TOPBAR_APPLY, isVisible()).forNoMoreThan(5).seconds().then(
                        Click.on(LeavePage.TOPBAR_APPLY)),

                // wait until sub page - apply leave appear
                WaitUntil.the(LeavePage.ApplyLeavePage.PAGE_TITLE_APPLY_LEAVE, isVisible()).forNoMoreThan(5).seconds().then(
                        Ensure.that(LeavePage.ApplyLeavePage.PAGE_TITLE_APPLY_LEAVE).isDisplayed()),

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

                // make sure current balance for CAM FMLA is correct - should be 23.00 Days
                WaitUntil.the(LeavePage.ApplyLeavePage.LEAVE_QUOTA, isVisible()).forNoMoreThan(5).seconds(),
                WaitUntil.the(LeavePage.ApplyLeavePage.LEAVE_QUOTA, containsText(currentLeaveBalance))
                        .forNoMoreThan(5).seconds()
                        .then(Ensure.that(LeavePage.ApplyLeavePage.LEAVE_QUOTA).hasText(currentLeaveBalance)),

                // choose calendar - from date
                WaitUntil.the(LeavePage.ApplyLeavePage.INPUT_CALENDAR_FROM_DATE, isVisible())
                        .forNoMoreThan(5).seconds()
                        .then(Ensure.that(LeavePage.ApplyLeavePage.INPUT_CALENDAR_FROM_DATE).isDisplayed()),
                Click.on(LeavePage.ApplyLeavePage.INPUT_CALENDAR_FROM_DATE),

                // wait until calendar from_date appear
                WaitUntil.the(LeavePage.ApplyLeavePage.CALENDAR_FROM_DATE, isVisible())
                        .forNoMoreThan(5).seconds()
                        .then(Ensure.that(LeavePage.ApplyLeavePage.CALENDAR_FROM_DATE).isDisplayed()),

                // choose targeted date working day on the current opened calendar
                WaitUntil.the(selectedDate, isVisible())
                        .forNoMoreThan(5).seconds()
                        .then(Ensure.that(selectedDate).isDisplayed()),
                Click.on(selectedDate),
                // new selectNextCurrentWorkingDayInCalendar(),
                // new SelectSpecificDaysInCalendar(selectedDate),

                // insert comments
                WaitUntil.the(LeavePage.ApplyLeavePage.INPUT_COMMENTS, isVisible())
                        .forNoMoreThan(5).seconds()
                        .then(Ensure.that(LeavePage.ApplyLeavePage.INPUT_COMMENTS).isDisplayed()),
                Enter.theValue(comments).into(LeavePage.ApplyLeavePage.INPUT_COMMENTS)
        );
    }
}
