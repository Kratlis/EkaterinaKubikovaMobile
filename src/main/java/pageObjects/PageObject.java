package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import setup.IPageObject;

import java.lang.reflect.Field;

public class PageObject implements IPageObject {

    Object somePageObject; // it should be set of web page or EPAM Test App WebElements

    public PageObject(String appType, RemoteWebDriver appiumDriver) throws Exception {

        System.out.println("Current app type: "+appType);
        switch(appType){
            case "web":
                somePageObject = new WebPageObject(appiumDriver);
                break;
            case "native":
                somePageObject = new NativePageObject(appiumDriver);
                break;
                default: throw new Exception("Can't create a page object for "+appType);
        }

    }

    @Override
    public WebElement getWelement(String weName) throws NoSuchFieldException, IllegalAccessException {

        Field field = somePageObject.getClass().getDeclaredField(weName);
        field.setAccessible(true);

        return (WebElement) field.get(somePageObject);

    }
}
