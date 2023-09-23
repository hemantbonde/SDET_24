package com.crm.comcast.CreateOrganizationPom;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseClass;
import com.vtiger.comcast.pomripositorylib.ContactInfo;
import com.vtiger.comcast.pomripositorylib.Contacts;
import com.vtiger.comcast.pomripositorylib.CreateContact;
import com.vtiger.comcast.pomripositorylib.CreateOrganizations;
import com.vtiger.comcast.pomripositorylib.Home;
import com.vtiger.comcast.pomripositorylib.Organization_Information;
import com.vtiger.comcast.pomripositorylib.Organizations;

public class CreateContactwithBaseTest extends BaseClass{
	@Test
	public void CreateOrganization() throws Throwable {
		String orgName = eLib.getexelData("Sheet1",4,2)+"_"+jLib.getrandomnum();
		
		Home hm=new Home(driver);
		hm.getOrganationtb().click();
		
		Organizations orgs=new Organizations(driver);
		orgs.getCreateOrgtb().click();
		
		/*Create Organization and Save*/
		CreateOrganizations corg=new CreateOrganizations(driver);
		corg.createorganization(orgName);
		/*verify*/ 
		Organization_Information orgInfo=new Organization_Information(driver);
		
		
		String actualOrg = orgInfo.getSuccessMsg().getText();
		if(actualOrg.contains(orgName)) {
			System.out.println("Organization is Created ");
		}
		else {
			System.err.println("Organization is not Created"); 
			}
	}
	@Test
	public void createcontact() throws Throwable {
		String orgName = eLib.getexelData("Sheet1",4,2)+"_"+jLib.getrandomnum();
		String lastname=eLib.getexelData("Sheet1", 4, 4);
		
		Home hm=new Home(driver);
		hm.getContacttb().click();
		
		CreateContact cc=new CreateContact(driver);
		cc.createcontact(driver, lastname);
		
		wbLib.switchtowindow(driver, "Accounts&action");
		Organizations org=new Organizations(driver);
		org.selectorg(orgName);
		wbLib.switchtowindow(driver, "Contacts ");
		cc.getSavecontacbtn().click();
		ContactInfo ci=new ContactInfo(driver);
		ci.getSuccessMsg();
		String actualcontact =ci.getSuccessMsg().getText();
		if(actualcontact.contains(lastname)) {
			System.out.println("contact is created ");
		}else {
			System.err.println("Contact is not created");	
		}
	}

}
