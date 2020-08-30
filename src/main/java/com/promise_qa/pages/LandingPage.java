package com.promise_qa.pages;

import org.openqa.selenium.WebElement;

import com.promise_qa.base.TestBase;
import com.promise_qa.pages.LandingPage;
import com.promise_qa.pages.LoginPage;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.promise_qa.utils.TestUtils;

public class LandingPage extends TestBase {

	TestUtils utils = new TestUtils();

	// Page Objects
	@FindBy(xpath = "//a[text()='Log Promise']")
	private WebElement logPromiseLink;

	@FindBy(xpath = "//a[@class='lightgrey'][3]")
	private WebElement logoutBtn;

	@FindBy(xpath = "//a[text()='Promises To']")
	private WebElement promisesToLink;

	// Initialise Page Objects
	public LandingPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public LogPromisePage clickOnLogPromise() {

		utils.waitElementUntilClickable(driver, logPromiseLink);
		logPromiseLink.click();
		return new LogPromisePage();

	}

	public LoginPage clickOnLogoutBtn() {

		utils.waitElementUntilClickable(driver, logoutBtn);
		logoutBtn.click();
		return new LoginPage();

	}

	public String getPageUrl() {
		return driver.getCurrentUrl();
	}

	public PromisesToPage clickOnPromisesTo() {

		utils.waitElementUntilClickable(driver, promisesToLink);
		promisesToLink.click();
		return new PromisesToPage();

	}

}
