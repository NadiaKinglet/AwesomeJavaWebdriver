package day2;

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

public class YahooSearch {
    WebDriver driver;
    By searchInput = By.cssSelector("#uh-search-box");

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

    @Test
    public void testSearch2() {
        String queryString = "Google";

        openMainPage();
        typeQuery(queryString);
        submitSearch();
        assertResult();
    }

    private void assertResult() {
        WebElement resultsCount = driver.findElement(By.xpath("//a[@class='next']/following-sibling::span"));
        String resultsText = resultsCount.getText();
        Assert.assertTrue(resultsText.endsWith("results"));
        System.out.println(resultsText);


    }

    private void submitSearch() {
        WebElement element = driver.findElement(searchInput);
        element.submit();
    }

    private void typeQuery(String queryString) {
        WebElement element = driver.findElement(searchInput);
        element.sendKeys(queryString);

    }

    private void openMainPage() {
        driver.get("https://ca.yahoo.com/?p=us");
    }

//    public void explicitWait (WebDriver driver) {
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("yui_3_10_0_1_1543358889798_1483")) );
//    }

    public void sleepThread (){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
