package starter.OrangeHrm;

import net.serenitybdd.screenplay.targets.Target;

class LoginPage {

    static Target INPUT_USERNAME = Target.the("username text field").locatedBy("//input[@placeholder='Username']");
    static Target INPUT_PASSWORD = Target.the("password text field").locatedBy("//input[@placeholder='Password']");
    static Target BTN_LOGIN = Target.the("button login").locatedBy("//*[text()=' Login ']");
}
