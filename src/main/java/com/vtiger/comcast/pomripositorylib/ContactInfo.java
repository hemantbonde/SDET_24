package com.vtiger.comcast.pomripositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfo {
WebDriver driver;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement successMsg;
	
	
	
	public ContactInfo(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	public WebElement getSuccessMsg() {
		return successMsg;
	}
}
