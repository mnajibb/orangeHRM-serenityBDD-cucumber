package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_old.Ac;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.OrangeHrm.*;
import starter.navigation.NavigateTo;

import net.serenitybdd.screenplay.targets.Target;
import java.util.ArrayList;
import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class OrangeHrmStepDefinitions {
    @Given("{actor} try to access Orange HRM login page")
    public void accessOrangeHrmLoginPage(Actor actor) {
        actor.wasAbleTo(NavigateTo.theHrmLoginPage());
    }

    @When("{actor} wants to login on Orange HRM with credentials username {string} and password {string}")
    public void loginAccessWithCredentials(Actor actor, String username, String password) {
        actor.attemptsTo(
                DoLogin.withCredentials(username, password)
        );
    }

    @Then("{actor} should be successfully login")
    public void should_see_information_about(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(DashboardPage.sidebar.SIDEBAR_DASHBOARD, isVisible()).forNoMoreThan(5).seconds()
        );
    }

    @Given("{actor} wants access HRM Dashboard with admin credentials via login")
    public void accessOrangeHrmDashboard(Actor actor) {
        actor.wasAbleTo(NavigateTo.theHrmLoginPage());
        actor.attemptsTo(
                // call login task
                DoLogin.withCredentials("Admin", "admin123")
        );
    }

    @When("{actor} wants to submit his leave")
//    public void submitHisLeave(Actor actor) {
//        actor.attemptsTo(
//                SidebarContent.accessLeavePage(),
//                ApplyLeave.submitLeaveTypeOnCurrentDateFullDay()
//        );
//    }

    @When("{actor} wants to submit his leave and his current leave balance is {string} on selected date {string}")
    public void submitLeaveAndHisCurrentLeaveBalance(Actor actor, String leaveBalance, String selectedDate) {
        Target selectedDatee = Target.the("current designated date")
                .locatedBy("//div[@class='oxd-calendar-dates-grid']//div[contains(text(), '"+selectedDate+"')]");

        actor.attemptsTo(
                // call access leave page task
                SidebarContent.accessLeavePage(),

                // call submit leave on working day task
                ApplyLeave.submitLeaveTypeOnNextWorkingDayByFullDay(leaveBalance, selectedDatee)
        );
    }

    @When("{actor} wants to submit his leave and his current leave balance is {string} on selected date {string} with comments {string}")
    public void submitLeaveAndHisCurrentLeaveBalanceWithComments(Actor actor, String leaveBalance, String selectedDate, String comments) {
        Target selectedDatee = Target.the("current designated date")
                .locatedBy("//div[@class='oxd-calendar-dates-grid']//div[contains(text(), '"+selectedDate+"')]");

        actor.attemptsTo(
                // call access leave page task
                SidebarContent.accessLeavePage(),

                // call submit leave on working day task
                ApplyLeave.submitLeaveTypeOnNextWorkingDayByFullDayWithComments(leaveBalance, selectedDatee, comments)
        );
    }

    @Then("{actor} should submit his leave successfully and his leave balance should be reduced by -1 into {string}")
    public void should_submitLeaveSuccessfullyAndHisLeaveBalance(Actor actor, String expectedLeaveBalance) {
        actor.attemptsTo(
                // submit leave
                WaitUntil.the(LeavePage.ApplyLeavePage.BUTTON_APPLY, isVisible())
                        .forNoMoreThan(5).seconds()
                        .then(Ensure.that(LeavePage.ApplyLeavePage.BUTTON_APPLY).isDisplayed()),
                Click.on(LeavePage.ApplyLeavePage.BUTTON_APPLY),

                // make sure leave submitted successfully
                WaitUntil.the(LeavePage.ApplyLeavePage.TXT_APPLY_SUCCESS, isVisible())
                        .forNoMoreThan(5).seconds()
                        .then(Ensure.that(LeavePage.ApplyLeavePage.TXT_APPLY_SUCCESS).isDisplayed()),

                // validate leave balance - ensure it reduces by 1.
                AssertLeave.withLeaveBalanceFullDayShouldBe(expectedLeaveBalance)
        );
    }

    @Then("{actor} should see message of unsufficient balance")
    public void should_seeMessageOfUnsufficientBalance(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(LeavePage.ApplyLeavePage.LEAVE_QUOTA, containsText("Balance not sufficient"))
                        .forNoMoreThan(5).seconds()
                        .then(Ensure.that(LeavePage.ApplyLeavePage.BUTTON_APPLY).isDisplayed())
        );
    }

    @And("{actor} should see that his submitted leave has been recored on My Leave section and check that the status should be correct by {string}")
    public void should_submitLeaveSuccessfullyAndHisLeaveBalanceAndCheckThatTheStatusIsCorrect(Actor actor, String expectedLeaveBalance) {
        Target targetExpectedLeaveBalance = Target.the("current designated leave comments")
                .locatedBy("//div[@class='orangehrm-paper-container']//div[contains(@class, 'oxd-table-body')]//div[contains(text(), '"+expectedLeaveBalance+"')]");

        actor.attemptsTo(
                // access Leave sub page - My Leave
                WaitUntil.the(LeavePage.TOPBAR_MYLEAVE, isVisible())
                        .forNoMoreThan(5).seconds()
                        .then(Ensure.that(LeavePage.TOPBAR_MYLEAVE).isDisplayed()),
                Click.on(LeavePage.TOPBAR_MYLEAVE),

                // wait until My Leave sub page is accessed
                WaitUntil.the(LeavePage.MyLeavePage.PAGE_TITLE_MYLEAVE, isVisible())
                        .forNoMoreThan(5).seconds()
                        .then(Ensure.that(LeavePage.MyLeavePage.PAGE_TITLE_MYLEAVE).isDisplayed()),

                // validate the leave comments
                WaitUntil.the(targetExpectedLeaveBalance, isVisible())
                        .forNoMoreThan(5).seconds()
                        .then(Ensure.that(targetExpectedLeaveBalance).isDisplayed())
        );
    }
}
