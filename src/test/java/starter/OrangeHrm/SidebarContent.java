package starter.OrangeHrm;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SidebarContent {
    public static Performable accessLeavePage() {
        return Task.where("{0} access sidebar - leave page",
                // click leave button on sidebar menu
                WaitUntil.the(DashboardPage.sidebar.SIDEBAR_LEAVE, isVisible()).forNoMoreThan(5).seconds().then(
                        Click.on(DashboardPage.sidebar.SIDEBAR_LEAVE)
                ),

                // wait until leave page title appear
                WaitUntil.the(LeavePage.PAGE_TITLE_LEAVE, isVisible()).forNoMoreThan(5).seconds().then(
                        Ensure.that(LeavePage.PAGE_TITLE_LEAVE).isDisplayed()
                )
        );
    }
}
