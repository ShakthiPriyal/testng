package com.testng.pages;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.testng.base.BasePage;
import org.openqa.selenium.interactions.Actions;
import junit.framework.Assert;
import org.openqa.selenium.support.ui.Select;

public class SalesforceLeadsPage extends BasePage{
	
	WebDriver driver;
	
	public SalesforceLeadsPage(WebDriver driver) {
		super(driver);
	}
	//Identifying webelements
	
	
			@FindBy(id="username")
			WebElement Username;
			
			@FindBy(id="password")
			WebElement password;
			
			@FindBy(id="Login")
			WebElement loginbtn;
			//click leads tab
			@FindBy(xpath="//a[text()='Leads']")
					WebElement leadstab;
			@FindBy(id="userNavLabel")
			WebElement usermenudrpdwn;
			//select logout from usermenu dropdown
			@FindBy(xpath="//a[text()='Logout']")
					WebElement logout;
			
			@FindBy(name="go")
					WebElement gobutton;
			//TC24
			@FindBy(name="new")
				WebElement newbutton;
			//enter the details
			@FindBy(id="name_lastlea2")
			WebElement lastnametextbox;
			
			@FindBy(id="lea3")
					WebElement compnametextbox;
		    
			
			
			//Actions of webelement
			
			
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
			public void clickLeadsTab() {
				waitforElement(leadstab);
				leadstab.click();
			}
			public void selectUsermenuDropdown() {
				usermenudrpdwn.click();
			}
			public void clickonLogout() {
				logout.click();
			}
			//verification
			
			public void clickonGoButton() {
				gobutton.click();
			}
			//TC24
			public void clickonNewButton() {
			newbutton.click();
			}
			public void enterintoLastnameTextbox(String strlastname) {
				lastnametextbox.sendKeys(strlastname);
				
			}
			public void enterintoCompanynameTextbox(String strcompname) {
				compnametextbox.sendKeys(strcompname);
				
			}
			//save in base pagge
}

