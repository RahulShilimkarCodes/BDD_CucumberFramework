package testUtils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	
	private final WebDriver driver;
	private static final ThreadLocal<WebDriverWait> tlWait = new ThreadLocal<>();
	
	public WaitUtility(WebDriver driver)
	{
		this.driver = driver;
		tlWait.set(new WebDriverWait(driver, Duration.ofSeconds(10)));
	}
	
	private static WebDriverWait getWait(){
		return tlWait.get();
	}
	
	// Wait until element is visible
    public void waitForVisibility(By locator) {
    	getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Wait until element is clickable
    public void waitForClickability(By locator) {
    	getWait().until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Wait until element is present in DOM
    public void waitForPresence(By locator) {
    	getWait().until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    // Wait until text is present in element
    public void waitForText(WebElement element, String text) {
    	getWait().until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    // Wait until URL contains specific text
    public void waitForUrlContains(String partialUrl) {
    	getWait().until(ExpectedConditions.urlContains(partialUrl));
    }

    // Wait until page title matches
    public void waitForTitle(String title) {
    	getWait().until(ExpectedConditions.titleIs(title));
    }

    // Custom wait for page load completion
    public void waitForPageLoad() {
    	getWait().until(webDriver -> ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("return document.readyState").equals("complete"));
    }

}
