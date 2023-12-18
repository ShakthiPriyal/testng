package com.testng.pages;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import com.testng.base.BasePage;

import junit.framework.Assert;
import org.openqa.selenium.support.ui.Select;


public class SalesforceOppurtunitiesPage extends BasePage{
	WebDriver driver;
	
	public SalesforceOppurtunitiesPage(WebDriver driver) {
		super(driver);

}
	//Identifying webelements
	
	//TC15
			@FindBy(id="username")
			WebElement Username;
			
			@FindBy(id="password")
			WebElement password;
			
			@FindBy(id="Login")
			WebElement loginbtn;
			
			//click oppurtunities tab
			
			@FindBy(xpath="//a[text()='Opportunities']")
					WebElement oppurtunitytab;
			
			//verifying opportunity dropdown in base page
			//click on new button
			@FindBy(name="new")
					WebElement newbutton;
			
			@FindBy(id="opp3")
					WebElement oppnametextbox;
			
			@FindBy(xpath="//a[@tabindex='7']")
			WebElement closedate;
			
			@FindBy(id="opp11")
			WebElement stagedropdown;
		           @FindBy(id="opp6")
		           WebElement  leadsourcedropdown;
		
				

					
			
			@FindBy(xpath="//a[text()='Opportunity Pipeline']")
					WebElement reportlink;
			
			@FindBy(xpath="//a[text()='Stuck Opportunities']")
					WebElement stuckopplink;
			
			@FindBy(name="go")
					WebElement quartsummaryrunbtn;
		

			
			
			//Actions of webelement
			//Tc15
			
			public void enterintoUsername(String strusername) {
				waitforElement(Username);
				Username.sendKeys(strusername);
			}
			
			public void enterintoPassword(String strpassword) {
				password.sendKeys(strpassword);
			}
			
			public void clicklogin() {
				loginbtn.click();
			}
			public void clickonOppurtunityTab() {
				oppurtunitytab.click();
			}
			//verifying in base page
			public void clickonNewButton() {
				newbutton.click();
			}

			public void enterintoOpportunitytextbox(String stropptextbox) {
				waitforElement(oppnametextbox);
				oppnametextbox.sendKeys(stropptextbox);
				
			}
			public void clickonCloseButton() {
				closedate.click();
			}
			//SELECTBYVISIBLETEXT

			public  void selectByVisibleTextQual(String strvisibletext) {
				waitforElement(stagedropdown);
			Select selectdrpdwn= new Select(stagedropdown);

			selectdrpdwn.selectByVisibleText(strvisibletext);
			}
			
			public  void selectByVisibleTextWeb(String strvisibletext) {
				waitforElement(leadsourcedropdown);
			Select selectdrpdwn= new Select(leadsourcedropdown);

			selectdrpdwn.selectByVisibleText(strvisibletext);
			}
			
			public void clickonReportLink() {
				reportlink.click();
			}
			public void clickonStuckOppLink() {
			stuckopplink.click();
			}
			public void clickonQuartSummary() {
			quartsummaryrunbtn.click();
}}