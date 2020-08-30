package com.promise_qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.promise_qa.base.TestBase;
import com.promise_qa.utils.TestUtils;

public class PromisesToPage extends TestBase {

	TestUtils utils = new TestUtils();

	// Page Objects
	@FindBy(name = "cboEmp")
	private WebElement promisorDropDown;

	@FindBy(name = "btnSearch")
	private WebElement searchBtn;

	@FindBy(xpath = "//a[text()='Last>>']")
	private WebElement lastPageBtn;

	@FindBy(xpath = "//b[text()='Promise From']")
	private WebElement promiseFromColumn;

	@FindBy(xpath = "//a[text()='<<First']//preceding::tr[1]//td[3]")
	private WebElement lastColumn;

	// Initialise Page Objects
	public PromisesToPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public void selectPromisor(String name) {
		Select os = new Select(promisorDropDown);
		os.selectByVisibleText(name);
	}

	public void clickOnSearch() {
		utils.waitElementUntilClickable(driver, searchBtn);
		searchBtn.click();
	}

	public String searchPromise() {
		promiseFromColumn.click();
		lastPageBtn.click();
		return lastColumn.getText();

	}
}
