package starter.OrangeHrm;

import net.serenitybdd.screenplay.targets.Target;

public class LeavePage {

    // main leave page
    static Target PAGE_TITLE_LEAVE = Target.the("Page title - Leave").locatedBy("//h6[text()='Leave']");

    // topbar apply button in leave page
    static Target TOPBAR_APPLY = Target.the("topbar menu - Apply").locatedBy("//a[.='Apply']");

    // topbar My Leave button in leave page
    public static Target TOPBAR_MYLEAVE = Target.the("topbar menu - My Leave").locatedBy("//a[.='My Leave']");

    // sub page - apply leave page
    public static class ApplyLeavePage {

        // sub page title
        static Target PAGE_TITLE_APPLY_LEAVE = Target.the("sub page title - Apply Leave").locatedBy(".orangehrm-main-title");

        // sub page component - leave type
        static Target INPUT_LEAVE_TYPE = Target.the("input type - leave type").locatedBy(".oxd-select-text-input");

        // dropdown element appear after input leave type component is clicked
        static Target DROPDOWN_LISTBOX_LEAVE_TYPE = Target.the("dropdown appear from leave type").locatedBy("//div[@role='listbox' and contains(@class, 'oxd-select-dropdown')]");
        static Target DROPDOWN_LISTBOX_LEAVE_TYPE_1ST_LIST = Target.the("1st leave type dropdown list").locatedBy("//div[@role='option' and text()='-- Select --']");
        static Target DROPDOWN_LISTBOX_LEAVE_TYPE_2ND_LIST = Target.the("2nd leave type dropdown list").locatedBy("//div[@role='option' and .//span[text()='CAN - FMLA']]");

        // leave balance
        public static Target LEAVE_QUOTA = Target.the("Current leave quota").locatedBy(".orangehrm-leave-balance-text");

        // ------------------ calendar component
        // outer input calendar field
        static Target INPUT_CALENDAR_FROM_DATE = Target.the("input calendar - from date").locatedBy("//div[@class='oxd-grid-4 orangehrm-full-width-grid']/div[1]//input[@class='oxd-input oxd-input--active']");
        // component calendar - default
        static Target CALENDAR_FROM_DATE = Target.the("component calendar").locatedBy("//div[contains(@class, 'oxd-date-input-calendar')]");
        // component calendar - today button
        static Target CALENDAR_TODAY = Target.the("component calendar - today").locatedBy("//div[contains(@class, 'oxd-date-input-link') and text()='Today']");
        // component calendar - next working day, after current day
        static Target CALENDAR_NEXT_WORKING_DAY = Target.the("component calendar - next working day, after today").locatedBy("//div[contains(@class, 'oxd-calendar-date-wrapper') and not(contains(@class, '--non-working-day')) and preceding-sibling::div[contains(@class, '--today')]]");
        // trials
        public static final Target SELECTED_DATE = Target.the("current selected date")
                .locatedBy("//div[contains(@class, 'oxd-calendar-date-wrapper') and contains(@class, '--selected')]");
        public static final Target NEXT_WORKING_DAY = Target.the("next working day")
                .locatedBy("//div[contains(@class, 'oxd-calendar-date-wrapper') and not(contains(@class, '--non-working-day'))]//div[@class='oxd-calendar-date']");
        // next button
        public static final Target CALENDAR_RIGHT_BUTTON_NEXT_MONTH = Target.the("Next month in the calendar").locatedBy(".bi-chevron-right");
        // calendar month - November
        public static final Target CALENDAR_MONTH_TEXT_NOVEMBER = Target.the("Calendari month text - November").locatedBy("//p[.='November']");
        // button apply leave
        public static Target BUTTON_APPLY = Target.the("button apply leave").locatedBy(".oxd-button");
        // message apply success
        public static Target TXT_APPLY_SUCCESS = Target.the("text apply success").locatedBy("//*[text()='Successfully Saved']");
        // ------------------

        // comments input
        public static final Target INPUT_COMMENTS = Target.the("input box comments").locatedBy(".oxd-textarea");
    }

    public static class MyLeavePage {
        // sub page title
        public static Target PAGE_TITLE_MYLEAVE = Target.the("sub page title - My Leave").locatedBy(".oxd-text--h5");

    }
}
