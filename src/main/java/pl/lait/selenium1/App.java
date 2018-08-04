package pl.lait.selenium1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public class App 
{
	
	static WebDriver driver;
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        System.setProperty("webdriver.gecko.driver", "/Users/adam/Documents/LAIT/geckodriver");
        
        DesiredCapabilities cap = DesiredCapabilities.firefox();
        
        driver = new FirefoxDriver(cap);
        driver.get("http://newtours.demoaut.com");
        sleep(2);
        driver.findElement(By.linkText("SIGN-ON")).click();
        sleep(3);
        driver.findElement(By.name("userName")).sendKeys("adamdz");
        driver.findElement(By.name("password")).sendKeys("qwe123");
        sleep(1);
        driver.findElement(By.name("login")).click();
        sleep(4);
        
        driver.quit();
        
        
    }
    
    public static void sleep(int seconds) {
	    	try {
				Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
