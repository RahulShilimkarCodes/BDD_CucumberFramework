package testRunners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="classpath:FeatureFile/searchProduct.feature",
				//features="classpath:FeatureFile", 	-- to run all the feature files...
		glue="greenKartSteps",
		dryRun=false,
		monochrome=true,
		plugin= {"pretty", "html:target/greenkart-cucumber.html","json:target/greenkart-cucumber.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"rerun:target/failed_scenarios.txt"},
		tags="@DataDriven"		
		)


public class CucumberTestRunner extends AbstractTestNGCucumberTests{
	
	
	static {
		System.setProperty("extent.properties",
			    System.getProperty("user.dir") + "src/test/resources/propertyFiles/extent.properties");
    }
	
	@Override						//since same method name in child class...
	@DataProvider(parallel=true)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}
	
	/*
	 * To use extent spark in CI-CD, use below
	 * Command Line ---->     mvn test -Dextent.properties=src/test/resources/propertyFiles/extent.properties
	 * Class ---> System.getProperty("extent.properties", "extent.properties")
	 * 
	 * 
	 */
	
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
