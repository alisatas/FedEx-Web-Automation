package util;

import io.cucumber.java.After;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;

import java.util.concurrent.TimeUnit;

public class DriverFactory {
    WebDriver driver;
    public static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    /**
     * @param browser
     * @return
     */
    public WebDriver initDriver(String browser) {
        System.out.println("browser value is: " + browser);
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            threadLocalDriver.set(new ChromeDriver());
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            threadLocalDriver.set(new FirefoxDriver());
        } else {
            System.out.println("Please pass the correct browser value: " + browser);
        }
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        //getDriver().manage().timeouts().pageLoadTimeout(10000, TimeUnit.SECONDS);
        getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return getDriver();
    }

    public static synchronized WebDriver getDriver() {
        return threadLocalDriver.get();
    }

}



