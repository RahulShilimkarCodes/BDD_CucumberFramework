package testUtils;

import org.openqa.selenium.WebDriver;

import pageObjects.CheckoutPageObject;
import pageObjects.LandingPageObject;
import pageObjects.OffersPageObject;

//This class follows factory design pattern and is responsible for creation of the objects of all page classes...
public class PageObjectManager {
	
	public WebDriver driver;
	public TestSetup setUp;
	
	public PageObjectManager(WebDriver driver, TestSetup setUp)
	{
		this.driver = driver;
		this.setUp = setUp;
	}
	
	
	public LandingPageObject landingPageObject;
	public OffersPageObject offersPageObject;
	public CheckoutPageObject checkoutPageObject;
	
	public LandingPageObject getLandingPageObject()
	{
		landingPageObject = new LandingPageObject(driver,setUp);
		return landingPageObject;
	}
	
	public OffersPageObject getOffersPageObject()
	{
		offersPageObject = new OffersPageObject(driver,setUp);
		return offersPageObject;
	}
	
	public CheckoutPageObject getCheckoutPageObject()
	{
		checkoutPageObject = new CheckoutPageObject(driver,setUp);
		return checkoutPageObject;
	}

}
