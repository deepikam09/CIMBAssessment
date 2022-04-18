package com.cimb.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cimb.qa.base.TestBase;
import com.cimb.qa.pages.HomePage;
import com.cimb.qa.pages.IndexPage;
import com.cimb.qa.pages.ProRepayPage;
import com.cimb.qa.pages.ToolsPage;

public class TestCase2 extends TestBase {

	public IndexPage indexpage;
	public ToolsPage toolspage;
	public ProRepayPage prorepayPage;
	String indexurl = prop.getProperty("urlindex");

	public TestCase2() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		setUrl(indexurl);
		indexpage = new IndexPage();
	}

	@Test(priority = 1)
	public void GotoProRepay() {
		String indexPageTitle = indexpage.validateIndexPageTitle();
		Assert.assertEquals(indexPageTitle, "Personal Banking | Savings, Credit Cards and Loans | CIMB SG");
		toolspage = indexpage.gototoolspage();
		String toolsPageTitle = toolspage.validateToolsPageTitle();
		Assert.assertEquals(toolsPageTitle, "Tools | CIMB Finance Tools | CIMB SG");
		prorepayPage = toolspage.Gototraveldeals();
		String prorepaytitle = prorepayPage.validateProRapayPageTitle();
		Assert.assertEquals(prorepaytitle, "Property Loan Repayment Calculator | Tools | CIMB SG");
		prorepayPage.validateProRepay();
		
	}

	@AfterMethod
	public void tearDown() {
		 driver.quit();
	}
}
