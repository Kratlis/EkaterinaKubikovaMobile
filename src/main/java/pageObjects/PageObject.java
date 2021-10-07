package pageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObjects.nativeApp.LoginPageObject;
import pageObjects.web.StartPageObject;
import setup.IPageObject;

public class PageObject implements IPageObject {

    AppiumDriver driver;

    // it should be set of web page or EPAM Test App WebElements
    Object pageObject;

    public PageObject(String appType, AppiumDriver appiumDriver) throws Exception {
        driver = appiumDriver;

        System.out.println("Current app type: " + appType);

        switch (appType) {
            case "web":
                pageObject = new StartPageObject(appiumDriver);
                break;
            case "native":
                pageObject = new LoginPageObject(appiumDriver);
                break;
            default:
                throw new Exception("Can't create a page object for " + appType);
        }
    }

    public PageObject() {}

    @Override
    public WebElement getElement(By elementLocator) {
        return driver.findElement(elementLocator);
    }

    public Object getPageObjectInstance() {
        return pageObject;
    }
}
