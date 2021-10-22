package pageobjects.nativeapp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import pageobjects.PageObject;

public abstract class NativePageObject extends PageObject {
    protected AppiumDriver driver;

    public NativePageObject(AppiumDriver appiumDriver) {
        driver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }
}
