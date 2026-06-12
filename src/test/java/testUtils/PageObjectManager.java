package testUtils;

import org.openqa.selenium.WebDriver;

import pageObjects.CheckoutPageObject;
import pageObjects.LandingPageObject;
import pageObjects.OffersPageObject;

//This class follows factory design pattern and is responsible for creation of the objects of all page classes...
public class PageObjectManager {
	
	public WebDriver driver;
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public LandingPageObject landingPageObject;
	public OffersPageObject offersPageObject;
	public CheckoutPageObject checkoutPageObject;
	
	public LandingPageObject getLandingPageObject()
	{
		landingPageObject = new LandingPageObject(driver);
		return landingPageObject;
	}
	
	public OffersPageObject getOffersPageObject()
	{
		offersPageObject = new OffersPageObject(driver);
		return offersPageObject;
	}
	
	public CheckoutPageObject getCheckoutPageObject()
	{
		checkoutPageObject = new CheckoutPageObject(driver);
		return checkoutPageObject;
	}

}
