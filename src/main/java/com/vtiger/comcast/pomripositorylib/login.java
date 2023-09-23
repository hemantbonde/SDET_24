package com.vtiger.comcast.pomripositorylib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericutility.fileutility;
import com.crm.comcast.genericutility.webdriverUtility;
/**
 * 
 * @author Hemant
 *
 */
public class login {
	
	WebDriver driver;
	fileutility fLib=new fileutility();
	webdriverUtility wbLib=new webdriverUtility();
	
	@FindBy(name="user_name")
	private WebElement usernametb;
	
	@FindBy(name="user_password")
	private WebElement passwordtb;
	
	@FindBy(id="submitButton")
	private WebElement loginbtn;
	
	public login(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	public WebElement getUsernametb() {
		return usernametb;
	}

	public WebElement getPasswordtb() {
		return passwordtb;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
	//positive scenario
	/**
	 * helps to login with data in  file
	 * @throws Throwable
	 */
    public void loginTOapp(String usn,String pwd) throws Throwable {
    	
    	driver.manage().window().maximize();
    	wbLib.impliciteWait(driver);
		usernametb.sendKeys(usn);
		passwordtb.sendKeys(pwd);
		loginbtn.click();
		
	}
    /**
     * used to to login with user data
     * @param username
     * @param password
     * @throws Throwable
     */
	
	//for negative scenaro
     public void loginTOapp() throws Throwable {
    	driver.manage().window().maximize();
    	wbLib.impliciteWait(driver);
		usernametb.sendKeys("admin");
		passwordtb.sendKeys("manager");
		loginbtn.click();
	}
	
	
	
}
