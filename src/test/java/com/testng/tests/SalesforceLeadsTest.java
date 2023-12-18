package com.testng.tests;


import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;
import java.util.*;
import com.testng.base.BaseTest;
import com.testng.log.Log;
import com.testng.pages.SalesforceLeadsPage;


public class SalesforceLeadsTest extends BaseTest {
	WebDriver driver;
	SalesforceLeadsPage leadspage;
@BeforeMethod
	public void beforemethod()
	{
		//calls the getDriver() from base test
		driver = getDriver();
		
		launchapp(driver);
		// Passing the driver to find element
		leadspage= new SalesforceLeadsPage(driver);  
		DOMConfigurator.configure("log4j.xml");
	}
//TC20
@Test(priority =1)
public void checkLeadsTab() {
	Log.startTestCase("Check Leads Tab");
	leadspage.enterintoUsername("nshakthipriyal@sand.com");
	leadspage.enterintoPassword("Priyag123");
	leadspage.clicklogin();
	leadspage.clickLeadsTab();
	
	//validation
	String actleadstitle=title("actualleadstitle");
	String expectedleadstitle = "Leads: Home ~ Salesforce - Developer Edition";
	Log.info(actleadstitle);
	compareText(actleadstitle,expectedleadstitle);
Log.endTestCase("Check Leads Tab");
}
//Tc21
@Test(priority =2)
public void leadsSelectView() {
	Log.startTestCase("Check Leads Select View");
	leadspage.enterintoUsername("nshakthipriyal@sand.com");
	leadspage.enterintoPassword("Priyag123");
	leadspage.clicklogin();
	leadspage.clickLeadsTab();
	String[] expectedleadslist = {"All Open Leads", "My Unread Leads", "Recently Viewed Leads", "Today's Leads", "View - Custom 1", "View - Custom 2" };
	leadspage.verifyDropdown(expectedleadslist);
	Log.info("Successfully verified");
	
	Log.endTestCase("Check Leads Select View");
}
//Tc22
@Test(priority =3)
public void goButtonFunctionality() {
	Log.startTestCase("Go button Without List selection");
	leadspage.enterintoUsername("nshakthipriyal@sand.com");
	leadspage.enterintoPassword("Priyag123");
	leadspage.clicklogin();
	leadspage.clickLeadsTab();
	leadspage.selectFromDropdown("Today's Leads");
	leadspage.selectUsermenuDropdown();
	leadspage.clickonLogout();
	leadspage.enterintoUsername("nshakthipriyal@sand.com");
	leadspage.enterintoPassword("Priyag123");
	leadspage.clicklogin();
	leadspage.clickLeadsTab();
	
	String actselectedValueInDropDown =leadspage.verifyselectedOptionFromDropdown("actualselectedValueInDropDown" );//base page
	String expectedselectedValueInDropDown = "Today's Leads";
	compareText(actselectedValueInDropDown,expectedselectedValueInDropDown ) ;
	Log.info("Successfully verified");
	//verification
	leadspage.clickonGoButton();
	Log.endTestCase("Go button Without List selection");
}
//Tc23
@Test(priority =4)
public void listTodaysLeads() {
	Log.startTestCase("Todays leads page");
	leadspage.enterintoUsername("nshakthipriyal@sand.com");
	leadspage.enterintoPassword("Priyag123");
	leadspage.clicklogin();
	leadspage.clickLeadsTab();
	leadspage.selectFromDropdown("Today's Leads");
	leadspage.clickonGoButton();
	Log.endTestCase("Todays leads page");
}
//Tc24
@Test(priority =5)
public void checkNewButtonOnLeadsHome() {
	Log.startTestCase("Check New Button");
	leadspage.enterintoUsername("nshakthipriyal@sand.com");
	leadspage.enterintoPassword("Priyag123");
	leadspage.clicklogin();
	leadspage.clickLeadsTab();
	leadspage.clickonNewButton();
	leadspage.enterintoLastnameTextbox("ABCD");
	leadspage.enterintoCompanynameTextbox("ABCD");
	leadspage.clickonSaveButtonWithLocName();//save in base page
	//validation
		String actleadstitle = title("actualleadstitle");
	
	String expectedleadstitle="Lead: ABCD ~ Salesforce - Developer Edition";
	Log.info(actleadstitle);
	compareText(actleadstitle,expectedleadstitle);
	
}
@AfterMethod
public void teardown() {
	takescreenshot(driver,"Salesforce");
	close();
	
}
}