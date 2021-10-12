package scenarios;

import java.util.Locale;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pageobjects.web.SearchResultsPageObject;
import pageobjects.web.StartPageObject;
import setup.BaseTest;
import utils.WebInitProperties;

public class WebMobileTests extends BaseTest {

    @Test(groups = {"web"}, description = "Make sure that google  search for the word 'EPAM' shows relevant results")
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

        Assertions.assertThat(resultsPageObject.getSearchResultsLinks()
                                               .stream().limit(WebInitProperties.LINKS_LIMIT)
                                               .filter(link -> link.toLowerCase(Locale.ROOT)
                                                                   .contains(WebInitProperties.KEY_WORD))
                      .count())
                  .isGreaterThanOrEqualTo(WebInitProperties.EPAM_LINKS_COUNT);

        // Log that test finished
        System.out.println("Searching done");
    }
}
