package com.economists.testobjects;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.economists.generalutils.log;
import com.economists.pages.EconomistJobPage;
import com.economists.seleniumutils.BasePage;

import org.openqa.selenium.By;

public class EconomistJobPage_TO extends BasePage {

	public EconomistJobPage_TO(WebDriver driver) {
		super(driver, EconomistJobPage.class);
	}

	/*
	 * This method validate the Page Renderation Working Correctly
	 */
	public void checkPageRendering() {
		validateElementVisible(EconomistJobPage.signIn, "Sign-in Link");
		validateElementVisible(EconomistJobPage.createAccount, "Create Account page");
		validateElementVisible(EconomistJobPage.navigationBar, "Navigation bar");
		validateElementVisible(EconomistJobPage.searchField, "Search button");
		validateElementVisible(EconomistJobPage.sectorList, "View sector list");
	}

	/*
	 * This method validate the Navigation bark Working Correctly by getting all
	 * links and using loop validate the expected page is correct
	 */

	public void checkNaviagtionBarLinks() throws InterruptedException {
		List<WebElement> element = EconomistJobPage.navigationList;

		for (int i = 1; i < element.size() - 1; i++) {
			click(element.get(i));
			log.info("Validating actual navigation value  " + getLinkValue(element.get(i)) + "with expected value "
					+ getCurrentUrl());
			Assert.assertEquals(getLinkValue(element.get(i)), getCurrentUrl());
		}
	}

	public void checksigIn_createAccountLinks() throws InterruptedException {
		List<WebElement> element = EconomistJobPage.userLogin;

		for (int i = 0; i < element.size(); i++) {
			click(element.get(i));
			log.info("Validating actual navigation value  " + getLinkValue(element.get(i)) + "with expected value "
					+ getCurrentUrl());
			Assert.assertEquals(getLinkValue(element.get(i)), getCurrentUrl());
		}
	}

	public void validateJobApplyBySector() throws InterruptedException {
		List<WebElement> sectorList = EconomistJobPage.clickBySector;
		for (int i = 0; i < sectorList.size(); i++) {
			clickWithJavaScript(sectorList.get(i));
			clickWithJavaScript(EconomistJobPage.clickDetail);
			validateElementVisible(EconomistJobPage.apply, "Apply button available");
			clickWithJavaScript(EconomistJobPage.Home);
		}

	}

	public void enterSearchDetails(List<List<String>> searchDataRow) throws InterruptedException {
		click(EconomistJobPage.Keyword);
		enterText(EconomistJobPage.Keyword, searchDataRow.get(1).get(0));
		click(EconomistJobPage.location);
		enterText(EconomistJobPage.location, searchDataRow.get(1).get(1));

	}

	public void selectDropdown(String value) throws InterruptedException {

		selectDropdownByValue(EconomistJobPage.RadialLocation, value);
	}

	public void clickButton(String value) throws InterruptedException {
		click(EconomistJobPage.searchField);

	}

	public void validatesearchField() {
		validateElementVisible(EconomistJobPage.serachList, "List is present");

	}

	public boolean invalidSearchField(String expected) {
		String actual = getTextOfWebElement(EconomistJobPage.InvalidSearch);
		if (expected.contains(actual))
			return true;
		else
			return false;
	}

}
