package com.economists.stepdefs;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.economists.hooks.Hooks;
import com.economists.pages.EconomistJobPage;
import com.economists.testobjects.EconomistJobPage_TO;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EconomistJobPageSteps {
	
	EconomistJobPage_TO ejp = new EconomistJobPage_TO(Hooks.driver);
	
	@Then("^validate Navigation Bars, Search field, Sector List,SignIn and Create Account working correctly$")
	public void checkPageRendering()
	{
		ejp.checkPageRendering();
		
	}
	@Then("^user validate the navigation bar links is navigating to correct links$")
	public void checkNavigationBar() throws InterruptedException
	{
		ejp.checkNaviagtionBarLinks();
	}
	@Then("^user validate the Signin and CreateAccount links is navigating to correct pages$")
	public void checksigIn_createAccount() throws InterruptedException
	{
		ejp.checksigIn_createAccountLinks();
	}
	@When("^user click the job by each sector and click view detail button then verify the user is able to apply the job$")
	public void validateJobApplyBySector() throws InterruptedException
	{
		ejp.validateJobApplyBySector();
	}
	 @When("^user fills out the data in search section$")
	 public void enterSearchDetails(DataTable formData) throws InterruptedException
	 {
		 List<List<String>> searchDataRow = formData.raw();
		 ejp.enterSearchDetails(searchDataRow);
	 }
	 
	 @And("^user select the \"([^\"]*)\" from dropdown value$")
	 public void selectDropdown(String value) throws InterruptedException
	 {
		 ejp.selectDropdown(value);
	 }
	 @And("^user \"([^\"]*)\" Search button$")
	 public void clickButton(String value) throws InterruptedException
	 {
		 ejp.clickButton(value);
	 }
	 @Then("^validate search list displayed on page$")
	 public void validatesearchField()
	 {
		 ejp.validatesearchField();
	 }
	 @Then("^validate \"([^\"]*)\" from search page$")
	 public void invalidSearchField(String expected)
	 {
		 ejp.invalidSearchField(expected);
	 }
	 
}