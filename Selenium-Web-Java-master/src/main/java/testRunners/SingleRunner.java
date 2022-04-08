package testRunners;

import com.beust.jcommander.Parameter;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/features"},
        glue = {"stepDefinitions", "util"},
        plugin = { "summary", "pretty", "html:Reports/CucumberReport/Reports.html",
        "json:Reports/CucumberReport/Report",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }
)

public class SingleRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
