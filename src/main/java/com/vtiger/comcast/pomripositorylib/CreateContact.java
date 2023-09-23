package com.vtiger.comcast.pomripositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericutility.fileutilityexel;

public class CreateContact {
	
	WebDriver driver;
	fileutilityexel eLib=new fileutilityexel();
	
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement createcontacttb;
	
	@FindBy(name="lastname")
	private WebElement lastnametb;
	
	@FindBy(xpath="//input[@name='account_id']/following-sibling::img")
	private WebElement lookupbtn;
	
	@FindBy(name="search")
	private WebElement searchbtn;
	
	public WebElement getCreatecontacttb() {
		return createcontacttb;
	}

	public WebElement getLastnametb() {
		return lastnametb;
	}

	public WebElement getLookupbtn() {
		return lookupbtn;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}

	public WebElement getSavecontacbtn() {
		return savecontacbtn;
	}

	@FindBy(name="button")
	private WebElement savecontacbtn;
	
	public CreateContact(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void createcontact(WebDriver driver,String lastname) throws Throwable {
		createcontacttb.click();
		lastnametb.sendKeys(lastname);
		lookupbtn.click();
		
	}
	
}
