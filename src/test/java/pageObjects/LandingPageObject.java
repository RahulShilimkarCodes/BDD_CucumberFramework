package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import testUtils.ConfigReaderManager;
import testUtils.TestSetup;

public class LandingPageObject {
	
	public WebDriver driver;
	public TestSetup setUp;
	
	public LandingPageObject(WebDriver driver,TestSetup setUp)
	{
		this.driver = driver;
		this.setUp = setUp;
	}
	
	By enterItem = By.xpath("//input[@type='search']");
	By searchItem = By.xpath("//button[@type='submit']"); 
	By productName = By.xpath("//h4[contains(@class,'product-name')]");
	By offersPage = By.xpath("//a[contains(@href,'/offers')]");
	By incrementQuantity = By.xpath("//a[text()='+']");
	By addToCart = By.xpath("//div[@class='product-action']/child::button");
	By cartButton = By.xpath("//a[@class='cart-icon']");
	By proceedToCart = By.xpath("//button[text()='PROCEED TO CHECKOUT']");
	
	public void enterItemName(String product)
	{
		setUp.waitUtility.waitForVisibility(enterItem);
		driver.findElement(enterItem).sendKeys(product);
	}
	
	public void searchTheItem()
	{
		setUp.waitUtility.waitForClickability(searchItem);
		driver.findElement(searchItem).click();
	}
	
	public String getProductName()
	{
		setUp.waitUtility.waitForVisibility(productName);
		String name = driver.findElement(productName).getText().split("-")[0].trim();
		return name;
	}
	
	public void clickOnOffersPage()
	{
		setUp.waitUtility.waitForClickability(offersPage);
		driver.findElement(offersPage).click();
	}
	
	public void loadGreenKart()
	{
		driver.get(ConfigReaderManager.getProperties("base_url"));
		setUp.waitUtility.waitForPageLoad();
	}
	
	public void selectQuantity(int quantity)
	{
		for(int i = 1 ; i < quantity;i++)
		{
			setUp.waitUtility.waitForClickability(addToCart);
			driver.findElement(addToCart).click();
		}	
	}
	
	public void addToCart()
	{
		setUp.waitUtility.waitForClickability(addToCart);
		driver.findElement(addToCart).click();
	}
	
	public void goToCart()
	{
		setUp.waitUtility.waitForClickability(cartButton);
		driver.findElement(cartButton).click();
		setUp.waitUtility.waitForClickability(proceedToCart);
		driver.findElement(proceedToCart).click();
	}

}
