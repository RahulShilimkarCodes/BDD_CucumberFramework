package greenKartSteps;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.OffersPageObject;
import testUtils.TestSetup;

/*
 * 
 * Given User is on GreenKart Landing Page
When User searches for product with ShortName as "Tom" on HomePage
And User Extracts the actual name of product
Then User searches for same product using same ShortName as "Tom" on OffersPage
And checks if product exists under Offers Page too

 */

public class OffersPage {
	
	public String offerPageProductName;
	public TestSetup setUp;
	public OffersPageObject offersPageObject;
	
	public OffersPage(TestSetup setUp)
	{
		this.setUp = setUp;
	}

	
	@Then("^User searches for same product using same ShortName as (.+) on OffersPage$")
	public void searchProductOn(String productName)
	{	
		//switchToOffersPage();
		setUp.window.switchToOffersPage();
		
		//OffersPageObject offersPage = new OffersPageObject(setUp.driver);
		offersPageObject = setUp.pageObjectManager.getOffersPageObject();
		offersPageObject.enterItemName(productName);

	}
	
	@Then("checks if product exists under Offers Page too")
	public void checkOffer()
	{
		//OffersPageObject offersPage = new OffersPageObject(setUp.driver);
		offerPageProductName = offersPageObject.getProductName();
		
		Assert.assertEquals(setUp.landingPageProductName, offerPageProductName);
		
		if(setUp.landingPageProductName.equals(offerPageProductName))
		{
			System.out.println("Product Name on offer is :- "+setUp.landingPageProductName);
		}
	}
	
	
}
