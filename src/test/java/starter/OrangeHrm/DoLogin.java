package starter.OrangeHrm;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class DoLogin {
    public static Performable withCredentials(String username, String password) {
        return Task.where("{0} do login on orange hrm with credentials '" + username + "' and password '" + password + "'",
                // insert username
                WaitUntil.the(LoginPage.INPUT_USERNAME, isVisible()).forNoMoreThan(5).seconds().then(
                        Enter.theValue(username).into(LoginPage.INPUT_USERNAME)
                ),

                // insert password
                WaitUntil.the(LoginPage.INPUT_PASSWORD, isVisible()).forNoMoreThan(5).seconds().then(
                        Enter.theValue(password).into(LoginPage.INPUT_PASSWORD)
                ),

                // click button login
                WaitUntil.the(LoginPage.BTN_LOGIN, isVisible()).forNoMoreThan(5).seconds().then(
                        Click.on(LoginPage.BTN_LOGIN)
                ),

                // wait until login proceed successfully
                WaitUntil.the(DashboardPage.sidebar.SIDEBAR_DASHBOARD, isVisible()).forNoMoreThan(5).seconds()
        );
    }
}
