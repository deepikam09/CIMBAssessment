package com.cimb.qa.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cimb.qa.base.TestBase;

public class DealsPage extends TestBase {

	@FindBy(xpath = "/html/body/app/main/home-page/div/app-header/header/div[2]/category-menu/div/ul/li[5]/div")
	public WebElement TravelLifeStyles;
	@FindBy(xpath = "/html/body/app/main/home-page/div/app-header/header/div[2]/category-menu/div[3]/div[3]/div/div[4]/div[1]")
	public WebElement Travelsearch;
	@FindBy(xpath = "//img[@class=\"card-img-top\"]")
	public List<WebElement> specificdeal;

	// Initializing the Page Objects:
	public DealsPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String validateDealsPageTitle() {
		return driver.getTitle();
	}

	public AirasiaappPage Gototraveldeals() {

		TravelLifeStyles.click();
		Travelsearch.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		int cr = specificdeal.size();
		System.out.println(cr);
		for (int i = 0; i < 3; i++)

		{
			WebElement Contest_Name = specificdeal.get(i);
			if (i == 2) {
				Contest_Name.click();
				System.out.println(driver.getTitle());
			}
		}
		return new AirasiaappPage();
		
	}
}
