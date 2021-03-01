package com.economists.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class EconomistJobPage {

	@FindBy(xpath = "//*[text()='Sign in']")
	public static WebElement signIn;

	@FindBy(xpath = "//*[text()='Create account']")
	public static WebElement createAccount;

	@FindBy(xpath = "//*[@id='primary-nav']")
	public static WebElement navigationBar;

	@FindBy(xpath = "//*[@value='Search']")
	public static WebElement searchField;

	@FindBy(xpath = "//*[@class='browse brick']")
	public static WebElement sectorList;

	@FindBy(xpath = "//*[@id='listing']/li")
	public static WebElement serachList;

	@FindBy(xpath = "//*[@id='searching']")
	public static WebElement InvalidSearch;

	@FindAll(@FindBy(xpath = "//*[@id='primary-nav']/div/ul/li/a"))
	public static List<WebElement> navigationList;

	@FindAll(@FindBy(xpath = "//*[@class='jobseekers__items cf']/li/a"))
	public static List<WebElement> userLogin;

	@FindAll(@FindBy(xpath = "//*[@data-tinynav-header='Choose a Sector']/li/a"))
	public static List<WebElement> clickBySector;

	@FindBy(xpath = "(//*[text()='View details '])[1]")
	public static WebElement clickDetail;

	@FindBy(xpath = "//*[@class='job-actions__action job-actions__action--applylink']")
	public static WebElement apply;

	@FindBy(xpath = "(//*[@class='primary-nav__link'])[1]")
	public static WebElement Home;

	@FindBy(xpath = "//*[@class='job-pagination__link icon-before']")
	public static WebElement Back;

	@FindBy(xpath = "//*[@id='keywords']")
	public static WebElement Keyword;

	@FindBy(xpath = "//*[@name='radialtown']")
	public static WebElement location;

	@FindBy(xpath = "//*[@id='RadialLocation']")
	public static WebElement RadialLocation;

}
