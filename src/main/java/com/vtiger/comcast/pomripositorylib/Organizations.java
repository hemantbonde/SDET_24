package com.vtiger.comcast.pomripositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericutility.webdriverUtility;

public class Organizations {
	WebDriver driver;
	
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createOrgtb;
	
	@FindBy(name="search_text")
	private WebElement searchtf;
	
	@FindBy(name="search")
	private WebElement searchbtn;
	
	@FindBy(linkText="+orgName+")
	private WebElement orglink;
	
	 public Organizations(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	 
	 public WebElement getCreateOrgtb() {
			return createOrgtb;
		}
	public void selectorg(String orgName) {
		searchtf.sendKeys(orgName);
		searchbtn.click();
		
	}
	

}
