package com.testng.tests;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testng.base.BaseTest;
import com.testng.log.Log;
import com.testng.pages.SalesforceLoginPage;

public class SalesforceLoginTest extends BaseTest {
	WebDriver driver;
	SalesforceLoginPage loginpage;
	
	
	@BeforeMethod
	
	public void beforemethod()
	{
		//calls the getDriver() from base test
		driver = getDriver();
		
		launchapp(driver);
		// Passing the driver to find element
		 loginpage = new SalesforceLoginPage(driver);  
		 DOMConfigurator.configure("log4j.xml");
	}
	
	@Test(priority =1)
			public void loginerrormsg() {
		Log.startTestCase("Login Error Message");
				//Sequence of steps / sequence of actions
				loginpage.enterintoUsername("nshakthipriyal@sand.com");
				loginpage.enterintoPassword("");
				loginpage.clicklogin();
				//validation
				String actmsg= loginpage.errormsgtext();
				String expectedmsg="Please enter your password.";
				Log.info(actmsg);
				compareText(actmsg,expectedmsg);
				Log.info("Successfully Logged");
				Log.endTestCase("Login Error Message");
			}
			 
			
	@Test(priority =2)
			public void loginvalid() {
		Log.startTestCase("Login valid");
				//Sequence of steps / sequence of actions with the valid input 
				
				loginpage.enterintoUsername("nshakthipriyal@sand.com");
				loginpage.enterintoPassword("Priyag123");
				loginpage.clicklogin();
				Log.info("Successfully Logged");
				Log.endTestCase("Login valid");
			}
	@Test(priority =3)
	public void loginByrememberme() {
		//Sequence of steps / sequence of actions with the valid input 
		Log.startTestCase("Login By Remember me");
		loginpage.enterintoUsername("nshakthipriyal@sand.com");
		loginpage.enterintoPassword("Priyag123");
		loginpage.clickRememberme();
		loginpage.clicklogin();
		Log.info("Successfully Logged");
		Log.endTestCase("Login By Remember me");
	}
	
	@Test(priority =4)
	public void loginByForgotPassword() {
		//Sequence of steps / sequence of actions with the valid input 
		Log.startTestCase("Login By Forgot password");
		loginpage.enterintoUsername("nshakthipriyal@sand.com");
		loginpage. clickForgotPassword();
		loginpage.enterintoForgotPswdUsername("nshakthipriyal@sand.com");
		loginpage.clickContinueButton();
		loginpage.clickReturnToLogin();
		Log.info("Email is sent to reset the password");
		Log.endTestCase("Login By Forgot password");
	}
	@Test(priority =5)
	public void loginByInvalidPassword() {
		//Sequence of steps / sequence of actions with the valid input 
		Log.startTestCase("Login Invalid");
		loginpage.enterintoUsername("123");
		loginpage.enterintoPassword("22131");
		loginpage.clicklogin();
		String actmsg= loginpage.errormsgtext();
		String expectedmsg="Please enter your password.";
		Log.info(actmsg);
		compareText(actmsg,expectedmsg);
		Log.info("Login Failed");
		Log.endTestCase("Login Invalid");
	}	
	@AfterMethod
			public void teardown() {
				takescreenshot(driver,"Salesforce");
				close();
				
			}

}
