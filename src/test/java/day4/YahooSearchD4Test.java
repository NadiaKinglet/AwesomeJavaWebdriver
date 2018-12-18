package day4;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class YahooSearchD4Test extends BaseTest{

    String url = "https://ca.yahoo.com";
    By searchBox = By.id("uh-search-box");
    String queryString = "Portnov School";
    String cssValue = ".compPagination span";

    @Test
    public void testSearch() {

        openPage(url);
        sendKeysTo(searchBox, queryString);
        submitSearch(searchBox);
        assertResult(cssValue);
    }
}
