package Day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class YahooSearchPageLoadCondition {

    WebDriver driver;

    @BeforeSuite
    public void suiteSetup (){
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") +  "/src/test/resources/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void testSearch() {
        String queryString = "Portnov School";

        openMainPage();
        typeQuery(queryString);
        submitSearch();
        assertResult();
    }



    private void assertResult() {

//        By resultsByCSS = By.cssSelector("#yui_3_10_0_1_1543851492455_185");
//        By resultXpath = By.xpath("//*[@id=\"yui_3_10_0_1_1543851492455_185\"]");

//        WebElement result = driver.findElement(By.id("results"));
//       WebElement ByClassName = result.findElement(By.className("compPagination"));
//        WebElement resultSpanElement = ByClassName.findElement(By.tagName("span"));


        WebElement resultSpanElement = driver.findElement(By.id("results"))
                .findElement(By.className("compPagination")).findElement(By.tagName("span"));
        Assert.assertTrue(resultSpanElement.isDisplayed());

//        String textFromRSE = resultSpanElement.getText();
//        System.out.println(textFromRSE);

    }

    private void submitSearch() {
        driver.findElement(By.id("uh-search-box")).submit();
        Tools.waitForPageLoaded(driver);
    }

    private void typeQuery(String queryString) {
        driver.findElement(By.id("uh-search-box")).sendKeys(queryString);
    }

    private void openMainPage() {
        driver.get("https://ca.yahoo.com");
    }

}
