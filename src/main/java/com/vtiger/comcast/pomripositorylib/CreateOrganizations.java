package com.vtiger.comcast.pomripositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.JavaUtility;
import com.crm.comcast.genericutility.fileutilityexel;
import com.crm.comcast.genericutility.webdriverUtility;

public class CreateOrganizations {

	WebDriver driver;
	fileutilityexel eLib=new fileutilityexel();
	webdriverUtility wbLib=new webdriverUtility();
	JavaUtility jLib=new JavaUtility();
	
	
	
	
	@FindBy(name="accountname")
	private WebElement OrgNametb;
	
	@FindBy(name="button")
	private WebElement savetb;
	
	@FindBy(name="industry")
	private WebElement industrydrp;
	
	@FindBy(name="accounttype")
	private WebElement typedrp;
	
	public WebElement getIndustrydrp() {
		return industrydrp;
	}

	public WebElement getTypedrp() {
		return typedrp;
	}

	public WebElement getOrgNametb() {
		return OrgNametb;
	}

	public WebElement getSavetb() {
		return savetb;
	}

	
	
	public CreateOrganizations(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void createorganization(String orgName) throws Throwable {
		OrgNametb.sendKeys(orgName);
		savetb.click();
	}
	public void createOrgwithIndustryandtype(String orgName) {
		OrgNametb.sendKeys(orgName);
		wbLib.DropdownforIndustry(industrydrp);
		wbLib.DropdownforType(typedrp);
		savetb.click();
	}
	
	
}

