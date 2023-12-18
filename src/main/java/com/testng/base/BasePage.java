package com.testng.base;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class BasePage {
	WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="publishersharebutton")
	WebElement sharebtn ;
	
	@FindBy(name="save")
	WebElement savebutton;
	//Tab drop down
	//For validation and selecting from dropdown
	//Oppurtunities and Leads//TC21//Tc15
	
	@FindBy(id="fcf")
	WebElement tabdropdown;
	
	public void waitforElement(WebElement element) {
	
	WebDriverWait wait = new WebDriverWait(driver,10);
	wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	
	public void shareButton() {	
    sharebtn.click();
	}
	//for email and cal and remainder and in TC10 Create new aact
	public void clickonSaveButtonWithLocName() {
		waitforElement(savebutton);
		savebutton.click();
	        	}
	public void selectFromDropdown(String strvisibletext) {
		waitforElement(tabdropdown);
		Select viewname = new Select(tabdropdown);
		viewname.selectByVisibleText(strvisibletext);
		
	}
	public String verifyViewName() {
		waitforElement(tabdropdown);
		return tabdropdown.getText();
		
	}
	public void verifyDropdown(String[] strexpectedlist) {
		waitforElement(tabdropdown);
		Select select= new Select(tabdropdown);
		
		List <WebElement> options =select.getOptions();

for(int i=0;i<options.size();i++) {
//System.out.println("Actual: "+actualdropdownlist.get(i)+" & Expected: "+expectedlist.get(i));
Assert.assertEquals(options.get(i).getText(),strexpectedlist[i] );
}
	}
	public String verifyselectedOptionFromDropdown(String stractualselectedValueInDropDown) {
	
	Select selectverifydrpdwn= new Select(tabdropdown);
	WebElement selectedoption = selectverifydrpdwn.getFirstSelectedOption();
	return stractualselectedValueInDropDown = selectedoption.getText();


}}