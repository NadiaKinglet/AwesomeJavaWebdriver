package day5;

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

public class YahooSearchXpath {
    WebDriver driver;

    @BeforeSuite
    public void suiteSetup (){
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") +  "/src/test/resources/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }


    String url = "https://ca.yahoo.com";
    By searchBox = By.id("uh-search-box");
    String stringToSend = "Portnov School";
    String xpathValue = "//*[@class='next']/following::span";

    @Test
    public void testSearch() {

        openPage(url);
        sendKeysTo(searchBox, stringToSend);
        submitSearch(searchBox);
        assertResult(xpathValue);
    }

    private void assertResult(String xpathValue) {
        By resultElement = By.xpath(xpathValue);
        WebElement resultSpanElement = driver.findElement(resultElement);
        explicitWait(driver, resultElement);
        String resultsText = resultSpanElement.getText();
        System.out.println(resultsText);
        Assert.assertTrue(resultSpanElement.isDisplayed());
    }

    private void explicitWait(WebDriver driver, By element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    private void submitSearch(By element) {
        System.out.println("submitting query in element" + element.toString());
        driver.findElement(element).submit();
    }

    private void sendKeysTo(By element, String stringToSend) {
        driver.findElement(element).sendKeys(stringToSend);
    }

    private void openPage(String url) {
        driver.get(url);
    }

}
