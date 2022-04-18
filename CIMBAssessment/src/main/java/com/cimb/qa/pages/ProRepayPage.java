package com.cimb.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cimb.qa.base.TestBase;

public class ProRepayPage extends TestBase {

	String amt = prop.getProperty("Amount");
	String tenurepro = prop.getProperty("Tenure");

	// Page Factory -OR
	@FindBy(xpath = "/html/body/div[4]/div/div[2]/div/div[1]/section/div/div[1]/div/div/div/div[1]/div/div/div/div/h3/div/input")
	@CacheLookup
	public WebElement investamount;
	@FindBy(xpath = "/html/body/div[4]/div/div[2]/div/div[1]/section/div/div[1]/div/div/div/div[2]/div/div/div/div/h3/div/input")
	@CacheLookup
	public WebElement tenure;
	@FindBy(xpath = "/html/body/div[4]/div/div[2]/div/div[1]/section/div/div[2]/div/div/div[2]/h3/span[1]")
	@CacheLookup
	public WebElement EffectiveInterestRate;
	@FindBy(xpath = "/html/body/div[4]/div/div[2]/div/div[1]/section/div/div[2]/div/div/div[3]/h3/span[2]")
	@CacheLookup
	public WebElement TotalInterestPayable;
	@FindBy(xpath = "/html/body/div[4]/div/div[2]/div/div[1]/section/div/div[2]/div/div/div[4]/h3/span[2]")
	@CacheLookup
	public WebElement TotalAmountPayable;
	@FindBy(xpath = "//*[@class=\"table-content ignoreMobileRightPadding\"]/div[1]/table/tbody/tr")
	@CacheLookup
	public List<WebElement> Tablerow;

	// Initializing the Page Objects:
	public ProRepayPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String validateProRapayPageTitle() {
		return driver.getTitle();
	}

	public void validateProRepay() {

		investamount.sendKeys(amt);
		tenure.sendKeys(tenurepro);
		String EffInstRate = EffectiveInterestRate.getText();
		String TotInstPayable = TotalInterestPayable.getText();
		String TotAmtPayable = TotalAmountPayable.getText();
		  if ( EffInstRate != null && TotInstPayable != null &&  TotAmtPayable != null ) {
			  System.out.println("Values populted as expected");
		  }else System.out.println("Please check");
		  int count = Tablerow.size();
		  System.out.println("ROW COUNT : "+count);
		  if ( count == 9 ) {
			  System.out.println("Number of rows matching input tenure");
		  }else System.out.println("Please check");

	}

}
