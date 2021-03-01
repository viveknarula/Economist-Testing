package com.economists.testrunner;

import org.apache.log4j.BasicConfigurator;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = { "com.economists.stepdefs",
		"com.economists.hooks" }, plugin = {
				"json:Reports/JSON/cucumber.json", "com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:Reports/HTMLReport/report.html" }, tags = "@functionalUIEconomist")
public class GenericRunner {
	public static void main(String[] args) throws Exception {
		BasicConfigurator.configure();
		JUnitCore.main("com.economists.testrunner.GenericRunner");
	}
}