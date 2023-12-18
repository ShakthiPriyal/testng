package com.testng.tests;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;
import java.util.*;
import com.testng.base.BaseTest;
import com.testng.log.Log;
import com.testng.pages.SalesforceLoginPage;
import com.testng.pages.SalesforceUserMenuPage;


public class SalesforceUserMenuTest extends BaseTest {
	WebDriver driver;
	SalesforceUserMenuPage usermenupage;
@BeforeMethod
	
	public void beforemethod()
	{
		//calls the getDriver() from base test
		driver = getDriver();
		
		launchapp(driver);
		// Passing the driver to find element
		 usermenupage = new SalesforceUserMenuPage(driver);  
		 DOMConfigurator.configure("log4j.xml");

	}
@FindBy(xpath="//iframe[@id='contactInfoContentId']")
WebElement findframe;


//TC5
@Test(priority =1)
public void loginvalid() {
	Log.startTestCase("Login valid");
	usermenupage.enterintoUsername("nshakthipriyal@sand.com");
	usermenupage.enterintoPassword("Priyag123");
	usermenupage.clicklogin();
	usermenupage.selectUsermenuDropdown();
	//verifying dropdown
	List<String> expectedusermenulist = new ArrayList<String>();
	expectedusermenulist.add("My Profile");
	expectedusermenulist.add("My Settings");
	expectedusermenulist.add("Developer Console");
	expectedusermenulist.add("Switch to Ligtning Experience");
	expectedusermenulist.add("Logout");
	
	usermenupage.verifyDropdown("expectedusermenulist");
	Log.info("Successfully Logged");
	Log.endTestCase("Login valid");	
}
//TC6
@Test(priority =2)
public void SelectMyProfileOptionFromUsermenu() throws InterruptedException {
	Log.startTestCase("Add file and photo");
	usermenupage.enterintoUsername("nshakthipriyal@sand.com");
	usermenupage.enterintoPassword("Priyag123");
	usermenupage.clicklogin();
	usermenupage.selectUsermenuDropdown();
	usermenupage.clickonMyProfile();
	usermenupage.clickonEditButton() ;
	driver.switchTo().frame("contactInfoContentId");
	//usermenupage.switchToFrame();
	//usermenupage.frameWindow();
	usermenupage.clickononAboutTab();
	usermenupage.clickonLastnameTextbox("NatarajanAdhi");
	usermenupage.clickonSaveAll();
	driver.switchTo().defaultContent();
	usermenupage.clickonPostLink();
	driver.switchTo().frame(0);
	usermenupage.enterIntoPostTextbox("Hi! Im doing automation");
	driver.switchTo().defaultContent();
	usermenupage.shareButton();
	usermenupage.clickonFileLink();
	usermenupage.clickonUploadFileLink();
	usermenupage.clickonChooseFileLink("/Users/lpg/Pictures/samplepic.JPG");
	Thread.sleep(5000);
	usermenupage.shareButton();
	//usermenupage.photoMousehover();
	Actions action = new Actions(driver);
	
	 WebElement uploadphotomousehover= driver.findElement(By.id("photoSection"));
	 waitforElement(uploadphotomousehover);
	 action.moveToElement(uploadphotomousehover).click().build().perform();
	// Thread.sleep(3000);
	
	//@FindBy(id="photoSection")
//	WebElement uploadphotomousehover;
//	action.moveToElement(uploadphotomousehover).click().build().perform();
	usermenupage.clickonAddPhotoLink();
	 driver.switchTo().frame("uploadPhotoContentId");
	usermenupage.clickonChoosePhotoLink("/Users/lpg/Pictures/samplepic.JPG");
	usermenupage.clickonSaveButton();
	usermenupage.clickonSaveAfterCrop();
	driver.switchTo().defaultContent();
	Log.info("Successfully Logged");
	Log.endTestCase("Add file and photo");
}
//TC7
@Test(priority =3)
public void SelectMySettingsOptionFromUsermenu() {
	Log.startTestCase("click on links and check the pages");
	usermenupage.enterintoUsername("nshakthipriyal@sand.com");
	usermenupage.enterintoPassword("Priyag123");
	usermenupage.clicklogin();
	usermenupage.selectUsermenuDropdown();
	
	usermenupage.clickonMySettings();
	usermenupage.clickonPersonalLink();
	usermenupage.clickonLoginHistoryLink();
	
	//validation
	String acttitle = title("actualtitle");
	String expectedtitle="Login History ~ Salesforce - Developer Edition";
	Log.info(acttitle);
	compareText(acttitle,expectedtitle);
	usermenupage.clickonDownloadLoginHistoryLink();
	usermenupage.clickonDisplayLayoutLink();
	usermenupage.clickonCustomTabLink();
	usermenupage.selectonCustomAppDropdown();
	usermenupage. selectReports();
	usermenupage. clickonAddButton();
	usermenupage.clickonEmailLink();
	usermenupage.clickonEmailSettingLink();
	usermenupage.enterIntoEmailNameTextBox("Shakthi Priyal");
	usermenupage.enterIntoEmailAddressTextBox("nshakthipriyal@gmail.com");
	usermenupage.clickonRadioButton();
	usermenupage.clickonSaveButtonWithLocName();//base page
	usermenupage. clickonCalandRemainderLink();
	usermenupage. clickonActivityRemaindrLink();
	usermenupage. clickonTestButton();
	usermenupage.clickonSaveButtonWithLocName();
	Log.info("Successfully Logged");
	Log.endTestCase("click on links and check the pages");
}
//TC8
@Test(priority =4)
public void SelectDeveloperConsoleOptionFromUsermenu() {
	Log.startTestCase("Developer console browser");
	usermenupage.enterintoUsername("nshakthipriyal@sand.com");
	usermenupage.enterintoPassword("Priyag123");
	usermenupage.clicklogin();
	usermenupage.selectUsermenuDropdown();
	usermenupage.clickonDevConsole() ;
	//to get parentwindow id
	String parentwindow =	driver.getWindowHandle();
	//switch to the child window
	childWindowSwitch() ;
	//verifying tjhepage is in childwindow and close the window
	verifyChildWindow();
	//to get back to the parentwindow
	
			driver.switchTo().window(parentwindow);
			Log.info("Successfully Logged");
			Log.endTestCase("Devloper console browser");
	
}
//TC9
@Test(priority =5)
public void SelectLogoutOptionFromUsermenu() {
	Log.startTestCase("Logout Option");
	usermenupage.enterintoUsername("nshakthipriyal@sand.com");
	usermenupage.enterintoPassword("Priyag123");
	usermenupage.clicklogin();
	usermenupage.selectUsermenuDropdown();
	usermenupage.clickonLogout();
	usermenupage.waitonElement();
	Log.info("Successfully Logged");
	Log.endTestCase("Logout Option");
	//validation
	String acttitle = title("actualtitle");
	String expectedtitle="Login | Salesforce";
	
	Log.info(acttitle);
	compareText(acttitle,expectedtitle);
	
	Log.endTestCase("Logout Option");
	
}

@AfterMethod
public void teardown() {
	takescreenshot(driver,"Salesforce");
	close();
	
}

}