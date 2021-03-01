package com.economists.seleniumutils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.economists.generalutils.log;

public class BasePage {

	protected WebDriver driver;
	protected WebDriverWait wait;

	@SuppressWarnings("unchecked")
	public BasePage(WebDriver driver, Class aClass) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageFactory.initElements(driver, aClass);
		wait = new WebDriverWait(driver, 30);
	}

	public List<String> getTextOfWebElement(List<WebElement> webElement) {
		List<String> webElementsText = new ArrayList<String>();
		System.out.println("The size is" + webElement.size());
		for (WebElement ele : webElement)
			webElementsText.add(ele.getText().trim());
		log.info("Getting text from a webElement, text is: " + webElementsText);
		return webElementsText;
	}

	public void validateTextOfWebElement(WebElement webElement, String expected) {
		String webElementsText = webElement.getText();
		log.info("Getting text from a webElement, text is: " + webElementsText);
		Assert.assertEquals("Field Matched: ", webElementsText, expected);

	}

	public String getTextOfWebElement(WebElement webElement) {
		String webElementsText = webElement.getText();
		return webElementsText;

	}

	public void validateElementEnabled(WebElement element, String Fieldname) {
		Assert.assertTrue("Field Not Enabled : " + Fieldname, element.isEnabled());
	}

	public void click(WebElement webElement) throws InterruptedException {
		log.info("----Clicking on a webElement");
		// waitElementLocated(webElement, 4000);
		webElement.click();
	}

	public void clickWithJavaScript(WebElement element) {
		// waitElementLocated(element, 90);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public boolean waitElementLocated(WebElement element, int timeOutInSeconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.until(ExpectedConditions.visibilityOf(element));

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void acceptAlertPopUp() {

		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();

	}

	public void setTimeout(int timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}

	public void enterText(WebElement element, String val) {
		log.info("----Clearing, then sending keys: " + val);
		// scrollToElement(element);
		element.clear();
		// waitElementLocated(element,60);
		element.sendKeys(val);
	}

	public void setSleepTime(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			return;
		}
	}

	public String generateStringFromResource(String path) throws IOException {

		return new String(Files.readAllBytes(Paths.get(path)));

	}

	public void validateElementVisible(WebElement element, String Fieldname) {
		Assert.assertTrue("Field Not Visible : " + Fieldname, element.isDisplayed());
	}

	// get link value from webelement
	public String getLinkValue(WebElement element) {
		log.info("getting attribute value from a webelement");
		waitElementLocated(element, 60);
		return element.getAttribute("href");
	}

	/** get current page url */
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public void selectDropdownByValue(WebElement element, String val) throws InterruptedException {
		log.info("selecting drop down by value with custom wait");
		Select select = new Select(element);
		int number_of_options = select.getOptions().size();
		int i = 1;

		while (number_of_options <= 1 && i < 60) {
			Thread.sleep(500);
			i++;
			number_of_options = select.getOptions().size();
		}
		select.selectByValue(val);
	}
}
