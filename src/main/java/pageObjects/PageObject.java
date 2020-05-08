package pageObjects;

import org.openqa.selenium.WebElement;
import setup.IPageObject;

public class PageObject implements IPageObject {

    public PageObject(String appType) {
        System.out.println("Current app type: "+appType);
    }

    @Override
    public WebElement getWelement(String weName) {
        return null;
    }
}
