package com.cimb.qa.pages;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cimb.qa.base.TestBase;

public class ToolsPage extends TestBase {

	
	//Page Factory -OR
		@FindBy(xpath = "//*[@class=\"tool-listing          \"]/div/div/div/article[5]/a/h3")
		@CacheLookup
		public WebElement propertyRepay;
		
	
		// Initializing the Page Objects:
				public ToolsPage() {
					PageFactory.initElements(driver, this);
				}
			// Actions:
			public String validateToolsPageTitle() {   
				return driver.getTitle();
			}
			public ProRepayPage Gototraveldeals() {

				propertyRepay.click();
				ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
			    driver.switchTo().window(tabs2.get(0));
			    driver.close();
			    driver.switchTo().window(tabs2.get(1));
				return new ProRepayPage();
				
			}
}
