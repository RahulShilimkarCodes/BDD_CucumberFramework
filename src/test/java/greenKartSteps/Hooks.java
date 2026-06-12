package greenKartSteps;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import testUtils.TestSetup;

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
	
	@After
	public void quitDriver()
	{
		testSetup.webDriverManager.quitDriver();
	}

}
