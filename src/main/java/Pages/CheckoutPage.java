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

public class CheckoutPage {
	private WebDriver driver;
	
	public CheckoutPage() {
		driver=DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "billing_first_name")
	private WebElement firstName;
	@FindBy(id="billing_last_name")
	private WebElement lastname;
	@FindBy(id="billing_last_name")
	private WebElement address;
	@FindBy(id="billing_postcode")
	private WebElement zipCode;
	@FindBy(id="billing_city")
	private WebElement townName;
	@FindBy(css=".order-total > td:nth-child(2)")
	private WebElement totalAmount;
	@FindBy(id="place_order")
	private WebElement placeOrder;
	@FindBy(css=".entry-title")
	private WebElement orderStatus;
	
	public void provideBillingDetails() {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(constant.TIMEOUT));
		wait.until(ExpectedConditions.visibilityOf(address));
		address.sendKeys("abc");
	}
	public String getTotalAmount() {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(constant.TIMEOUT));
		wait.until(ExpectedConditions.visibilityOf(totalAmount));
		return totalAmount.getText();
	}
	
	public void placeOrder() {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(constant.TIMEOUT));
		wait.until(ExpectedConditions.elementToBeClickable(placeOrder));
		placeOrder.click();
	}
}
