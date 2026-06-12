package greenKartSteps;



import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import testUtils.TestSetup;
import testUtils.WebDriverManager;


public class Hooks {

	public TestSetup testSetup;
	
	public Hooks(TestSetup testSetup)			//You never write new TestSetup(). PicoContainer does it internally - calls TestSetup constructor..
	{
		this.testSetup = testSetup;
	}
	
	@Before
	public void setUpDriver()
	{
		testSetup.webDriverManager.initDriver();			//since constructor does new TestSetup() in background, we can all methods as well...
		testSetup.initializeWaits();
		testSetup.initializePageObjects();
	}
	
	@AfterStep
	public void attachScreenshot(Scenario scenario) throws IOException
	{
		 WebDriver driver = WebDriverManager.getDriver();
		 if (scenario.isFailed()) {
		        TakesScreenshot ts = (TakesScreenshot) driver;
		        File screenshot = ts.getScreenshotAs(OutputType.FILE);

		      //converting File screenshot to Byte to, use to attach to extent reports..
		        byte[] screenshotBytes = FileUtils.readFileToByteArray(screenshot);
		        scenario.attach(screenshotBytes, "image/png", "Failure Screenshot");
		    }
	}
	
	@AfterStep
	public void attachAllStepsScreenshot(Scenario scenario) throws IOException
	{
		WebDriver driver = WebDriverManager.getDriver();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshot = ts.getScreenshotAs(OutputType.FILE);

		// converting File screenshot to Byte to, use to attach to extent reports..
		byte[] screenshotBytes = FileUtils.readFileToByteArray(screenshot);
		scenario.attach(screenshotBytes, "image/png", "Failure Screenshot");	    
	}
	
	@After
	public void quitDriver()
	{
		testSetup.webDriverManager.quitDriver();
	}

}
