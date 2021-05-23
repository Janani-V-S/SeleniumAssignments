package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(dryRun = false, features = {"src/test/java/features/DeleteLead.feature","src/test/java/features/DuplicateLead.feature"}, glue = {"stepDefs"}, monochrome = true)
public class RunLeafTapsApplication extends AbstractTestNGCucumberTests {

}
