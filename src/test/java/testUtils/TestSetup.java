package testUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import greenKartSteps.Hooks;


//All the shared items across classes will be stored in this class...
public class TestSetup {
	
	public WebDriver driver;
	public WebDriverWait wait;
	public String landingPageProductName;
	public PageObjectManager pageObjectManager;
	public WebDriverManager webDriverManager;
	public SwitchWindow window;
	public Hooks hooks;
	public WaitUtility waitUtility;
	
	public TestSetup()
	{
		webDriverManager = new WebDriverManager();
		
	}
	
	public void initializePageObjects()
	{
		pageObjectManager = new PageObjectManager(WebDriverManager.getDriver(),this);
		window = new SwitchWindow(WebDriverManager.getDriver());
	}
	public void initializeWaits()
	{
		waitUtility = new WaitUtility(WebDriverManager.getDriver());
	}
	

}
