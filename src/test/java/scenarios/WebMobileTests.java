package scenarios;

import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pageobjects.web.SearchResultsPageObject;
import pageobjects.web.StartPageObject;
import setup.BaseTest;
import utils.WebInitProperties;

public class WebMobileTests extends BaseTest {

    @Test(groups = {"web"}, description = "Make sure that we've opened Google homepage")
    public void searchTest() {
        System.out.println("Searching page opening started");

        getDriver().get(WebInitProperties.START_URL);
        Assertions.assertThat(getDriver().getTitle())
                  .as("This is not Google homepage.")
                  .isEqualTo(WebInitProperties.START_TITLE);

        StartPageObject startPage = (StartPageObject) getPageObject().getPageObjectInstance();
        SearchResultsPageObject resultsPageObject = startPage.search(WebInitProperties.SEARCH_QUERY);

        Assertions.assertThat(resultsPageObject.getSearchResultsLinks().size())
                  .isNotNull();

        SoftAssertions softAssertions = new SoftAssertions();
        for (String link : resultsPageObject.getSearchResultsLinks()
                                            .stream().limit(WebInitProperties.LINKS_LIMIT)
                                            .collect(Collectors.toList())) {
            softAssertions.assertThat(link)
                          .containsIgnoringCase(WebInitProperties.KEY_WORD);
        }
        softAssertions.assertAll();

        // Log that test finished
        System.out.println("Searching done");
    }
}
