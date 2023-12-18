package com.testng.pages;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.testng.base.BasePage;
import org.openqa.selenium.interactions.Actions;
import junit.framework.Assert;
import org.openqa.selenium.support.ui.Select;

public class SalesforceUserMenuPage extends BasePage {
	WebDriver driver;
	public SalesforceUserMenuPage(WebDriver driver) {
		super(driver);
	}
	
	//Identifying webelements
	
	
		@FindBy(id="username")
		WebElement Username;
		
		@FindBy(id="password")
		WebElement password;
		
		@FindBy(id="Login")
		WebElement loginbtn;
		
		@FindBy(id="userNavLabel")
		WebElement usermenudrpdwn;
		
		@FindBy(id="userNav-menuItems")
		List <WebElement> actualusermenulist;
		
		@FindBy(xpath="//a[text()='My Profile']")
		WebElement myprofile;
		
		@FindBy(xpath="//img[@title='Edit Profile'][1]")
		WebElement editbtn;
		
	//	@FindBy(xpath="//iframe[@id='contactInfoContentId']")
	//	WebElement findframe;
		
		@FindBy(xpath="//a[@aria-controls='TabPanel:0:Body:1']")
        WebElement abouttab;
		
		@FindBy(id="lastName")
		WebElement lastnamebox;
		
		@FindBy(xpath="//input[@value='Save All']")
		WebElement saveallbtn;
		
		@FindBy(xpath="//span[text()='Post']")
		WebElement postlink;
		
	//	@FindBy(xpath="//iframe[@title='Rich Text Editor, publisherRichTextEditor']")
		
		
		
		@FindBy(xpath="//iframe[@class='cke_wysiwyg_frame cke_reset']")
		WebElement postframe;
		
		@FindBy(xpath="//body[contains(text(),'Share')]")
		WebElement posttextbox;
		
	//Share button is in base page
		
		@FindBy(xpath="//span[text()='File']")
		 WebElement filelink;
		
		@FindBy(xpath="//a[text()='Upload a file from your computer']")
		WebElement uploadfilelink;
		
		@FindBy(id="chatterFile")
		 WebElement choosefilelink;
		 
		//Share button is in base page
		
		@FindBy(id="photoSection")
		WebElement uploadphotomousehover;
		
		@FindBy(xpath="//a[@id='uploadLink']")
				WebElement addphotolink;
		@FindBy(xpath="//input[@id='j_id0:uploadFileForm:uploadInputFile']")
				 WebElement choosephoto;
		
		@FindBy(xpath="//input[@id='j_id0:uploadFileForm:uploadBtn']")
		 WebElement savebutton;
		
		@FindBy(xpath="//input[@id='j_id0:j_id7:save']")
		 WebElement saveaftercropbutton;
		
		//Tc7
		
		@FindBy(xpath="//a[text()='My Settings']")
		WebElement mysettings;
		
		//click on personal link and select login history link
		@FindBy(id="PersonalInfo_font")
				WebElement personallink;
		
		@FindBy(id="LoginHistory_font")
		WebElement loghistorylink;
		
		// click download login history 
		@FindBy(xpath="//a[contains(text(),'Download login history for last six months')]")
				WebElement loginhistorydownloadlink;
		
		//click on display and layout link
		@FindBy(id="DisplayAndLayout_font")
		WebElement displayoutlink;
		
		@FindBy(id="CustomizeTabs_font")
		WebElement customtablink;
		//select salesforce chatter from drop down
		@FindBy(id="p4")
		WebElement customappdrpdown;
		
		//select reports from available tabs
		@FindBy(id="duel_select_0")
				WebElement addreports;
		@FindBy(className="rightArrowIcon")
				WebElement addbutton;

		//click on email link
		@FindBy(id="EmailSetup_font")
		WebElement emaillink;
		
		@FindBy(id="EmailSettings_font")
				WebElement emailsettinglink;
		
		//enter the email name and fileld
		@FindBy(id="sender_name")
		WebElement emailnametextbox;
		
		@FindBy(id="sender_email")
		WebElement emailaddresstextbox;
		
		@FindBy(id="auto_bcc1")
				WebElement bccradiobutton;
		//click on save with locator name "save in base opage"
		//click on calendars and remainders
		
		@FindBy(id="CalendarAndReminders_font")
				WebElement calandreminderlink;
	
		@FindBy(id="Reminders_font")
				WebElement activityreminderlink;
		
		//click on test remainder button
		@FindBy(id="Reminders_font")
WebElement testbutton;
		
		//save in base page
		//tc8
		//click on Developerconsole from usermenu dropdown
		@FindBy(xpath="//a[text()='Developer Console']")
						WebElement devconsole;
		//select logout from usermenu dropdown
		
		@FindBy(xpath="//a[text()='Logout']")
						WebElement logout;
				
				
		
		
		
		
		
		//Actions of webelement
		//Tc5
		
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
		
		public void selectUsermenuDropdown() {
			usermenudrpdwn.click();
		}
		//verifying dropdown
		public void verifyDropdown(String strexpectedusermenulist) {
			for(WebElement actualuserlists :actualusermenulist) { 
			 
			 if(actualuserlists.getText().equals(strexpectedusermenulist)){
				 System.out.println("Expected value is present");
				 break;
			 }}}
		//tc6
		
		public void clickonMyProfile() {
			myprofile.click();
		}
		public void clickonEditButton() {
			editbtn.click();
			
		}
		//Frame handling
	/*	public void switchToFrame() {
		
			driver.switchTo().frame(findframe);
	*///	}
		
		
	//	public void frameWindow() {
			//	String alertmessage = driver.switchTo().alert().getText();
			//	System.out.println(alertmessage);
				
				
				//driver.switchTo().alert().accept();
	//		}
		public void clickononAboutTab() {
			waitforElement(abouttab);
			abouttab.click();
		}
		
		public void clickonLastnameTextbox(String strlastnametextbox) {
		lastnamebox.sendKeys(strlastnametextbox);
		}
		
		public void clickonSaveAll() {	
		saveallbtn.click();
		
		//switch to webpage
		
	//	driver.switchTo().defaultContent();
}
		
		public void clickonPostLink() {
			 postlink.click();
			 
			}	
		public WebElement postFrame(){
			return postframe;
			
		}
		public void enterIntoPostTextbox(String strpostinpage) {
			//waitforElement(posttextbox);
			// posttextbox.click();
			
			 posttextbox.sendKeys(strpostinpage);
			// driver.switchTo().defaultContent();
			}
		public void clickonFileLink() {
			waitforElement(filelink);
			filelink.click();
			
			}	
		public void clickonUploadFileLink() {
			uploadfilelink.click();
			}	
		
		public void clickonChooseFileLink(String strfilepath) {
			choosefilelink.sendKeys(strfilepath);
			}
		public void photoMousehover() {
			waitforElement(uploadphotomousehover);
			Actions action = new Actions(driver);
			action.moveToElement(uploadphotomousehover).click().build().perform();
			}
	
        public void clickonAddPhotoLink() {
        	waitforElement(addphotolink);
	         addphotolink.click();
	 //switch to frame
	      //   driver.switchTo().frame("uploadPhotoContentId");
	}	
        public void clickonChoosePhotoLink(String strfilepath) {
        	waitforElement(choosephoto);
        	 choosephoto.sendKeys(strfilepath);
	}	
        public void clickonSaveButton() {
        	waitforElement(savebutton);
        	 savebutton .click();
			}
        public void clickonSaveAfterCrop() {
        	waitforElement(saveaftercropbutton);
		 saveaftercropbutton .click(); 
	// driver.switchTo().defaultContent();
}
        //TC7
        public void clickonMySettings() {
			mysettings.click();
		}
        public void clickonPersonalLink() {
        	personallink.click();
		}
        public void clickonLoginHistoryLink() {
        	loghistorylink.click();
		}
       //validation in base test
        
        public void clickonDownloadLoginHistoryLink() {
        	loginhistorydownloadlink.click();
		}
        
        public void clickonDisplayLayoutLink() {
        	
        	 displayoutlink.click();
		}
        public void clickonCustomTabLink() {
        	customtablink.click();
      
		}
        public void selectonCustomAppDropdown() {
        	Select saleschatter = new Select(customappdrpdown);
    		saleschatter.selectByVisibleText("Salesforce Chatter");
      
		}
        public void selectReports() {
        	Select selectreport = new Select(addreports);
    		selectreport.selectByVisibleText("Reports");
		}
        public void clickonAddButton() {
        	
        	 addbutton.click();
		}
        public void clickonEmailLink() {
        	
        	emaillink.click();
		}
        public void clickonEmailSettingLink() {
        	emailsettinglink.click();
       
		}
        public void enterIntoEmailNameTextBox(String stremailnametextbox) {
        	emailnametextbox.clear();
    		emailnametextbox.sendKeys(stremailnametextbox);
       
		}
        public void enterIntoEmailAddressTextBox(String stremailaddress) {
        	emailaddresstextbox.clear();
    		emailaddresstextbox.sendKeys(stremailaddress);
    		
		}
        public void clickonRadioButton() {
        	
        	bccradiobutton.click();
		}
        //save in base page

public void clickonCalandRemainderLink() {
	calandreminderlink.click();
        	
		}
public void clickonActivityRemaindrLink() {
	activityreminderlink.click();
        	
		}
public void clickonTestButton() {
	testbutton.click();
        	
		}
//TC8
public void clickonDevConsole() {
	devconsole.click();
	
}
//TC9
public void clickonLogout() {
	logout.click();
}
	public void waitonElement() {
		waitforElement(Username);
	
}

       
}
