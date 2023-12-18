package com.testng.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

import com.testng.base.BasePage;

import junit.framework.Assert;

import org.openqa.selenium.support.ui.Select;

public class SalesforceRandomSceneriosPage extends BasePage  {
	WebDriver driver;
	
	public SalesforceRandomSceneriosPage(WebDriver driver) {
		super(driver);
	}
	
	//WebElement
	@FindBy(id="username")
	WebElement Username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="Login")
	WebElement loginbtn;
	
	//click home tab
	@FindBy(xpath="//a[text()='Home']")
					WebElement hometab;
	
	@FindBy(xpath="//a[contains(text(),'Shakthi')]")
	WebElement fnamelname;
	
	@FindBy(linkText="Shakthi Priyal ABCD")
			WebElement linkName;
	
	@FindBy(xpath="//img[@title='Edit Profile'][1]")
			WebElement editbtn;
	
	@FindBy(xpath="//iframe[@id='contactInfoContentId']")
		WebElement findframe;
	
	@FindBy(xpath="//a[normalize-space()='Contact']")
	
	WebElement contacttab;
	
	//Click about tab
	
	@FindBy(xpath="//a[@aria-controls='TabPanel:0:Body:1']")
			WebElement abouttab;
	// Check if the element has focus 
	@FindBy(id="firstName")
						 WebElement firstnametextbox;
	 //type in the last name
	
	@FindBy(id="lastName")
			WebElement lastnamebox;
	@FindBy(xpath="//input[@value='Save All']")
			WebElement saveallbtn;
	
	@FindBy(id="userNavLabel")
		WebElement usermenudrpdwn;
	
	//Tc35
	
	//click + tab
	@FindBy(className="allTabsArrow")
					WebElement plustab;
	//click customize tab
	@FindBy(name="customize")
					WebElement customizetab;
	@FindBy(id="duel_select_1")
			WebElement deselectsubscript;
	
	
	@FindBy(className="leftArrowIcon")
			WebElement removebutton;
	
	@FindBy(id="duel_select_1")
			WebElement deselectsubscript1;
	//select logout from usermenu dropdown
	
	@FindBy(xpath="//a[text()='Logout']")
			WebElement logout;
	@FindBy(xpath="//a[contains(text(),' 2023')][1]")
			WebElement datelink;
	
	@FindBy(xpath="//a[contains(text(),' 8:00 PM')]")
			WebElement eightpmlink;
	@FindBy(id="evt5")
			WebElement other;
	@FindBy(id="EndDateTime_time")
			WebElement enddatefield;
	@FindBy(xpath="//a[contains(text(),' 4:00 PM')]")
			WebElement fourpmlink;
	
	
	//Recurrence
	@FindBy(id="IsRecurrence")
	WebElement checkrecuurence;
	
	@FindBy(id="rectypeftw")
			WebElement weeklyradibtn;
	
	@FindBy(id="RecurrenceEndDateOnly")
			WebElement enddate;
	
	@FindBy(className="monthViewIcon")
			 WebElement monthicon;
	

	
	//Actions of webelement
	
			//Tc33
			
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
			
			public void clickHomeTab() {
				hometab.click();
			}
			//verify name
			public String verifyFirstLastName() {
				waitforElement(fnamelname);
				return fnamelname.getText();
				
			}
			//verify link
			public boolean verifyFirstLastNameLink() {
				if(linkName.isDisplayed())
				{
				//System.out.println("Yes link is there");
					return true;
				}
				else
				{
				 //System.out.println("No link is there");
					return false;
				}
				}
				
			
			
			public void clickonNameLink() {
				fnamelname.click(); 
			}
			public void clickonEditButton() {
				editbtn.click();
			
		
}
			public void switchToFrame() {
			
				
				driver.switchTo().frame(findframe);
			}
			
			public String getTextTabName() {
				
				return contacttab.getText();
			}
			
			public void clickonAboutTab() {
				abouttab.click();
			}
			public boolean checkFocus() {
				boolean textfield =firstnametextbox.isEnabled();
				Assert.assertEquals(textfield,true);
				return textfield;
				  
				
			}
			public void enterintolastNameTextbox(String strlnametext) {
				lastnamebox.sendKeys("");
				lastnamebox.clear();
				lastnamebox.sendKeys(strlnametext);
				
			}
			public void clickonSaveAllButton() {
				saveallbtn.click();	
			}	
			public String getTextUsermenuName() {
				waitforElement(usermenudrpdwn);
				return usermenudrpdwn.getText();
			}
			//Tc35
			public void clickonPlusTab() {
				waitforElement(plustab);
			plustab.click();
			}
			public void clickonCustomizeTab() {
			customizetab.click();
			}
			public void selectonSubscriptionVisibleText(String strcustomvisibletext) {
				Select select = new Select(deselectsubscript);
				select.selectByVisibleText(strcustomvisibletext);
			}
			public void clickonRemoveButton() {
			removebutton.click();
			}
			//save in base page
			//to verify
			//click customize tab
			public void verifyDropdown(String[] strexpectedlist) {
				waitforElement(deselectsubscript1);
				Select select= new Select(deselectsubscript1);
				
				List <WebElement> options =select.getOptions();

		for(int i=0;i<options.size();i++) {
		//System.out.println("Actual: "+actualdropdownlist.get(i)+" & Expected: "+expectedlist.get(i));
		Assert.assertEquals(options.get(i).getText(),strexpectedlist[i] );
		}
			}
			public void clickonUsermenu() {
				usermenudrpdwn.click();	
			}
			public void clickonLogout() {
			logout.click();
			}
			//verify
			public void clickonDateLink() {
				waitforElement(datelink);
			datelink.click();
			}
			public void clickonEightPmLink() {
			eightpmlink.click();
			}
			public void enterIntoSubject(String strsubjecttextbox) {
			other.sendKeys(strsubjecttextbox);
			
			}
			public void enterIntoEndDateField(String strenddatetextbox) {
			enddatefield.sendKeys("");
			enddatefield.clear();
			enddatefield.sendKeys(strenddatetextbox);
			
}
			public void clickonFourPmLink() {
			fourpmlink.click();
			}
			public void clickonCheckRecurrence() {
				checkrecuurence.click();
			}
			public void clickonRadioButton() {
				weeklyradibtn.click();
			}
			public void clickandEnterEndDate(Integer strdays) {
				enddate.click();
				SimpleDateFormat df = new SimpleDateFormat("MM/dd/YYYY");
				Date dt = new Date();
				Calendar cl = Calendar.getInstance();
				cl.setTime(dt);;
				 cl.add(Calendar.DATE, strdays);
			
				  String newDate = df.format(cl.getTime());
				
				   // System.out.println("the date today is " + newDate);
               enddate .sendKeys(newDate);
			}
			//save in base page
			public void clickonMonthIcon() {
				waitforElement( monthicon);
			 monthicon.click();
}
}