package com.crm.comcast.CreateOrganizationPom;

import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseClass;
import com.vtiger.comcast.pomripositorylib.CreateOrganizations;
import com.vtiger.comcast.pomripositorylib.Home;
import com.vtiger.comcast.pomripositorylib.Organization_Information;
import com.vtiger.comcast.pomripositorylib.Organizations;

public class CreateOrgwithBaseclassTest extends BaseClass{
@Test(groups="smokeTest")
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


@Test(groups="regressionTest")
public void createOrgwith() throws Throwable {
String orgName = eLib.getexelData("Sheet1",4,2)+"_"+jLib.getrandomnum();
	
	Home hm=new Home(driver);
	hm.getOrganationtb().click();
	
	Organizations orgs=new Organizations(driver);
	orgs.getCreateOrgtb().click();
	
	/*Create Organization and Save*/
	CreateOrganizations corg=new CreateOrganizations(driver);
	corg.createOrgwithIndustryandtype(orgName);;
	/*verify*/ 
	Organization_Information orgInfo=new Organization_Information(driver);
	
	
	String actualOrg = orgInfo.getSuccessMsg().getText();
	if(actualOrg.contains(orgName)) {
		System.out.println("Organization is Created With industry and type ");
	}
	else {
		System.err.println("Organization is not Created With industry and type"); 
		}
	
}

/*   inorder to excute impacted region we created one method for regional regresstion testing
@Test
public void Createorgimpact() {
System.out.println("This module is impacted ");	

}*/
}