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

public class PromiseToPageTest extends TestBase {

	LandingPage landingPage;
	LoginPage loginPage;
	LogPromisePage logPromise;
	PromisesToPage promiseTo;

	public PromiseToPageTest() {
		super();
	}

	//Initialise the driver and navigate to promiseTo page
	@Parameters("browser")
	@BeforeMethod
	public void setup(String browserName) {

		initialization(browserName);
		loginPage = new LoginPage();
		loginPage.enterUsername(prop.getProperty("Username"));
		loginPage.enterPasword(prop.getProperty("Password"));
		landingPage = loginPage.clickOnLoginButton();
		promiseTo = landingPage.clickOnPromisesTo();

	}

	@Test(description = "Verify the promise which we added earlier",dependsOnGroups = "AddPromise")
	public void verifyAddedPromise() {
		
		promiseTo.selectPromisor(prop.getProperty("PromisorName"));
		promiseTo.clickOnSearch();
		String actualPromise = promiseTo.searchPromise();
		Assert.assertEquals(actualPromise, prop.getProperty("PromiseValue"), "Promise didnot added");

	}

	// Closing the browser
	@AfterMethod
	public void tearDown() {
		closeDriver(driver);

	}

}
