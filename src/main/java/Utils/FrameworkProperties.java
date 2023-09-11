package Utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FrameworkProperties {
	private String result = "";
	private InputStream inputStream;

	public String getProperty(String key) {
		try {
			Properties properties = new Properties();
			String propFileName = constant.PROP_FILE_NAME;

			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			if (inputStream != null)
				properties.load(inputStream);
			else
				throw new FileNotFoundException(constant.FILE_NOT_FOUND_EXCEPTION_MESSAGE);
			String propertyVlaue = properties.getProperty(key);
			this.result = propertyVlaue;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
