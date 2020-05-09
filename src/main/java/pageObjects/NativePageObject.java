package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class NativePageObject  {

    private AndroidDriver ad;

    public NativePageObject(RemoteWebDriver appiumDriver) {
        this.ad = (AndroidDriver) appiumDriver;
    }

    WebElement signInBtn = ad.findElementById("platkovsky.alexey.epamtestapp:id/email_sign_in_button");
}
