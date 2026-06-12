package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPageObject {
	
	public WebDriver driver;
	
	public CheckoutPageObject(WebDriver driver)
	{
		this.driver =  driver;
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
		return driver.findElement(productName).getText().split("-")[0].trim();
	}
	
	public void enterPromoCode(String code)
	{
		driver.findElement(promoCode).sendKeys(code);
	}
	
	public void applyPromoCode()
	{
		driver.findElement(applyPromoCode).click();
	}
	
	public void placeOrder()
	{
		driver.findElement(placeOrder).click();
	}
	
	public String getPromoCodeMessage()
	{
		return driver.findElement(promoCodeMessage).getText();
	}
	
	public void selectCountry(String countryName)
	{
		Select sc = new Select(driver.findElement(countryDropdown));
		sc.selectByValue(countryName);
	}
	
	public void agreeTerms()
	{
		driver.findElement(agreeTerms).click();
	}
	
	public void placingOrder()
	{
		driver.findElement(placeOrderButton).click();
	}
	

}
