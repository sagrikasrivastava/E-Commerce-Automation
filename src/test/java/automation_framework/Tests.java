package automation_framework;

import java.time.Duration;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.CheckoutPage;
import Pages.HomePage;
import Pages.ShopPage;
import Pages.SignInPage;
import Utils.FrameworkProperties;
import Utils.constant;
import drivers.DriverSingleton;

public class Tests {
	static FrameworkProperties frameworkProperties;
	static WebDriver driver;
	static HomePage homePage;
	static SignInPage signInPage;
	static CheckoutPage checkoutPage;
	static ShopPage shopPage;

	@BeforeAll
	public static void initializeObjects() {
		frameworkProperties = new FrameworkProperties();
		DriverSingleton.getInstance(frameworkProperties.getProperty(constant.BROWSER));
		driver = DriverSingleton.getDriver();
		homePage = new HomePage();
		shopPage = new ShopPage();
		signInPage = new SignInPage();
		checkoutPage = new CheckoutPage();
	}

	@Test
	public void testingAuthentication() {
		driver.get(constant.URL);
		homePage.clickSignIn();
		signInPage.logIn(frameworkProperties.getProperty(constant.EMAIL),
				frameworkProperties.getProperty(constant.PASSWORD));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(constant.TIMEOUT));
		wait.until(ExpectedConditions.invisibilityOf(homePage.getSideBar()));

		Assertions.assertEquals(frameworkProperties.getProperty(constant.USERNAME), homePage.getUserName());
	}
	@Test
	public void addItemToCart() {
		homePage.clickShopButton();
		shopPage.goToProductPage();
		shopPage.addProductToCart();
		
	}

	@AfterAll
	public static void closeObjects() {
		driver.quit();
	}
}
