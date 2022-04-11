package util;

import util.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.*;
import util.ConfigReader;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Method;
import java.util.Properties;


public class ApplicationHooks {

    private DriverFactory driverFactory;
    private WebDriver driver;
    private ConfigReader configReader;
    Properties properties;

    /**
     *
     */
    @Before(order = 0)
    public void getProperties() {
        configReader = new ConfigReader();
        properties = configReader.initProp();
    }

    /**
     *
     */
    @Before(order = 1)
    public void before() {
        //String browserName = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
        String url = properties.getProperty("url");
        driverFactory = new DriverFactory();
        driver = driverFactory.initDriver("chrome");
        driver.get(url);
    }


    @BeforeSuite
    public void beforeSuite(ITestContext context) {
    }

    @BeforeTest
    public void beforeTest(ITestContext context) {
    }

//    @BeforeStep
//    public void beforeStep(Scenario scenario) {
//    }

    @BeforeClass
    public void beforeClass(ITestContext context) {
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
    }

    @AfterMethod
    public void afterMethod(ITestContext context) {
    }

    @AfterClass
    public void afterClass(ITestContext context) {
    }

    @AfterTest
    public void afterTest(ITestContext context) {
    }

    @AfterSuite
    public void afterSuite(ITestContext context) {
    }

    @After
    public void tearDown(Scenario scenario) { driver.quit(); }
}
