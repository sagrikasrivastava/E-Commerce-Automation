
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.HomePage;
import Pages.ShopPage;
import Pages.SignInPage;
import Utils.FrameworkProperties;
import Utils.constant;
import drivers.DriverSingleton;

public class Main {

	public static void main(String[] args) {
		FrameworkProperties frameworkProperties = new FrameworkProperties();
		DriverSingleton driverSingleton = DriverSingleton.getInstance(frameworkProperties.getProperty("browser"));
		WebDriver driver = DriverSingleton.getDriver();
		driver.get("https://bitheap.tech/");

		HomePage homePage = new HomePage();
		SignInPage signInPage = new SignInPage();
		ShopPage shopPage = new ShopPage();
		CartPage cartPage = new CartPage();
		CheckoutPage checkoutPage = new CheckoutPage();

		homePage.clickSignIn();
		signInPage.logIn(frameworkProperties.getProperty(constant.EMAIL),frameworkProperties.getProperty(constant.PASSWORD) );
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(constant.TIMEOUT));
		wait.until(ExpectedConditions.invisibilityOf(homePage.getSideBar()));

		if (homePage.getUserName().equals("Hello, Laurentiu"))
			System.out.println("Test Passed");
		else
			System.out.println("Test Failed");

		homePage.clickShopButton();
		shopPage.goToProductPage();
		shopPage.addProductToCart();
		shopPage.proceedToCheckout();
		cartPage.proceedToCheckout();
		checkoutPage.provideBillingDetails();

		wait = new WebDriverWait(driver, Duration.ofSeconds(constant.TIMEOUT));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".blockUI.blockOverlay")));
		checkoutPage.placeOrder();

		driver.quit();
	}
}
