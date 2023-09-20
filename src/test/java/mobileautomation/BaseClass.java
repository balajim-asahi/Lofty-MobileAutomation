package mobileautomation;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {

    static AndroidDriver driver = null;
    static WebElement JoinTheClub, JoinLOFTY;

    @SuppressWarnings("deprecation")
    @BeforeClass
    public void setup() throws Throwable {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Office");
        caps.setCapability(MobileCapabilityType.UDID, "2654efd6");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.0");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Oneplus 7");
        caps.setCapability(MobileCapabilityType.NO_RESET, true);
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
        caps.setCapability("appPackage", "com.choosy.lofty");
        caps.setCapability("appActivity", "com.choosy.lofty.MainActivity");
        caps.setCapability("autoGrantPermissions", true);
        caps.setCapability(MobileCapabilityType.NO_RESET, false);
        URL url = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver(url, caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(10000);

        try {

            JoinTheClub = driver.findElement(By.xpath("//*[@text ='Join the club']"));
            JoinTheClub.click();
        } catch (NoSuchElementException e) {

            System.out.println("ElementA not found");


            try {
                JoinLOFTY = driver.findElement(By.xpath("//*[@text='Join LOFTY']"));
                JoinLOFTY.click();
            } catch (NoSuchElementException e2) {

                System.out.println("ElementB not found");
            }
        }


    }
}

