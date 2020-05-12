package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class NativePageObject  {

    private AndroidDriver ad;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/email_sign_in_button")
    WebElement signInBtn;

    public NativePageObject(RemoteWebDriver appiumDriver) {
        this.ad = (AndroidDriver) appiumDriver;
        ad.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PageFactory.initElements( new AppiumFieldDecorator(ad), this);
    }

}
