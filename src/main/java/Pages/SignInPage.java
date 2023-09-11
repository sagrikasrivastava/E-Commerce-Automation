package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.Util;
import drivers.DriverSingleton;

public class SignInPage {
	private WebDriver driver;

	public SignInPage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".xoo-el-username_cont > div:nth-child(1) > input:nth-child(2)")
	private WebElement signInEmail;
	@FindBy(css = ".xoo-el-password_cont > div:nth-child(1) > input:nth-child(2)")
	private WebElement signInPassword;
	@FindBy(css = ".xoo-el-login-btn")
	private WebElement signInButton;

	public void logIn (String email,String Password) {
		signInEmail.sendKeys(email);
		signInPassword.sendKeys(Util.decode64(Password));
		signInButton.click();
	}
}
