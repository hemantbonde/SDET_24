package com.vtiger.comcast.pomripositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericutility.webdriverUtility;

public class Home {
	WebDriver driver;
	webdriverUtility wbLib=new webdriverUtility();
	
	@FindBy(linkText="Calendar")
	private WebElement calendertb;
	
	@FindBy(linkText="Organizations")
	private WebElement organationtb;
	
	@FindBy(linkText="Contacts")
	private WebElement contacttb;
	
	@FindBy(xpath="(//td[@valign='bottom'])[2]")
	private WebElement administratorimg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signouttb;
	
	public Home(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCalendertb() {
		return calendertb;
	}

	public WebElement getOrganationtb() {
		return organationtb;
	}

	public WebElement getContacttb() {
		return contacttb;
	}

	public WebElement getAdministratorimg() {
		return administratorimg;
	}
	
	public WebElement getSignouttb() {
		return signouttb;
	}

	
	public void SignOut() {
	
		wbLib.mouseHover(driver, administratorimg);
		signouttb.click();
	
	}
	
	
	
	
}
