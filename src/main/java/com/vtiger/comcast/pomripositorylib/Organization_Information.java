package com.vtiger.comcast.pomripositorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericutility.webdriverUtility;

public class Organization_Information {

	WebDriver driver;
	
	@FindBy(xpath="//span[contains(text(),'Organization Information')]")
	private WebElement successMsg;
	
	
	
	public Organization_Information(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	public WebElement getSuccessMsg() {
		return successMsg;
	}

	
}
