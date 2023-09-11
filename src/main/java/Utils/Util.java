package Utils;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import drivers.DriverSingleton;

public class Util {

	public static String decode64 (String encodedStr) {
		Base64.Decoder decoder=Base64.getDecoder();
		return new String(decoder.decode(encodedStr.getBytes()));
	}
	
	public static boolean takeScreenshot() {
		File file=((TakesScreenshot)DriverSingleton.getDriver()).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(file, new File("C:\\Users\\utkarsh\\Desktop\\screenshot"+UUID.randomUUID().toString()+".png"));
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
	}
}


