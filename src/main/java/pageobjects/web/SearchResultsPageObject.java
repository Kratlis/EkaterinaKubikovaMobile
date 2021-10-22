package pageobjects.web;

import io.appium.java_client.AppiumDriver;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPageObject extends WebPageObject {

    @FindAll({
        @FindBy(css = "#rso div.g cite"),
        @FindBy(css = "#rso div.xpd a div > span:last-child")
    })
    private List<WebElement> searchResultsLinks;

    public SearchResultsPageObject(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public List<String> getSearchResultsLinks() {
        return searchResultsLinks.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
