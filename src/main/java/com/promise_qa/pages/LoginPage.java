package com.promise_qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.promise_qa.base.TestBase;
import com.promise_qa.utils.TestUtils;

public class LoginPage extends TestBase {

	TestUtils utils = new TestUtils();

	// Page Objects
	@FindBy(xpath = "//input[@type='Submit']")
	private WebElement loginBtn;

	@FindBy(xpath = "//table//tr[3]/td/font")
	private WebElement errorMsg;

	@FindBy(name = "txtUsername")
	private WebElement usrNameField;

	@FindBy(name = "txtPassword")
	private WebElement pswdField;

	// Initialise Page Objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public LandingPage clickOnLoginButton() {
		utils.waitElementUntilClickable(driver, loginBtn);
		loginBtn.click();
		return new LandingPage();
	}

	public String getBlankFieldErrorMsg() {
		return errorMsg.getText();
	}

	public void enterUsername(String name) {
		utils.waitElementUntilVisible(driver, usrNameField);
		usrNameField.sendKeys(name);
	}

	public void enterPasword(String pswd) {
		utils.waitElementUntilVisible(driver, usrNameField);
		pswdField.sendKeys(pswd);
	}

	public String getPageUrl() {
		return driver.getCurrentUrl();
	}

}
