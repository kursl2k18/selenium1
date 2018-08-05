package pl.lait.selenium1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Init {
	
	static WebDriver driver = null;
	static ExtentTest extentTest;
	static ExtentReports extent;
	

	public static WebDriver getDriver() {
		System.setProperty("webdriver.gecko.driver", "/Users/adam/Documents/LAIT/geckodriver");
		
		String extentReportFile = "target/extentReportFile.html";
		String extentReportImage = "target/extentReportImage.png";
        
		extent = new ExtentReports(extentReportFile, true);
		
		extentTest = extent.startTest("My First Test", "Verify WebSite Title");
		
        DesiredCapabilities cap = DesiredCapabilities.firefox();extentTest = extent.startTest("Test started");
        
        extentTest = extent.startTest("Test started");
        
        driver = new FirefoxDriver(cap);
        driver.get("http://newtours.demoaut.com");
        
        extentTest.log(LogStatus.INFO, "Navigated to newtours.demoaut.com");

        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        
        
        extentTest.log(LogStatus.INFO, "Browser Launched");
        
        return driver;
	}
	
	public static void log(String log) {
		extentTest.log(LogStatus.INFO, log);
	}
	
	public static void setTestStatus(boolean status, String msg) {
		if (status) {
		extentTest.log(LogStatus.PASS, msg);
		} else {
			extentTest.log(LogStatus.FAIL, msg);
		}
	}
	
	
	public static void endTest() {
		driver.quit();
		extent.endTest(extentTest);
		extent.flush();
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
