package drivers.strategies;

import Utils.constant;

public class DriverStrategyImplementer {

	public static DriverStrategy chooseStrategy(String strategy) {
		switch (strategy) {
		case constant.CHROME:
			return new Chrome();
		case constant.FIREFOX:
			return new Firefox();
		default:
			return null;
		}
	}
	
}
