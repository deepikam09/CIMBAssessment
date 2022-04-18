package com.cimb.qa.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cimb.qa.base.TestBase;

public class HomePage extends TestBase {
//Page Factory -OR
	@FindBy(xpath = "//*[@class=\"main-global-header\"]/div[1]/div/div[1]/div[1]")
	@CacheLookup
	public WebElement SideMenu;
	@FindBy(xpath = "//*[@class=\"main-global-header\"]/div[2]/div[1]/div/nav[6]/a[3]")
	@CacheLookup
	public WebElement CIMBDeals;
	@FindBy(xpath = "/html/body/app/main/home-page/div/app-header/header/div[2]/category-menu/div/ul/li[5]/div")
	public WebElement TravelLifeStyles;
	@FindBy(xpath = "/html/body/app/main/home-page/div/app-header/header/div[2]/category-menu/div[3]/div[3]/div/div[4]/div[1]")
	public WebElement Travelsearch;
	@FindBy(xpath = "//img[@class=\\\"card-img-top\\\"]")
	public List<WebElement> specificdeal;

	// Initializing the Page Objects:
		public HomePage() {
			PageFactory.initElements(driver, this);
		}
	// Actions:
	public String validateHomePageTitle() {   
		return driver.getTitle();
	}

	public DealsPage gotodealspage() {
		Actions action = new Actions(driver);
		action.doubleClick().perform();
		SideMenu.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		CIMBDeals.click();
		return new DealsPage(); 
	}
	
	

}
