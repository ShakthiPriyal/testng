package com.testng.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class BaseTest {
	
	WebDriver driver;
	
	protected WebDriver getDriver() {
		
	if(driver==null) {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
	}
		return driver;
	}
	
	
	public void launchapp(WebDriver driver) {
		
		driver.get("https://login.salesforce.com");
		
	}
	//popup
	
		public void handlingAlerts(){
		Alert alert = driver.switchTo().alert();
		alert.accept();
		}
	
	//to compare title
	
	public String title(String stractualtitle) {
		 return stractualtitle= driver.getTitle();
		 
	}
//to compare text
	
public  void compareText(String stractualtext, String strexpectedtext) {
		
		Assert.assertEquals(stractualtext, strexpectedtext);
		
}

public void waitforElement(WebElement element) {
	
	WebDriverWait wait = new WebDriverWait(driver,10);
	wait.until(ExpectedConditions.visibilityOf(element));
		
	}


//tpo switch to the child window

public  void childWindowSwitch() {
		Set<String> handles = driver.getWindowHandles();
		for(String handle:handles) {
			System.out.println(handle);
			driver.switchTo().window(handle);
			}
		}
//to verify whether its in child window

public  void verifyChildWindow() {
		String childtitle=driver.getTitle();
		System.out.println(childtitle);
		driver.close();
}


//To take Screenshoit
	public void takescreenshot(WebDriver driver, String methodName) {
		
		//Take Screen shot interface create and Object of the screen 
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		// store this in source file . 
		File scrFile = screenshot.getScreenshotAs(OutputType.FILE);
		
		Date current = new Date();
		String timestamp = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(current);
		 String reportFileName = "Saleseforce" +timestamp+ ".jpeg";
	     String fileSeperator = System.getProperty("file.separator");
	     String reportFilepath = System.getProperty("user.dir") +fileSeperator+ "newscreenshots";
	     String reportFileLocation =  reportFilepath +fileSeperator+ reportFileName;
	//	String filepath = "/Users/lpg/eclipse-practice-workspace/TestNGFrameworkSalesforce/screenshots/"+methodName+timestamp+".jpeg";
		File destFile = new File (reportFileLocation);
		try {
			FileUtils.copyFile(scrFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void close() {
		driver.close();
		driver = null;
	}
}
