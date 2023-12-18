package com.testng.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.Select;

import com.testng.base.BasePage;

public class SalesforceContactsPage extends BasePage {
WebDriver driver;
	
	public SalesforceContactsPage(WebDriver driver) {
		super(driver);
		
}
	//Identifying webelements
	@FindBy(id="username")
	WebElement Username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="Login")
	WebElement loginbtn;
	
	//click contact tab
	@FindBy(xpath="//a[text()='Contacts']")
					WebElement contactstab;
			
			//click new button
	@FindBy(name="new")
					WebElement newbtn;
	//enter lastname
	@FindBy(id="name_lastcon2")
					WebElement lastnametextbox;
	//enter account name
	@FindBy(id="con4")
					WebElement accountnametextbox;
	
	@FindBy(className="topName")
			WebElement verifycontactname;
	//click create new view
	@FindBy(xpath="//a[text()='Create New View']")
			WebElement newviewlink;
	
	
	@FindBy(id="fname")
WebElement viewname;
	
	@FindBy(id="devname")
			WebElement uniqueviewname;
	
	@FindBy(name="fcf")
	WebElement verifycontactviewname;
	
	
	@FindBy(id="hotlist_mode")
			
			WebElement recentcreateddropdown;
	
	@FindBy(xpath="//table/tbody/tr/th/a[text()='Natarajan']")
			WebElement tbldata ;
	
	
	@FindBy(id="devname")
	WebElement uniquecontactviewname;
	//Tc30
	//click create new view in top
	
	//verifying error msg
	 
	@FindBy(className="errorMsg")
	WebElement actualerrormsg;
	
	
	@FindBy(id="errorDiv_ep")
	WebElement actualcontacterrormsg;
	
	
	//@FindBys({@FindBy(className="errorMsg"),
     //   @FindBy(id="errorDiv_ep")
//})
		//WebElement actualerrormsg;
	//TC31
	//cancel button
	@FindBy(name="cancel")
			 WebElement cancelbtn;
		
//TC32
	@FindBy(name="save_new")
	WebElement saveandnewbtn;
	
	//Actions of webelement
	//Tc25
	
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
	public void clickonContactsTab() {
	contactstab.click();
	}
	public void clickonNewButton() {
	newbtn.click();
	}
	
	public void enterintoLastname(String strlastname) {
		waitforElement(lastnametextbox);
		lastnametextbox.sendKeys(strlastname);
	}
	public void enterintoAccountname(String straccountname) {
		waitforElement(lastnametextbox);
	accountnametextbox.sendKeys(straccountname);
	}
	//save in base page
	//verification
	public String verifyTheContactNmae() {
	String strverifyname=verifycontactname.getAttribute("value");
	return strverifyname;
	
}
	//Tc26
	public void clickonNewView() {
		newviewlink.click();
		
	}
	
	public void enterintoViewname(String strviewname) {
		waitforElement(viewname);
		viewname.sendKeys(strviewname);
		
	}
	public void enterintoUniqueViewname(String struniqueviewname)
	{
		uniqueviewname.sendKeys(struniqueviewname);
		}
	
	
	public String verifyContactNameinDropdown(String stractualselectedValueInDropDown) {
		
			Select selectverifydrpdwn= new Select(verifycontactviewname);
			WebElement selectedoption = selectverifydrpdwn.getFirstSelectedOption();
			return stractualselectedValueInDropDown = selectedoption.getText();
		
	}
	//TC28
	public  void selectByVisibleText(String strvisibletext) {
		waitforElement(recentcreateddropdown);
	Select selectdrpdwn= new Select(recentcreateddropdown);

	selectdrpdwn.selectByVisibleText(strvisibletext);
	}
	//TC29
	public void clickonTableName() {
		tbldata.click();
		
	}
	//TC30
	public void enterintocContactUniqueViewname(String struniqueviewname) {
	uniquecontactviewname.sendKeys(struniqueviewname);
	 uniquecontactviewname.clear();
	 uniquecontactviewname.sendKeys(struniqueviewname);
	
}	
	public String errormsgtext() {
		waitforElement(actualerrormsg);
	return actualerrormsg.getText();
	
	}
	public String errormsgSaveandNewtext() {
		waitforElement(actualcontacterrormsg);
	return actualcontacterrormsg.getText();
	
	}
	//TC31
	public void clickonCancelButton() {
		cancelbtn.click();
		
	}
	//TC32
	public void clickonSaveandNewButton() {
		saveandnewbtn.click();
		
	}
	
}




