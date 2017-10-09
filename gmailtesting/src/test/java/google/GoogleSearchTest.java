package google;

import base.BaseTest;
import org.testng.annotations.Test;
import page.SearchPage;
import page.SearchResultPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class GoogleSearchTest extends BaseTest {
    private SearchPage searchPage = new SearchPage();
    private SearchResultPage searchResultPage = new SearchResultPage();

    @Test
    public void googleTextSearch() {
        String searchedText = "Google";
        searchPage.openSearchPage();
        searchPage.setSearchedText(searchedText);
        searchPage.pressEnter();
        searchResultPage.getResultedLabelText();
        String actualText = searchResultPage.getResultedLabelText();

        assertThat(actualText, containsString(searchedText));
    }
}
