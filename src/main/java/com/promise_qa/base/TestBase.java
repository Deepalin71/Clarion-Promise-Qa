package com.promise_qa.base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.promise_qa.config.Constants;
import com.promise_qa.utils.TestUtils;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	InputStream inputStream;
	TestUtils utils=new TestUtils();
	int i=0;

	// Read config file
	public TestBase() {
		try {

			prop = new Properties();
			String config = "com/promise_qa/config/CONFIG.properties";
			inputStream = getClass().getClassLoader().getResourceAsStream(config);

			prop.load(inputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		catch (IOException e) {
			e.printStackTrace();
		}

	}

	// Initialise browser
	public static void initialization(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "Driver/chromedriver");
			driver = new ChromeDriver();

		} else {
			System.out.println("Unsupported Browser");
			System.exit(1);

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("Url"));
	}

	//Take screenshot method
	public void failed(String testMethodName) {
		File fc = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination = new File(utils.getAbsoluteFilePath("test-output/screenshots/"+testMethodName+"_"+i+".png"));
		try {
			FileUtils.copyFile(fc, destination);
		} catch (IOException e) {
			e.getMessage();
		}
		i++;

	}
	
	// Closing the browser
	public void closeDriver(WebDriver driver) {

		if (driver != null) {

			driver.close();

		}
	}

}