package com.cimb.qa.testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cimb.qa.base.TestBase;
import com.cimb.qa.pages.AirasiaappPage;
import com.cimb.qa.pages.DealsPage;
import com.cimb.qa.pages.HomePage;
import com.cimb.qa.util.TestUtil;

public class TestCase1 extends TestBase {
	public DealsPage dealspage;
	public HomePage homePage;
	public AirasiaappPage airasiadeal;
	String homeurl = prop.getProperty("urlhome");

	// test cases should be separated -- independent with each other
	// before each test case -- launch the browser
	// @test -- execute test case
	// after each test case -- close the browser
	public TestCase1() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		setUrl(homeurl);
		homePage = new HomePage();
	}

	@Test(priority = 1)
	public void Gotospecificdeal() {
		String homePageTitle = homePage.validateHomePageTitle();
		Assert.assertEquals(homePageTitle, "Personal Banking | Savings, Credit Cards and Loans | CIMB");
		System.out.println("HomePage Loaded: Passed");
		dealspage = homePage.gotodealspage();
		String dealsPageTitle = dealspage.validateDealsPageTitle();
		Assert.assertEquals(dealsPageTitle, "CIMB Deals");
		airasiadeal = dealspage.Gototraveldeals();
		String airasiatitle = airasiadeal.validateaRidePageTitle();
		Assert.assertEquals(airasiatitle, "RM3 OFF ride on airasia Super App");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
