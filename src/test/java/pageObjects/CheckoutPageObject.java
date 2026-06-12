package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import testUtils.TestSetup;

public class CheckoutPageObject {
	
	private WebDriver driver;
	private TestSetup setUp;
	
	
	public CheckoutPageObject(WebDriver driver,TestSetup setUp)
	{
		this.driver = driver;
		this.setUp = setUp;
	}
	
	By promoCode = By.cssSelector("input.promoCode");
	By productName = By.xpath("//table[@id='productCartTables']/child::tbody/descendant::td[2]/p[@class='product-name']");
	By applyPromoCode = By.xpath("//button[@class='promoBtn' and text()='Apply']");
	By promoCodeMessage = By.xpath("//*[@class='promoInfo']");
	By placeOrder = By.xpath("//button[text()='Place Order']");
	By countryDropdown = By.xpath("//select");
	By agreeTerms = By.xpath("//input[@class='chkAgree']");
	By placeOrderButton = By.xpath("//button[text()='Proceed']");
	
	
	public String getProductName()
	{
		setUp.waitUtility.waitForVisibility(productName);
		return driver.findElement(productName).getText().split("-")[0].trim();
	}
	
	public void enterPromoCode(String code)
	{
		setUp.waitUtility.waitForVisibility(promoCode);
		driver.findElement(promoCode).sendKeys(code);
	}
	
	public void applyPromoCode()
	{
		setUp.waitUtility.waitForClickability(applyPromoCode);
		driver.findElement(applyPromoCode).click();
	}
	
	public void placeOrder()
	{
		setUp.waitUtility.waitForClickability(placeOrder);
		driver.findElement(placeOrder).click();
	}
	
	public String getPromoCodeMessage()
	{
		setUp.waitUtility.waitForVisibility(promoCodeMessage);
		return driver.findElement(promoCodeMessage).getText();
	}
	
	public void selectCountry(String countryName)
	{
		setUp.waitUtility.waitForVisibility(countryDropdown);
		driver.findElement(countryDropdown).click();
		Select sc = new Select(driver.findElement(countryDropdown));
		sc.selectByValue(countryName);
	}
	
	public void agreeTerms()
	{
		setUp.waitUtility.waitForClickability(agreeTerms);
		driver.findElement(agreeTerms).click();
	}
	
	public void placingOrder()
	{
		setUp.waitUtility.waitForClickability(placeOrderButton);
		driver.findElement(placeOrderButton).click();
	}
	

}
