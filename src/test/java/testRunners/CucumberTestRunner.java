package testRunners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="classpath:FeatureFile/placeOrder.feature",
		glue="greenKartSteps",
		dryRun=false,
		monochrome=true,
		plugin= {"pretty", "html:target/greenkart-cucumber.html","json:target/greenkart-cucumber.json"},
		tags="@EndToEnd"
		)


public class CucumberTestRunner extends AbstractTestNGCucumberTests{
	
	@Override						//since same method name in child class...
	@DataProvider(parallel=true)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}
	
	/*
	 * @DataProvider
    public Object[][] scenarios() {
        if (testNGCucumberRunner == null) {
            return new Object[0][0];
        }
        return testNGCucumberRunner.provideScenarios();
    }
    
    above will run this method from AbstractTestNGCucumberTests Class to run cases in parallel mode..
	 */

}
