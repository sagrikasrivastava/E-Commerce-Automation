package automation_framework.glue;

import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import Pages.CheckoutPage;
import Pages.HomePage;
import Pages.SignInPage;
import Utils.ConfigurationProperties;
import Utils.constant;
import config.AutomationFrameworkConfiguration;
import drivers.DriverSingleton;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@ContextConfiguration (classes = AutomationFrameworkConfiguration.class)
public class StepDefinition {
	private WebDriver driver;
	private HomePage homePage;
	private SignInPage signInPage;
	private CheckoutPage checkOutPage;
	
	@Autowired
	ConfigurationProperties configurationProperties;
	
	@Before
	public void initializeObjects() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		homePage=new HomePage();
		signInPage=new SignInPage();
		checkOutPage=new CheckoutPage();
	}
	
	@Given("^I go to the Website")
	public void i_go_to_the_website() {
		driver= DriverSingleton.getDriver();
		driver.get(constant.URL);
	}
	
	@When ("^I click on Sign In button")
	public void i_click_on_sign_in_button() {
		homePage.clickSignIn();
	}
	
	@And ("^I specify my credentials and click Login")
	public void i_specify_my_credentials_and_click_login() {
		signInPage.logIn(configurationProperties.getEmail(), configurationProperties.getPassword());
	}
	
	@Then ("^I can log into the website")
	public void i_can_log_into_the_website() {
		Assert.assertEquals(configurationProperties.getUsername(), homePage.getUserName());
	}
}
