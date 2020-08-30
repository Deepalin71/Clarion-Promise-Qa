package com.promise_qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.promise_qa.base.TestBase;
import com.promise_qa.utils.TestUtils;

public class LogPromisePage extends TestBase {

	TestUtils utils = new TestUtils();

	// Page Objects
	@FindBy(name = "cboEmp")
	private WebElement promicorDropDown;

	@FindBy(id = "txtPromise")
	private WebElement promiseBox;

	@FindBy(id = "btnSubmit")
	private WebElement logPromiseBtn;

	// Initialise Page Objects
	public LogPromisePage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public void selectPromicor(String name) {
		Select os = new Select(promicorDropDown);
		os.selectByVisibleText(name);
	}

	public void enterPromise(String promise) {
		promiseBox.sendKeys(promise);

	}

	public PromisesToPage clickOnLogPromiseBtn() {
		utils.waitElementUntilClickable(driver, logPromiseBtn);
		logPromiseBtn.click();
		return new PromisesToPage();

	}

}
