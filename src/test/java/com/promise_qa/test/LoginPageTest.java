package com.promise_qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.promise_qa.base.TestBase;
import com.promise_qa.pages.LandingPage;
import com.promise_qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	LandingPage landingPage;

	public LoginPageTest() {
		super();
	}

	// Initialise the driver and navigate to url
	@Parameters("browser")
	@BeforeMethod
	public void setup(String browserName) {

		initialization(browserName);
		loginPage = new LoginPage();

	}

	@Test(description = "Verify error message when login without any credentials", priority = 1)
	public void validationLoginErrorMsg() {

		loginPage.clickOnLoginButton();
		String actualError = loginPage.getBlankFieldErrorMsg();
		Assert.assertEquals(actualError, prop.getProperty("BlankFieldErrorMsg"), "Wrong error message display");
	}

	@Test(description = "Validate login with correct credentials", priority = 2, groups = "Login")
	public void validateLogin() {
		loginPage.enterUsername(prop.getProperty("Username"));
		loginPage.enterPasword(prop.getProperty("Password"));
		landingPage = loginPage.clickOnLoginButton();

		String actualUrl = landingPage.getPageUrl();
		Assert.assertEquals(actualUrl, prop.getProperty("LandingPageUrl"), "Unable to login ");

	}

	// Closing the browser
	@AfterMethod
	public void tearDown() {
		closeDriver(driver);

	}

}
