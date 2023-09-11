package drivers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import drivers.strategies.DriverStrategy;
import drivers.strategies.DriverStrategyImplementer;

public class DriverSingleton {
	private static DriverSingleton instance = null;
	private static WebDriver driver;

	private DriverSingleton(String driver) {
		instanciate(driver);
	}

	@SuppressWarnings("deprecation")
	public WebDriver instanciate(String strategy) {
		DriverStrategy driverStrategy = DriverStrategyImplementer.chooseStrategy(strategy);
		driver = driverStrategy.setStrategy();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}

	public static DriverSingleton getInstance(String driver) {
		if (instance == null) {
			instance = new DriverSingleton(driver);
		}
		return instance;
	}

	public static void closeObjectInstance() {
		instance=null;
		driver.quit();
	}
	public static WebDriver getDriver() {
		return driver;
	}
}
