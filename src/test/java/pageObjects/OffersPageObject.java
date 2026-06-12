package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import testUtils.TestSetup;

public class OffersPageObject {
	
public WebDriver driver;
public TestSetup setUp;
	
	public OffersPageObject(WebDriver driver,TestSetup setUp)
	{
		this.driver = driver;
		this.setUp = setUp;
	}
	
	By enterItem = By.id("search-field");
	By productName = By.xpath("//table[@class='table table-bordered']/child::tbody/tr/td[1]");
	
	public void enterItemName(String product)
	{
		setUp.waitUtility.waitForClickability(enterItem);
		driver.findElement(enterItem).sendKeys(product);
	}
	
	public String getProductName()
	{
		setUp.waitUtility.waitForVisibility(productName);
		String name = driver.findElement(productName).getText().split("-")[0].trim();
		return name;
	}


}
