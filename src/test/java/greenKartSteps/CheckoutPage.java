package greenKartSteps;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckoutPageObject;
import testUtils.PageObjectManager;
import testUtils.TestSetup;

public class CheckoutPage {
	
	public TestSetup testSetup;
	public PageObjectManager pageObjectManager;
	public CheckoutPageObject checkoutPageObject;
	public String checkOutPageProductName;
	public String promoCodeMessage;
	
	public CheckoutPage(TestSetup testSetup)
	{
		this.testSetup = testSetup;
	}
	
	@When("User validates the item in checkout page")
	public void validateProductName()
	{
		checkoutPageObject = testSetup.pageObjectManager.getCheckoutPageObject();
		checkOutPageProductName = checkoutPageObject.getProductName();
		Assert.assertEquals(checkOutPageProductName, testSetup.landingPageProductName);
	}
	
	@Then("^User enters the promo code as (.+)$")
	public void enterPromoCode(String promoCode)
	{
		checkoutPageObject.enterPromoCode(promoCode);
		checkoutPageObject.applyPromoCode();
	}
	
	@Then("user verifies successful promoCode application")
	public void verifySuccessfulPromo()
	{
		
		promoCodeMessage = checkoutPageObject.getPromoCodeMessage();
		Assert.assertEquals("Code applied ..!",promoCodeMessage);
	}
	
	@Then("User places the order")
	public void placeOrder()
	{
		checkoutPageObject.placeOrder();
	}
	
	@Then("^User selects country as (.+)$")
	public void selectCountryAndPlaceOrder(String countryName)
	{
		checkoutPageObject.selectCountry(countryName);
		checkoutPageObject.agreeTerms();
		checkoutPageObject.placingOrder();
	}

}
