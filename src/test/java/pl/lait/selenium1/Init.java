package pl.lait.selenium1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Init {
	
	static WebDriver driver = null;

	public static WebDriver getDriver() {
		System.setProperty("webdriver.gecko.driver", "/Users/adam/Documents/LAIT/geckodriver");
        
        DesiredCapabilities cap = DesiredCapabilities.firefox();
        
        driver = new FirefoxDriver(cap);
        driver.get("http://newtours.demoaut.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
	}
	
	
	public static void endTest() {
		driver.quit();
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
