package starter.OrangeHrm;

import net.serenitybdd.screenplay.targets.Target;

public class DashboardPage {

    public static class sidebar {
        public static Target SIDEBAR_DASHBOARD = Target.the("dashboard page sidebar - Dashboard").locatedBy("//*[text()='Dashboard']");
        public static Target SIDEBAR_LEAVE = Target.the("dashboard page sidebar - Leave").locatedBy("//span[text()='Leave']");
    }


}
