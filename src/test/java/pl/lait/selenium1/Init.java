package pl.lait.selenium1;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Init {
	
	static WebDriver driver = null;

	public static WebDriver getDriver() {
		System.setProperty("webdriver.gecko.driver", "/Users/adam/Documents/LAIT/geckodriver");
        URL url = null;
		try {
			url = new URL("http://192.168.0.104:4444/wd/hub");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        if (driver == null) {
        		//driver = new FirefoxDriver(cap);
        		driver = new RemoteWebDriver(url, cap);
            driver.get("http://newtours.demoaut.com");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //driver.manage().window().maximize();
            
            return driver;
        } else {
        		return driver;
        }
	}
	
	public static void endTest() {
		driver.quit();
		driver = null;
	}
	
	public static void sleep(int seconds) {
	    	try {
				Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // end catch
	} // end sleep
}//end class
