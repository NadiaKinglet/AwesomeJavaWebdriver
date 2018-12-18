package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NestedFrames extends BaseTest {
    By iframeById = By.id ("mce_0_ifr");
    By editorById = By.id("tinymce");
    By middleFrameContent = By.id ("content");

    String frameTop = "frame-top";
    String frameMiddle = "frame-middle";

    @Test
    public void testIframe() {
    String url = "https://the-internet.herokuapp.com/tinymce";
    String inputMessageToType = "Text from Selenium";



    openPage(url);
    switchToIframe();
    clearEditior();
    sendKeysTo(editorById,inputMessageToType);

    String actualTextFromElement = getTextFromElement(editorById);
        Assert.assertEquals(actualTextFromElement,inputMessageToType);
    

    }

    @Test
    public void testNestedFrames() {
        String url = "https://the-internet.herokuapp.com/nested_frames";
        openPage(url);
        switchToIframeByName(frameTop);
        switchToIframeByName(frameMiddle);

        String acualtTextOfMiddleElement = getTextFromElement(middleFrameContent);
        String expectdTextOfMiddleElement = "MIDDLE";

        Assert.assertEquals(acualtTextOfMiddleElement,expectdTextOfMiddleElement);

    }

    private void clearEditior() {

        WebElement editor = driver.findElement(editorById);
        editor.clear();
    }

    private void switchToIframe() {
       WebElement iframeEl = driver.findElement(iframeById);
        driver.switchTo().frame(iframeEl);
    }

    private void switchToIframeByName(String frameName) {
        driver.switchTo().frame(frameName);
    }
}
