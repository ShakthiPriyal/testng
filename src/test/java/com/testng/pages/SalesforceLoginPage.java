package com.testng.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.testng.base.BasePage;

import junit.framework.Assert;

public class SalesforceLoginPage extends BasePage{
	
	//Every page needs driver to load webelements into the driver and so we put it in the base page and calls here
	
	public SalesforceLoginPage(WebDriver driver) {
		super(driver);
	}
	//Identifying webelements
	
	
	@FindBy(id="username")
	WebElement Username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="Login")
	WebElement loginbtn;
	
	@FindBy(id="error")
	WebElement actualerrormsg;
	
	//remember me
	
	@FindBy(xpath= "//label[text() = 'Remember me']")
	WebElement rememberme;
	
	//forgot password
	
	@FindBy(id="forgot_password_link")
	WebElement forgotpwd;
	
	@FindBy(id="un")
	WebElement forgotpwdusername;
	//continue button
	
	@FindBy(id="continue")
	WebElement contbutton;
	
	//return to login
	
	@FindBy(xpath="//a[text()='Return to Login']")
	WebElement returnlogin;
	
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
	
	public String errormsgtext() {
		waitforElement(actualerrormsg);
	return actualerrormsg.getText();
	
	}
	
	public void clickRememberme() {
		rememberme.click();
	}

	public void clickForgotPassword() {
		forgotpwd.click();
	}
	public void enterintoForgotPswdUsername(String strusername) {
		
		forgotpwdusername.sendKeys(strusername);
	}
	
	
	public void clickContinueButton() {
		contbutton.click();
	}
	public void clickReturnToLogin() {
		returnlogin.click();
	}
	
}
