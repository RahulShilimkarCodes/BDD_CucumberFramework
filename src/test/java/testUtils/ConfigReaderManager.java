package testUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReaderManager {
	
	public static Properties properties = new Properties();
	
	static {
	InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("propertyFiles/config.qa.properties");
	
	try {
		properties.load(inputStream);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public static String getProperties(String property)
	{
		return properties.getProperty(property);
	}

}
