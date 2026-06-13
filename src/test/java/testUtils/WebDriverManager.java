package testUtils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverManager {

	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	private static ThreadLocal<WebDriverWait> tlWait = new ThreadLocal<>();

	public WebDriver initDriver() {
		if (tlDriver.get() == null) {
			synchronized (WebDriverManager.class) {
				if (tlDriver.get() == null) {
					String browser_properties= ConfigReaderManager.getProperties("browser");
					String browser_maven = System.getProperty("browser", browser_properties);					
					
					switch (browser_maven.toLowerCase()) {
					case "chrome" -> tlDriver.set(new ChromeDriver());
					case "edge" -> tlDriver.set(new EdgeDriver());
					case "firefox" -> tlDriver.set(new FirefoxDriver());
					default -> throw new IllegalArgumentException("Incorrect browser passed: " + browser_properties);
					}
				}
			}
			
			//tlDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); - implicit wait
			//tlWait.set(new WebDriverWait(getDriver(), Duration.ofSeconds(10)));
		}
		
		return tlDriver.get();
	}

	public static WebDriver getDriver() {
		return tlDriver.get();
	}

	public void quitDriver() {
		if (tlDriver.get() != null) {
			tlDriver.get().quit();
			tlDriver.remove();
		}
	}

}
