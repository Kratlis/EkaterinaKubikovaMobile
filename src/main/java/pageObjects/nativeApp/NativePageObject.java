package pageObjects.nativeApp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pageObjects.PageObject;
import setup.IPageObject;

public abstract class NativePageObject extends PageObject {
    protected AppiumDriver driver;

    public NativePageObject(AppiumDriver appiumDriver) {
        driver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }
}
