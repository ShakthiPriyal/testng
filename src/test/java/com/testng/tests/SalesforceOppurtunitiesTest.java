package com.testng.tests;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;
import java.util.*;
import com.testng.base.BaseTest;
import com.testng.log.Log;
import com.testng.base.BaseTest;
import com.testng.pages.SalesforceOppurtunitiesPage;
import com.testng.pages.SalesforceUserMenuPage;
import com.testng.pages.SalesforceLoginPage;

public class SalesforceOppurtunitiesTest extends BaseTest {
	WebDriver driver;
	SalesforceOppurtunitiesPage opportunitypage;
@BeforeMethod
	public void beforemethod()
	{
		//calls the getDriver() from base test
		driver = getDriver();
		
		launchapp(driver);
		// Passing the driver to find element
		opportunitypage  = new SalesforceOppurtunitiesPage(driver);  
		DOMConfigurator.configure("log4j.xml");
	}

//TC15
	@Test(priority =1)
	public void checkOppurtunityDropdown() {
		Log.startTestCase("check Oppurtunity Dropdown");
		opportunitypage.enterintoUsername("nshakthipriyal@sand.com");
		opportunitypage.enterintoPassword("Priyag123");
		opportunitypage.clicklogin();
		opportunitypage.clickonOppurtunityTab() ;
		//validation
		String[] expectedlist = {"All Opportunities","Closing Next Month", "Closing This Month", "My Opportunities", "New Last Week", "New This Week", "Opportunity Pipeline", "Private", "Recently Viewed Opportunities", "Won"};
		opportunitypage.verifyDropdown(expectedlist);
		Log.info("Successfully verified");
	    Log.endTestCase("check Oppurtunity Dropdown");
}
	//Tc16
	@Test(priority =2)

	public void createNewOppurtunity() {
		Log.startTestCase("New Opportunity");
		opportunitypage.enterintoUsername("nshakthipriyal@sand.com");
		opportunitypage.enterintoPassword("Priyag123");
		opportunitypage.clicklogin();
		opportunitypage.clickonOppurtunityTab() ;
		opportunitypage.clickonNewButton();
		opportunitypage.enterintoOpportunitytextbox("nspriyal");
		opportunitypage.clickonCloseButton();
		opportunitypage.selectByVisibleTextQual("Qualification");
		opportunitypage.selectByVisibleTextWeb("Web");
		opportunitypage.clickonSaveButtonWithLocName();//in base page
		Log.endTestCase("New Opportunity");
	}
	//Tc17
	@Test(priority =3)
	public void OppurtunityPipelineReport() {
		Log.startTestCase("Opportunity Pipeline Report");
		opportunitypage.enterintoUsername("nshakthipriyal@sand.com");
		opportunitypage.enterintoPassword("Priyag123");
		opportunitypage.clicklogin();
		opportunitypage.clickonOppurtunityTab() ;
		opportunitypage.clickonReportLink();
		Log.endTestCase("Opportunity Pipeline Report");
	}
	//Tc18
		@Test(priority =4)
		public void stuckOppurtunityReport() {
			Log.startTestCase("Stuck Opportunity Report");
			opportunitypage.enterintoUsername("nshakthipriyal@sand.com");
			opportunitypage.enterintoPassword("Priyag123");
			opportunitypage.clicklogin();
			opportunitypage.clickonOppurtunityTab() ;
			opportunitypage.clickonStuckOppLink() ;
			Log.endTestCase("Stuck Opportunity Report");
		}
		//Tc19	
		@Test(priority =5)
		public void quartSummaryReport() {
			Log.startTestCase("Quart summary Report");
			opportunitypage.enterintoUsername("nshakthipriyal@sand.com");
			opportunitypage.enterintoPassword("Priyag123");
			opportunitypage.clicklogin();
			opportunitypage.clickonOppurtunityTab() ;
			opportunitypage.clickonQuartSummary() ;
			Log.endTestCase("Quart summary Report");
		}
@AfterMethod
public void teardown() {
	takescreenshot(driver,"Salesforce");
	close();
	
}
}