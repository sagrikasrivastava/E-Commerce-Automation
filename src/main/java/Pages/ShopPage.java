package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.Util;
import Utils.constant;
import drivers.DriverSingleton;

public class ShopPage {
	private WebDriver driver;

	public ShopPage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "ul.page-numbers > li:nth-child(3) > a:nth-child(1)")
	private WebElement goToPageThree;
	@FindBy(css = "li.product:nth-child(4) > a:nth-child(2)")
	private WebElement addToCartButton;
	@FindBy(css = "div.wb4wp-custom-actions:nth-child(1) > a:nth-child(1) > span:nth-child(2)")
	private WebElement numberOfProductsInCart;
	@FindBy(css = "div.wb4wp-custom-actions:nth-child(1) > a:nth-child(1)")
	private WebElement cartButton;

	public void goToProductPage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(constant.TIMEOUT));
		wait.until(ExpectedConditions.elementToBeClickable(goToPageThree));
		goToPageThree.click();
	}

	public void addProductToCart() {
		addToCartButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(constant.TIMEOUT));
		wait.until(ExpectedConditions.visibilityOf(numberOfProductsInCart));
	
		if (numberOfProductsInCart.getText().contains(constant.CART_QUANTITY))
			System.out.println("Cart has been updated");
		else {
			System.out.println("Cart has not been updated");
			Util.takeScreenshot();
		}
	}

	public void proceedToCheckout() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(constant.TIMEOUT));
		wait.until(ExpectedConditions.elementToBeClickable(cartButton));

		cartButton.click();
	}
}
