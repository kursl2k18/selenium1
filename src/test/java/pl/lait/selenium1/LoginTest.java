package pl.lait.selenium1;

import org.junit.Before;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertTrue;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.*;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest {
	
	WebDriver driver = null;

	@Before
	public void openPage() {
		driver = Init.getDriver();
	}
	
	
	@Test
	public void clickOnMenuItems() {
		Init.sleep(2);
        driver.findElement(By.linkText("SIGN-ON")).click();
        Init.sleep(1);
        driver.findElement(By.linkText("REGISTER")).click();
        Init.sleep(1);
        driver.findElement(By.linkText("SUPPORT")).click();
        Init.sleep(1);
        driver.findElement(By.linkText("CONTACT")).click();
        Init.sleep(1);
        driver.findElement(By.linkText("SIGN-ON")).click();
        Init.sleep(1);
        driver.findElement(By.name("userName")).sendKeys("adamdz");
        driver.findElement(By.name("password")).sendKeys("qwe123");
        Init.sleep(1);
        driver.findElement(By.name("login")).click();
        Init.sleep(1);
        driver.findElement(By.linkText("SIGN-OFF")).click();
        Init.sleep(1);
        System.out.println("Poszukiwany tytuł okna to:"
        		 + driver.getTitle());
		assertTrue("Tytuł okna jest nieprawidłowy", driver.getTitle().equals("Sign-on: Mercury Tours"));
		
	}
	
	@Ignore
	@Test
	public void reservation() {
		driver.findElement(By.linkText("SIGN-ON")).click();
        driver.findElement(By.name("userName")).sendKeys("adamdz");
        driver.findElement(By.name("password")).sendKeys("qwe123");
        driver.findElement(By.name("login")).click();
		driver.findElement(By.xpath("/html/body/div[1]/table/"
				+ "tbody/tr/td[2]/table/tbody/tr[4]/td/table/"
				+ "tbody/tr/td[2]/table/tbody/tr[5]/td/form/"
				+ "table/tbody/tr[2]/td[2]/b/font/input[2]")).click();
		
		Select passCount = new Select(driver.findElement(By.name("passCount")));
		passCount.selectByValue("2");
		
		Select fromPort = new Select(driver.findElement(By.name("fromPort")));
		fromPort.selectByValue("Frankfurt");
		
		
	}
	
	@After
	public void tearDown() {
		Init.sleep(2);
		Init.endTest();
	}
}
