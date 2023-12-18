package com.testng.tests;

import com.testng.base.BaseTest;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;
import java.util.*;
import com.testng.log.Log;
import com.testng.pages.SalesforceContactsPage;
import com.testng.pages.SalesforceLeadsPage;

import junit.framework.Assert;

public class SalesforceContactsTest extends BaseTest {
	WebDriver driver;
	SalesforceContactsPage contactspage;
@BeforeMethod
	public void beforemethod()
	{
		//calls the getDriver() from base test
		driver = getDriver();
		
		launchapp(driver);
		// Passing the driver to find element
		contactspage= new SalesforceContactsPage(driver);  
		DOMConfigurator.configure("log4j.xml");
	}
//TC25
@Test(priority =1)
public void crreateNewContact() {
	Log.startTestCase("Create New Contct");
	contactspage.enterintoUsername("nshakthipriyal@sand.com");
	contactspage.enterintoPassword("Priyag123");
	contactspage.clicklogin();
	contactspage.clickonContactsTab();
	contactspage.clickonNewButton();
	contactspage.enterintoLastname("Natarajan");
	contactspage.enterintoAccountname("Shakthi Priyal");
	contactspage.clickonSaveButtonWithLocName();
	
contactspage.verifyTheContactNmae();
Log.endTestCase("Create New Contct");
}
//TC26
@Test(priority =2)
public void createNewViewInContact() {
	Log.startTestCase("Create New view Contct");
	contactspage.enterintoUsername("nshakthipriyal@sand.com");
	contactspage.enterintoPassword("Priyag123");
	contactspage.clicklogin();
	contactspage.clickonContactsTab();
	contactspage.clickonNewView();
	contactspage.enterintoViewname("priya");
	contactspage.enterintoUniqueViewname("14");
	contactspage.clickonSaveButtonWithLocName();
	String expectedselectedValueInDropDown = "priya";
	String actselectedValueInDropDown =contactspage.verifyContactNameinDropdown("actualselectedValueInDropDown" );//contactpage
	compareText(actselectedValueInDropDown,expectedselectedValueInDropDown ) ;
	Log.info("Successfully verified");
	Log.endTestCase("Create New view Contct");
	
	
}
//Tc27
@Test(priority =3)
public void recentlyCreatedContact() {
	Log.startTestCase("Recent Contact");
	contactspage.enterintoUsername("nshakthipriyal@sand.com");
	contactspage.enterintoPassword("Priyag123");
	contactspage.clicklogin();
	contactspage.clickonContactsTab();
	contactspage.selectByVisibleText("Recently Created");//contacts page
	Log.endTestCase("Recent Contact");
	
}
//Tc28
@Test(priority =4)
public void myContacts() {
	Log.startTestCase("My contacts in dropdown");
	contactspage.enterintoUsername("nshakthipriyal@sand.com");
	contactspage.enterintoPassword("Priyag123");
	contactspage.clicklogin();
	contactspage.clickonContactsTab();
	contactspage.selectFromDropdown("My Contacts");//base page
	Log.endTestCase("My contacts in dropdown");
	
}
	//Tc29
@Test(priority =5)
	public void viewContacts() {
		Log.startTestCase("View my contacts");
		contactspage.enterintoUsername("nshakthipriyal@sand.com");
		contactspage.enterintoPassword("Priyag123");
		contactspage.clicklogin();
		contactspage.clickonContactsTab();
		contactspage.clickonTableName() ;
		//validation
		String acttitle = title("actualtitle");
		String expectedtitle="Contact: Natarajan ~ Salesforce - Developer Edition";
		
		Log.info(acttitle);
		compareText(acttitle,expectedtitle);
		Log.endTestCase("View my contacts");
}
	//TC30
@Test(priority =6)
	public void checkErrorMessage() {
		Log.startTestCase("Verify Error Message");
		contactspage.enterintoUsername("nshakthipriyal@sand.com");
		contactspage.enterintoPassword("Priyag123");
		contactspage.clicklogin();
		contactspage.clickonContactsTab();
		contactspage.clickonNewView();
	contactspage.enterintocContactUniqueViewname("EFGH");
	contactspage.clickonSaveButtonWithLocName();
	String actmsg= contactspage.errormsgtext();
	String expectedmsg="Error: You must enter a value";
	Log.info(actmsg);
	compareText(actmsg,expectedmsg);
	Log.info("Enter the unique name value");
	Log.endTestCase("Verify Error Message");
	}
	//TC31
@Test(priority =7)
	public void checkCancelButton() {
		Log.startTestCase("Verify Cancel Button");
		contactspage.enterintoUsername("nshakthipriyal@sand.com");
		contactspage.enterintoPassword("Priyag123");
		contactspage.clicklogin();
		contactspage.clickonContactsTab();
		contactspage.clickonNewView();
		contactspage.enterintoViewname("ABCD");
		contactspage.enterintocContactUniqueViewname("EFGH");
		contactspage.clickonCancelButton();
		
		String actselectedValueInDropDown =contactspage.verifyselectedOptionFromDropdown("actualselectedValueInDropDown" );//base page
		String expectedselectedValueInDropDown = "ABCD";
		if(!(actselectedValueInDropDown==expectedselectedValueInDropDown)) {
			Log.info("Testcase passed");
		}
		Log.endTestCase("Verify Cancel Button");
			
	}
	
	//TC32
@Test(priority =8)
	public void checkSaveandNewButton() {
	Log.startTestCase("Check Save and New");
	contactspage.enterintoUsername("nshakthipriyal@sand.com");
	contactspage.enterintoPassword("Priyag123");
	contactspage.clicklogin();
	contactspage.clickonContactsTab();
	contactspage.clickonNewButton();
	contactspage.enterintoLastname("Indian");
	contactspage.enterintoAccountname("Global Media");
	contactspage.clickonSaveandNewButton();
	//verify
	String actmsg= contactspage.errormsgSaveandNewtext();
	String expectedmsg="Error: Invalid Data.\n"
			+ "Review all error messages below to correct your data.";
	Log.info(actmsg);
	compareText(actmsg,expectedmsg);
	
}
@AfterMethod
public void teardown() {
	takescreenshot(driver,"Salesforce");
	close();
	
}
}
