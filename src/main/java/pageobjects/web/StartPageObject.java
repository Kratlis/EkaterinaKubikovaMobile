package pageobjects.web;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartPageObject extends WebPageObject {

    @FindBy(tagName = "input")
    private WebElement searchField;


    public StartPageObject(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public SearchResultsPageObject search(String query) {
        searchField.sendKeys(query);
        searchField.sendKeys(Keys.ENTER);
        return new SearchResultsPageObject(driver);
    }
}
