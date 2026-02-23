package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader1 {


	    Properties prop;

	    public void ConfigReader() {
	        try {
	            prop = new Properties();
	            FileInputStream fis =
	                    new FileInputStream("src/main/resources/config.properties");
	            prop.load(fis);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public String getProperty(String key) {
	        return prop.getProperty(key);
	    
	}
}
