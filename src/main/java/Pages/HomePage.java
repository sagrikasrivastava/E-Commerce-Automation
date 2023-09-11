package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import drivers.DriverSingleton;

public class HomePage {
	private WebDriver driver;

	public HomePage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#menu-item-747 > a:nth-child(1)")
	private WebElement logInButton;
	@FindBy(css = "#menu-item-752 > a:nth-child(1)")
	private WebElement shopButton;
	@FindBy(css = "#menu-item-750 > a:nth-child(1)")
	private WebElement userName;
	@FindBy(className = "xoo-el-sidebar")
	private WebElement sideBar;

	public WebElement getSideBar() {
		return sideBar;
	}


	public void clickSignIn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(logInButton));
		logInButton.click();
	}

	public void clickShopButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(shopButton));
		shopButton.click();
	}
	public String getUserName() {
		return userName.getText();
	}
}
