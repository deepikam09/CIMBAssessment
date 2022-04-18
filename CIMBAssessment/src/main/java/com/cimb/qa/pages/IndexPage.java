package com.cimb.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cimb.qa.base.TestBase;

public class IndexPage extends TestBase{
	
	//Page Factory -OR
		@FindBy(xpath = "//div[@class=\"main-global-header\"]/div[1]/div/div[1]/div[1]")
		@CacheLookup
		public WebElement SideMenu;
		@FindBy(xpath = "//*[@class=\"main-global-header\"]/div[2]/div[1]/div/nav[6]/a[1]")
		@CacheLookup
		public WebElement CIMBTools;
	
		// Initializing the Page Objects:
				public IndexPage() {
					PageFactory.initElements(driver, this);
				}
			// Actions:
			public String validateIndexPageTitle() {   
				return driver.getTitle();
			}
			
			public ToolsPage gototoolspage() {
				
				SideMenu.click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				CIMBTools.click();
				return new ToolsPage(); 
			}

}
