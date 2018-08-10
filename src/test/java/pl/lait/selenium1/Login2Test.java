package pl.lait.selenium1;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pl.lait.pageObjects.LoginPage;
import pl.lait.pageObjects.Reservation2Page;
import pl.lait.pageObjects.ReservationPage;

@Ignore
public class Login2Test {
	
	WebDriver driver;
	
	@Before
	public void openPage() {
		driver = Init.getDriver();
	}
	
	@Test
	public void loginWithPageObject() {
		LoginPage loginPage = new LoginPage();
		loginPage.goToLoginPage();
		
		loginPage.loginAs("adamdz", "qwe123");
		
		ReservationPage reservPage = new ReservationPage();
		reservPage.fillTheReservationForm();
		
		Reservation2Page reserv2Page = new Reservation2Page();
		reserv2Page.chooseFlights();
		
	}
	
	@After
	public void tearDown() {
		Init.endTest();
	}

}
