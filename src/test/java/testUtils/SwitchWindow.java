package testUtils;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class SwitchWindow {
	
	public WebDriver driver;
	
	public SwitchWindow(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void switchToOffersPage()
	{
		String currentWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		
		for(String window : allWindows)
		{
			if(!(window.equals(currentWindow)))
			{
			if(driver.getTitle().equalsIgnoreCase("GreenKart - veg and fruits kart"))
			{
				driver.switchTo().window(window);
				break;
			}
			}
		}
	}

}
