package pl.lait.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pl.lait.selenium1.Init;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(name = "userName")
	WebElement loginInput;
	
	@FindBy(name = "password")
	WebElement passwordInput;
	
	@FindBy(name = "login")
	WebElement loginBtn;
	
	@FindBy(linkText = "SIGN-ON")
	WebElement signOnLink;
	
	public LoginPage() {
		driver = Init.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	public void goToLoginPage() {
		signOnLink.click();
	}
	
	public void loginAs(String login, String password) {
		loginInput.sendKeys(login);
		passwordInput.sendKeys(password);
		loginBtn.click();
	}

}
