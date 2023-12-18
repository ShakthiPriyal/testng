package com.testng.tests;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testng.base.BasePage;
import com.testng.base.BaseTest;
import com.testng.log.Log;
import com.testng.pages.SalesforceRandomSceneriosPage;

public class SalesforceRandomSceneriosTest extends BaseTest{
	WebDriver driver;
	SalesforceRandomSceneriosPage randompage;
@BeforeMethod
	public void beforemethod()
	{
		//calls the getDriver() from base test
		driver = getDriver();
		
		launchapp(driver);
		// Passing the driver to find element
		randompage= new SalesforceRandomSceneriosPage(driver);  
		DOMConfigurator.configure("log4j.xml");
	}
//TC33
@Test(priority =1)
public void checkFirstAndLastName() {
	Log.startTestCase("Check First Name and Last Name");
	randompage.enterintoUsername("nshakthipriyal@sand.com");
	randompage.enterintoPassword("Priyag123");
	randompage.clicklogin();
	randompage.clickHomeTab();
	String actualfirstlastname=randompage.verifyFirstLastName();
	String expectedname = "Shakthi Priyal ABCD";//Shakthi Priyal ABCDNatarajanAdhi
	compareText(actualfirstlastname,expectedname);
	randompage.verifyFirstLastNameLink();
	randompage.clickonNameLink();
	Log.info("Successfully verified");
	Log.endTestCase("Check First Name and Last Name");
	
}
//TC34
@Test(priority =2)
public void verifyEditedName(){
	Log.startTestCase("Check Edited First Name and Last Name");

	randompage.enterintoUsername("nshakthipriyal@sand.com");
	randompage.enterintoPassword("Priyag123");
	randompage.clicklogin();
	randompage.clickHomeTab();
	randompage.clickonNameLink();
	randompage.clickonEditButton();
	driver.switchTo().frame("contactInfoContentId");
	//verify
	String actualtabname=randompage.getTextTabName();
	String expectedtabname ="Contact";
	compareText(actualtabname,expectedtabname);
	Log.info("Successfully tab name verified");
	randompage.clickonAboutTab();
	randompage.checkFocus();
	Log.info("Successfully texbox focus verified");
	 randompage.enterintolastNameTextbox("ABCD");
	randompage.clickonSaveAllButton();
	 driver.switchTo().defaultContent();
	 String actualusername=randompage.getTextUsermenuName();
	 String expectedusername="Shakthi Priyal ABCD";
	 compareText(actualusername,expectedusername);
	Log.info("Successfully verified");
Log.endTestCase("Check Edited First Name and Last Name");
}
//TC35
@Test(priority =3)
public void TabCustomization(){
	Log.startTestCase("Customize the Tab");
    randompage.enterintoUsername("nshakthipriyal@sand.com");
	randompage.enterintoPassword("Priyag123");
	randompage.clicklogin();
	randompage.clickonPlusTab();
	randompage.clickonCustomizeTab();
	randompage.selectonSubscriptionVisibleText("Subscriptions");//always add before you run
	randompage.clickonRemoveButton();
	randompage.clickonSaveButtonWithLocName();
	randompage.clickonCustomizeTab();
	String[] expectedlist = {"Home (default)","Chatter", "Content", "Accounts", "Opportunities", "Leads", "Contacts"};
	randompage.verifyDropdown(expectedlist);
	randompage.clickonUsermenu();
	randompage.clickonLogout();
	//verrify title of page
	/*String acttitle = title("actualtitle");
	System.out.println(acttitle);
	String expectedtitle="Login | Salesforce";
	Log.info(acttitle);
*////	compareText(acttitle,expectedtitle);
	randompage.enterintoUsername("nshakthipriyal@sand.com");
	randompage.enterintoPassword("Priyag123");
	randompage.clicklogin();
	randompage.clickonPlusTab();
	randompage.clickonCustomizeTab();
	String[] customizeexpectedlist = {"Home (default)","Chatter", "Content", "Accounts", "Opportunities", "Leads", "Contacts"};
	randompage.verifyDropdown(customizeexpectedlist);
}
//Tc36
@Test(priority =4)
public void BlockACalendarEvent(){
	Log.startTestCase("Blocking a calendar");
	randompage.enterintoUsername("nshakthipriyal@sand.com");
	randompage.enterintoPassword("Priyag123");
	randompage.clicklogin();
	randompage.clickHomeTab();
	/*String actualcaltitle = title("actualtitle");
	System.out.println(actualcaltitle);
	String expectedtitle="Calendar for Shakthi Priyal ABCD ~ Salesforce - Developer Edition";
	Log.info(actualcaltitle);
*///compareText(actualcaltitle,expectedtitle);
randompage.clickonDateLink();
randompage.clickonEightPmLink();
String actualeventtitle = title("actualtitle");
//System.out.println(actualeventtitle);
String expectedeventtitle="Calendar: New Event ~ Salesforce - Developer Edition";
Log.info(actualeventtitle);
compareText(actualeventtitle,expectedeventtitle);
Log.info(actualeventtitle);
randompage.enterIntoSubject("Other");
randompage.enterIntoEndDateField("9:00 PM");
randompage.clickonSaveButtonWithLocName();
	Log.endTestCase("Blocking a calendar");
	
}
//Tc37
@Test(priority =5)
public void BlockACalendarEventWithRecurrence(){
	Log.startTestCase("Blocking a calendar with Recurrence");
	randompage.enterintoUsername("nshakthipriyal@sand.com");
	randompage.enterintoPassword("Priyag123");
	randompage.clicklogin();
	randompage.clickHomeTab();
	randompage.clickonDateLink();
	randompage. clickonFourPmLink();
	randompage.enterIntoSubject("Other");
	randompage.enterIntoEndDateField("7:00 PM");
	randompage.clickonCheckRecurrence();
	randompage.clickonRadioButton();
	randompage.clickandEnterEndDate(14);
	randompage.clickonSaveButtonWithLocName();
	randompage.clickonMonthIcon();
	String actualeventmonthtitle = title("actualtitle");
	//System.out.println(actualeventtitle);
	String expectedeventmonthtitle="Calendar for Shakthi Priyal ABCD - Month View ~ Salesforce - Developer Edition";
	
	compareText(actualeventmonthtitle,expectedeventmonthtitle);
	Log.info(actualeventmonthtitle);
	Log.endTestCase("Blocking a calendar with Recurrence");
}
@AfterMethod
public void teardown() {
	takescreenshot(driver,"Salesforce");
	close();
	
}
}
