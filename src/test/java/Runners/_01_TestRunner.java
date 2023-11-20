package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@SmokeTest",
        features = {"src/test/java/FeatureFiles/_01_Login.feature"},
        glue = {"StepDefinitions"},
        plugin = {"json:target/cucumber/cucumber.json"}


)
public class _01_TestRunner extends AbstractTestNGCucumberTests {

}
