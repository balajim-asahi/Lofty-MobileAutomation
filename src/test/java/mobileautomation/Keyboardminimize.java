package mobileautomation;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.KeyEventFlag;

import static mobileautomation.BaseClass.driver;

public class Keyboardminimize {
    public static void minimze(){
        KeyEvent keyEvent = new KeyEvent();
        keyEvent.withKey(AndroidKey.BACK);
        keyEvent.withFlag(KeyEventFlag.SOFT_KEYBOARD);
        driver.pressKey(keyEvent);
    }
}
