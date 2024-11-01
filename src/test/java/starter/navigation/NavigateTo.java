package starter.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {
    public static Performable theSearchHomePage() {
        return Task.where("{0} opens the DuckDuckGo home page",
                Open.browserOn().the(DuckDuckGoHomePage.class));
    }

    public static Performable theHrmLoginPage() {
        return Task.where("{0} opens the Orange HRM login page",
                Open.browserOn().the(OrangeHrmLoginPage.class));
    }
}
