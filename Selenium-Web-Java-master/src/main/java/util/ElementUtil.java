package util;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

import static org.junit.Assert.*;

public class ElementUtil {
    public static CustomLogger logger = new CustomLogger(ElementUtil.class);

    private WebDriver driver;
    private Actions action;
    private WebDriverWait wait;
    JavascriptExecutor js;

    public ElementUtil(WebDriver driver) {
        this.driver = driver;
        this.action = new Actions(driver);
        this.wait = new WebDriverWait(driver, 5);
        this.js = (JavascriptExecutor) driver;
    }

    public void click(By element,String continueBtn) {
        findElement(element).click();
        logger.info("' " + continueBtn + " '" + " => Element clicked");
    }

    public void clickElement(By element) throws InterruptedException {
        WebElement element1 = driver.findElement(element);
        element1.click();
        logger.info("' " + element1 + " '" + " => Element clicked");
        Thread.sleep(2000);


    }

    public void checkUrl(String urlTitle) {
        wait.until(ExpectedConditions.urlToBe(urlTitle));
        System.out.println("Actual Url " + urlTitle);
        logger.info("' " + urlTitle + " '" + " => URL");
    }

    public void clickTextContains(By element, String text) {
        boolean check = false;
        List<WebElement> elements = findElements(element);
        for (WebElement elem : elements) {
            if (elem.getText().contains(text)) {
                elem.click();
                logger.info("' " + elem + " '" + " => Clicked text");
                check = true;
                break;
            }
        }
        if (check == false) {
            Assert.fail("Text couldn't found");
            logger.info( " => Text could't found");
        }
    }

    public WebElement findElement(By element) {
        return waitVisibility(element);
    }

    public List<WebElement> findElements(By element) {
        return waitVisibilities(element);
    }

    public WebElement waitVisibility(By element) {
        WebElement elem = wait.until(ExpectedConditions.presenceOfElementLocated(element));
        return elem;
    }

    public void waitByMilliSeconds(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
            System.out.println("waited until=> " + milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<WebElement> waitVisibilities(By element) {
        List<WebElement> elem = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));
        return elem;
    }

    public void elementIsDisplayed(By element,String key) {
        List<WebElement> elem = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));
        boolean isDisplayedElement = driver.findElement(element).isDisplayed();
        assertTrue("' " + key + " ' " + " ' " + isDisplayedElement + " '" + " => Is displayed element", isDisplayedElement);
        System.out.println("elementDisplayed");
        logger.info("' " + key + " ' " + " ' " + key + " '" + " => Is displayed element");
    }

    public void acceptCookies() {
        driver.manage().deleteAllCookies();
        logger.info("' " + " '" + " => Deleted all cookies");
    }

    public void checkURLContains(String expectedURL) throws InterruptedException {
        Thread.sleep(1000);
        String getCurrentUrl = driver.getCurrentUrl();
        org.testng.Assert.assertEquals(getCurrentUrl,expectedURL);
        logger.info("' " + expectedURL + " ' " + " ' " + getCurrentUrl + " '" + " =>  Existing url from expected url");
    }

    public void checkTextFromElements(By element, String text) {
        boolean check = false;
        List<WebElement> elements = findElements(element);
        for (WebElement elem : elements) {
            if (elem.getText().contains(text)) {
                check = true;
                logger.info("Expected texts are present on page");
                break;
            }
        }
        if (check == false) {
            logger.info("Expected texts are NOT present on page");
            Assert.fail("Expected texts are not present on page");
        }
    }

    public void getText(By element, String getValue) {
        String actualTitle = driver.findElement(element).getText();
        List<WebElement> elem = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));
        logger.info("' " + actualTitle + " ' " + " ' " + getValue + " '" + " =>Element text");
        org.testng.Assert.assertEquals(actualTitle,getValue);
    }

    public void sendKey(By element, String text) {
        findElement(element).sendKeys(text+Keys.ENTER);
        logger.info("Text is written");
    }
}
