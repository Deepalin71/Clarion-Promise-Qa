package com.promise_qa.utils;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.promise_qa.config.Constants;

public class TestUtils {
	WebDriverWait wait;
	File file;

	public void waitElementUntilClickable(WebDriver driver, WebElement element) {

		wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitElementUntilVisible(WebDriver driver, WebElement element) {

		wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT);
		wait.until(ExpectedConditions.visibilityOf(element));

	}
	
	public String getAbsoluteFilePath(String relativePath) {
		file = new File(relativePath);
		return file.getAbsolutePath();
	}
}
