package pageobjects.nativeapp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class BudgetActivityPageObject extends NativePageObject {

    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.widget.FrameLayout[2]//android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar/XCUIElementTypeStaticText")
    private WebElement title;

    public BudgetActivityPageObject(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public String getTitle() {
        return title.getText();
    }
}
