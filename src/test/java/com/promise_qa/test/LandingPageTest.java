package com.promise_qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.promise_qa.base.TestBase;
import com.promise_qa.pages.LandingPage;
import com.promise_qa.pages.LogPromisePage;
import com.promise_qa.pages.LoginPage;
import com.promise_qa.pages.PromisesToPage;

public class LandingPageTest extends TestBase {

	LandingPage landingPage;
	LoginPage loginPage;
	LogPromisePage logPromise;
	PromisesToPage promiseTo;

	public LandingPageTest() {
		super();
	}

	// Initialise the driver and login
	@Parameters("browser")
	@BeforeMethod
	public void setup(String browserName) {
		initialization(browserName);

		loginPage = new LoginPage();
		loginPage.enterUsername(prop.getProperty("Username"));
		loginPage.enterPasword(prop.getProperty("Password"));
		landingPage = loginPage.clickOnLoginButton();

	}

	@Test(description = "Add Promise", dependsOnGroups = "Login", groups = "AddPromise")
	public void addPromise() {

		logPromise = landingPage.clickOnLogPromise();
		logPromise.selectPromicor(prop.getProperty("PromisorName"));
		logPromise.enterPromise(prop.getProperty("PromiseValue"));
		promiseTo = logPromise.clickOnLogPromiseBtn();

	}

	@Test(description = "Verify Logout", dependsOnGroups = "Login")
	public void verifyLogout() {

		loginPage = landingPage.clickOnLogoutBtn();
		String actualUrl = loginPage.getPageUrl();
		Assert.assertEquals(actualUrl, prop.getProperty("Url"), "Unable to logout");

	}

	// Closing the browser
	@AfterMethod
	public void tearDown() {
		closeDriver(driver);

	}

}
