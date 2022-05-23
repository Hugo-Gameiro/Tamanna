package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/",
        glue = {"stepDefinition"},
        plugin = {"pretty"}
)
public class Run extends AbstractTestNGCucumberTests {
}
