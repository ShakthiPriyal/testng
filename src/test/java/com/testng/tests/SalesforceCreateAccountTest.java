package com.testng.tests;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testng.base.BaseTest;
import com.testng.log.Log;
import com.testng.pages.SalesforceCreateAccountpage;

public class SalesforceCreateAccountTest extends BaseTest {
	WebDriver driver;
	SalesforceCreateAccountpage createaccountpage;
@BeforeMethod
	
	public void beforemethod()
	{
		//calls the getDriver() from base test
		driver = getDriver();
		
		launchapp(driver);
		// Passing the driver to find element
		createaccountpage  = new SalesforceCreateAccountpage(driver);  
		DOMConfigurator.configure("log4j.xml");
	}
//TC10
@Test(priority=1)
public void createNewAccount() {
	Log.startTestCase("New Account");
	createaccountpage.enterintoUsername("nshakthipriyal@sand.com");
	createaccountpage.enterintoPassword("Priyag123");
	createaccountpage.clicklogin();
	createaccountpage.clickonAccountsTab();
	
	//verifying Account Name
	
	String actualname= createaccountpage.verifyAccountName();
	String expectedname = "Shakthi Priyal";
	Log.info(actualname);
	compareText(actualname,expectedname);
	//System.out.println("actualname");
	Log.info("Account name verified");
	//creating 1st account
	createaccountpage.clickonNewTab() ;
	createaccountpage.enterIntoAccountNameTextbox("Shakthi Priyall92");
	createaccountpage.selectTechpartner();
	createaccountpage.selectCustomerpriority();
	createaccountpage.clickonSaveAndNewTab();//base page
	//creating2ndaccount
	
	/*createaccountpage.clickonNewTab() ;
	createaccountpage.enterIntoAccountNameTextbox("Shakthi Priyall11");
	createaccountpage.selectTechpartner();
	createaccountpage.selectCustomerpriority();
	*///createaccountpage.clickonSaveButtonWithLocName() ;//base page
	Log.info("Account name created");
	Log.endTestCase("New Account");

}
//TC11
@Test(priority=2)
public void createNewView() {
	Log.startTestCase("New View");
	createaccountpage.enterintoUsername("nshakthipriyal@sand.com");
	createaccountpage.enterintoPassword("Priyag123");
	createaccountpage.clicklogin();
	createaccountpage.clickonAccountsTab();
	createaccountpage.clickonNewViewTab();
	createaccountpage.enterIntoViewNameTextbox("nspriyal");
	createaccountpage.enterIntoUniqueViewNameTextbox("126");//give diff name for every run
	createaccountpage.clickonSaveButtonWithLocName() ;//base page
	/*createaccountpage.verifyViewName();
	String actualviewnameindropdown= createaccountpage.verifyViewName();
	*///System.out.println(actualviewnameindropdown);
	String exopectedviewname="nspriyal";
	String actualviewnameindropdown=createaccountpage.verifyselectedOptionFromDropdown("actualselectedValueInDropDown");
	Log.info(actualviewnameindropdown);
	compareText(actualviewnameindropdown,exopectedviewname);
	Log.info("New View created");
	Log.endTestCase("New View");	
}
//TC12
@Test(priority=3)
public void editView() {
	Log.startTestCase("Edit View");
	createaccountpage.enterintoUsername("nshakthipriyal@sand.com");
	createaccountpage.enterintoPassword("Priyag123");
	createaccountpage.clicklogin();
	createaccountpage.clickonAccountsTab();
	createaccountpage.selectFromDropdown("nspriyal");
	createaccountpage.clickOnEditLink();
	createaccountpage.enterIntoEditViewNameTextbox("nspriyalns");
	createaccountpage.selectFieldNameFromFieldDropdown();
	createaccountpage.selectOperatorNameFromOperatorDropdown();
	createaccountpage.enterIntoValueTextbox("a");
	createaccountpage.clickonSaveButtonWithLocName() ;//base page
	Log.info("Account viewname edited");
	Log.endTestCase("Edit View");
	
}
//Tc13
@Test(priority=4)
public void mergeAccounts() {
	Log.startTestCase("Merge Accounts");
	createaccountpage.enterintoUsername("nshakthipriyal@sand.com");
	createaccountpage.enterintoPassword("Priyag123");
	createaccountpage.clicklogin();
	createaccountpage.clickonAccountsTab();
	createaccountpage.clickOnMergeAccountLink() ;
	createaccountpage.clickOnAccountTextbox("Shakthi") ;
	createaccountpage.clickOnFindAcctButton();
	createaccountpage.clickOnNextButton();
	createaccountpage.clickonSaveButtonWithLocName() ;//merge account button
	//popup
	handlingAlerts();
	Log.info("Account merged");
	Log.endTestCase("Merge Accounts");
}
//Tc14
@Test(priority=5)
public void CreateAccountReport() {
	Log.startTestCase("Account Reports");
	createaccountpage.enterintoUsername("nshakthipriyal@sand.com");
	createaccountpage.enterintoPassword("Priyag123");
	createaccountpage.clicklogin();
	createaccountpage.clickonAccountsTab();
	createaccountpage.clickOnAccountLink();
	createaccountpage.clickOnDateFieldDropDown();
	createaccountpage.clickOnCreatedDate();
	createaccountpage.clickonFromCalTextbox("10/29/2023");
	createaccountpage.ClickOnToCalTextbox("11/13/2023");
	createaccountpage.clickOnSaveReportsButton() ;
	createaccountpage.enterIntoReportnameTextbox("pri") ;
	createaccountpage.enterIntoReportUniquenameTextbox("pri26");
	createaccountpage.clickOnSaveandRunReportsButton() ;
	Log.endTestCase("Account Reports");
}
	
	

@AfterMethod
public void teardown() {
	takescreenshot(driver,"Salesforce");
	close();
	
}
}