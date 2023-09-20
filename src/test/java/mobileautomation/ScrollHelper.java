package mobileautomation;

import io.appium.java_client.MobileBy;

public  class ScrollHelper extends BaseClass{

    public static void ScrollDown(String untilto){
        System.out.println("untilto = " + untilto);
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()"
                        + ".scrollable(true)).scrollIntoView(new UiSelector()"
                        + ".text(\""+untilto+"\"));"));
    }
}
