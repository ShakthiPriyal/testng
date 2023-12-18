package com.testng.pages;

import org.openqa.selenium.WebDriver;

import com.testng.base.BasePage;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.interactions.Actions;
import junit.framework.Assert;
import org.openqa.selenium.support.ui.Select;

public class SalesforceCreateAccountpage extends BasePage {
	WebDriver driver;
	public SalesforceCreateAccountpage(WebDriver driver) {
		super(driver);

}
	//Identifying webelements
	//TC10
	
			@FindBy(id="username")
			WebElement Username;
			
			@FindBy(id="password")
			WebElement password;
			
			@FindBy(id="Login")
			WebElement loginbtn;
			
			//click accounts tab
			@FindBy(xpath="//a[text()='Accounts']")
					WebElement accounttab;
			
			//to verify account name
			@FindBy(xpath="//a[text()='Shakthi Priyal']")
					WebElement acctnameverify;
			//click new tab
			@FindBy(name="new")
					WebElement newtab;
			//account name textbox
			@FindBy(id="acc2")
					WebElement accnametextbox;
			//select the type drop down
			@FindBy(id="acc6")
					WebElement typedropdown;
			
			//select customer priority
			@FindBy(id="00NHn00000HYReq")
					WebElement custprioritydropdown;
			//save button in base page
			@FindBy(name="save_new")
			WebElement saveandnewbutton;
			//TC11
			
			//click create new vioew tab
			
			@FindBy(xpath="//a[text()='Create New View']")
					WebElement newviewtab;
			
			
		//enter the details	
			@FindBy(id="fname")
					WebElement viewnametextbox;
			
			
			@FindBy(id="devname")
					WebElement uniqueviewnametextbox;
			//uniqueviewnametextbox.clear();
			
			//save button in base page		
			
			//to verify the view name in the dropdown
			//@FindBy(id="00BHn00000B01cV_listSelect")
		//	@FindBy(id="fcf")
		//	WebElement actualviewname;
			
			@FindBy(name="fcf")
			WebElement tabdropdown;
			
			//TC12
			//Edit voew
			//select the view name from dropdown
			
		//	@FindBy(id="fcf")
			//		WebElement viewnamedropdown;
				
			
			//select edit link
			@FindBy(xpath="//a[text()='Edit']")
					WebElement editlink;
			
			//enter the details	
			@FindBy(id="fname")
					WebElement editviewnametextbox;
			
			//enter the deatils
			@FindBy(id="fcol1")
					WebElement fielddropdown;
			
			
			@FindBy(id="fop1")
					WebElement operatordropdown;
			
			
			@FindBy(id="fval1")
					WebElement valuetextbox;
			
			//click on save button in base page
			
			//TC13- merge Accounts
			@FindBy(xpath="//a[text()='Merge Accounts']")
					WebElement mergeaccountlink;
			
			//find account textbox
			
			@FindBy(id="srch")
					WebElement accttextbox;
			
			@FindBy(name="srchbutton")
			WebElement findacctbutton;
			//next button
			@FindBy(name="goNext")
					WebElement nextbutton;
				
			//click merge //save in base page
		//	= driver.findElement(By.name("save")
				//	WebElement mergebutton;
		//	mergebutton.click();	
			
			//TC14
			@FindBy(xpath="//a[text()='Accounts with last activity > 30 days']")
					WebElement acctactivitylink;
			
			
			//datefield
			@FindBy(id="ext-gen148")
					WebElement datefielddropdown;
			@FindBy(xpath="//div[text()='Created Date']")
				WebElement createddate;
			//calendar field
			//@FindBy(id="ext-gen152")
			@FindBy(id="ext-comp-1042")
					WebElement fromcal;
			//@FindBy(id="ext-gen276")
		//	WebElement fromcaltoday;
		//	@FindBy(id="ext-gen154")
			@FindBy(id="ext-comp-1045")
			WebElement tocal;
		//	@FindBy(id="ext-gen296")
		//	WebElement tocaltoday;
			
			//save button
			@FindBy(id="ext-gen49")
					WebElement savebtn;
			
			
			//window handle
			@FindBy(id="saveReportDlg_reportNameField")
					WebElement reportnametextbox;
			
			
			@FindBy(id="saveReportDlg_DeveloperName")
			
			WebElement reportuniquenametextbox;
			
			@FindBy(xpath="//button[text()='Save and Run Report']")
					WebElement saveandrunbutton;
			
			
			//Actions of Web Element
			//TC10
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
			public void clickonAccountsTab() {
				accounttab.click();
			}
			public String verifyAccountName() {
				//waitforElement(acctnameverify);
			return acctnameverify.getText();
			
			}
			public void clickonNewTab() {
				newtab.click();
			}
			public void enterIntoAccountNameTextbox(String straccnametextbox) {
				waitforElement(accnametextbox);
				accnametextbox.sendKeys(straccnametextbox);
			}

public void selectTechpartner() {
	Select techpartner = new Select(typedropdown);
	techpartner.selectByIndex(6);
}
public void selectCustomerpriority() {

	Select highpriority = new Select(custprioritydropdown);
	highpriority.selectByIndex(1);
}
public void clickonSaveAndNewTab() {
	saveandnewbutton.click();
}

//save button in base page
//TC11
public void clickonNewViewTab() {
	newviewtab.click();
}
public void enterIntoViewNameTextbox(String strviewname) {
	viewnametextbox.sendKeys(strviewname);
}
public void enterIntoUniqueViewNameTextbox(String struniqueviewname) {
	uniqueviewnametextbox.sendKeys(struniqueviewname);
}
//save button in base page
//verify viewname 
public String verifyselectedOptionFromDropdown(String stractualselectedValueInDropDown) {
	
	Select selectverifydrpdwn= new Select(tabdropdown);
	WebElement selectedoption = selectverifydrpdwn.getFirstSelectedOption();
	return stractualselectedValueInDropDown = selectedoption.getText();


}

//TC12
//select view name from dropdown

public void clickOnEditLink() {
editlink.click();
}

public void enterIntoEditViewNameTextbox(String streditviewname) {
	editviewnametextbox.sendKeys(streditviewname);
}
public void selectFieldNameFromFieldDropdown() {
Select fieldname = new Select(fielddropdown);
fieldname.selectByVisibleText("Account Name");
}
public void selectOperatorNameFromOperatorDropdown() {
Select operatorname = new Select(operatordropdown);
operatorname.selectByVisibleText("contains");
}
public void enterIntoValueTextbox(String strvaluetextbox) {
valuetextbox.sendKeys(strvaluetextbox);
}
//save in base page
//Tc13
public void clickOnMergeAccountLink() {
mergeaccountlink.click();
}

public void clickOnAccountTextbox(String stracctextbox) {
waitforElement(accttextbox);
accttextbox.sendKeys(stracctextbox);
}
public void clickOnFindAcctButton() {
	findacctbutton.click();	
}
public void clickOnNextButton() {
nextbutton.click();
}
//save button(merge accounts button)

//Tc14
public void clickOnAccountLink() {
acctactivitylink.click();
}

public void clickOnDateFieldDropDown() {
	waitforElement(datefielddropdown);
datefielddropdown.click();
}
public void clickOnCreatedDate() {
createddate.click();
}
public void clickonFromCalTextbox(String strfromcal) {
	
	fromcal.sendKeys(strfromcal);
}
/*public void ClickOnToDateCalImage() {
	waitforElement(fromcaltoday);
	fromcaltoday.click();
}
public void ClickOnFromDateTodayButton() {
	waitforElement(tocal);
tocal.click();
*///}
public void ClickOnToCalTextbox(String strtocal){
	 tocal.clear();
	 tocal.sendKeys(strtocal);
}
public void clickOnSaveReportsButton() {
savebtn.click();
}
public void enterIntoReportnameTextbox(String strreportname) {
reportnametextbox.sendKeys(strreportname);
}
public void enterIntoReportUniquenameTextbox(String strreportuniquename) {
	reportuniquenametextbox.sendKeys(strreportuniquename);
}

public void clickOnSaveandRunReportsButton() {
	waitforElement(saveandrunbutton);
	saveandrunbutton.click();
}



}