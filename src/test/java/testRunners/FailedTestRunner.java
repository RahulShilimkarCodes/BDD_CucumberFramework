package testRunners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
	
	@CucumberOptions(
			features="@target/failed_scenarios.txt",
			glue="greenKartSteps",
			dryRun=false,
			monochrome=true,
			plugin= {"pretty", "html:target/greenkart-cucumber.html","json:target/greenkart-cucumber.json",
					"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
					},
			tags="@DataDriven"		
			)


	public class FailedTestRunner extends AbstractTestNGCucumberTests{
		
		
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

}
