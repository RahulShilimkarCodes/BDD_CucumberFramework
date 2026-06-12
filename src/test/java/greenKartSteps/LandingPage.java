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
import pageObjects.LandingPageObject;
import testUtils.PageObjectManager;
import testUtils.TestSetup;

/*
 * 
 * Given User is on GreenKart Landing Page
When User searches for product with ShortName as "Tom" on HomePage
And User Extracts the actual name of product
Then User searches for same product using same ShortName as "Tom" on OffersPage
And checks if product exists under Offers Page too

 */

public class LandingPage {
	
	public String offerPageProductName;
	public TestSetup setUp;
	public PageObjectManager pageObjectManager;
	public LandingPageObject landingPageObject;
	
	
	public LandingPage(TestSetup setUp)
	{
		this.setUp = setUp;
	}
	
	@Given("User is on GreenKart Landing Page")
	public void greenKartLoandingPage()
	{
		landingPageObject = setUp.pageObjectManager.getLandingPageObject();
		landingPageObject.loadGreenKart();
	}
	
	@When("^User searches for product with ShortName as (.+) on HomePage$")
	public void searchProductOnHomePage(String productName)
	{
		//LandingPageObject landingPageObject = new LandingPageObject(setUp.driver);
		
		landingPageObject.enterItemName(productName);
		landingPageObject.searchTheItem();
		
		
		
	}
	
	@When("User Extracts the actual name of product")
	public void extractName()
	{
//		LandingPageObject landingPageObject = new LandingPageObject(setUp.driver);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setUp.landingPageProductName = landingPageObject.getProductName();	
	}
	
	
	@When("User navigates to Offers Page")
	public void clickOffersPage()
	{
//		LandingPageObject landingPageObject = new LandingPageObject(setUp.driver);
		landingPageObject.clickOnOffersPage();
	}
}
