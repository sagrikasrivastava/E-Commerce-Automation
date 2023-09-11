package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.constant;
import drivers.DriverSingleton;

public class CartPage {
	private WebDriver driver;

	public CartPage() {
		driver=DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	@FindBy(css = ".checkout-button")
	private WebElement proceedToCheckoutButton;
	
	public void proceedToCheckout() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(constant.TIMEOUT));
		wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutButton));
		proceedToCheckoutButton.click();
	}
}
