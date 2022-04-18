package com.cimb.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cimb.qa.base.TestBase;

public class AirasiaappPage extends TestBase {
	// Page Factory -OR
	@FindBy(xpath = "/html/body/app/main/deal-detail-page/div/main/div[1]/div/div[2]/div[2]/p[2]")
	@CacheLookup
	public WebElement airasiaTitle;

	// Initializing the Page Objects:
	public AirasiaappPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateaRidePageTitle() {
		System.out.println(driver.getTitle());
		return airasiaTitle.getText();

	}

}
