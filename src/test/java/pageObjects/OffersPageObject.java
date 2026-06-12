package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPageObject {
	
public WebDriver driver;
	
	public OffersPageObject(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By enterItem = By.id("search-field");
	By productName = By.xpath("//table[@class='table table-bordered']/child::tbody/tr/td[1]");
	
	public void enterItemName(String product)
	{
		driver.findElement(enterItem).sendKeys(product);
	}
	
	public String getProductName()
	{
		String name = driver.findElement(productName).getText().split("-")[0].trim();
		return name;
	}


}
