package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import testUtils.ConfigReaderManager;

public class LandingPageObject {
	
	public WebDriver driver;
	
	public LandingPageObject(WebDriver driver)
	{
		this.driver = driver;
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
		driver.findElement(enterItem).sendKeys(product);
	}
	
	public void searchTheItem()
	{
		driver.findElement(searchItem).click();
	}
	
	public String getProductName()
	{
		String name = driver.findElement(productName).getText().split("-")[0].trim();
		return name;
	}
	
	public void clickOnOffersPage()
	{
		driver.findElement(offersPage).click();
	}
	
	public void loadGreenKart()
	{
		driver.get(ConfigReaderManager.getProperties("base_url"));
	}
	
	public void selectQuantity(int quantity)
	{
		for(int i = 1 ; i < quantity;i++)
		{
			driver.findElement(addToCart).click();
		}	
	}
	
	public void addToCart()
	{
		driver.findElement(addToCart).click();
	}
	
	public void goToCart()
	{
		driver.findElement(cartButton).click();
		driver.findElement(proceedToCart).click();
	}

}
