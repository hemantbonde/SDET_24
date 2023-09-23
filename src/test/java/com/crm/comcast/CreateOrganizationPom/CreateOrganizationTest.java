package com.crm.comcast.CreateOrganizationPom;

import java.util.concurrent.TimeUnit;

import javax.security.auth.login.LoginContext;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.JavaUtility;
import com.crm.comcast.genericutility.fileutility;
import com.crm.comcast.genericutility.fileutilityexel;
import com.crm.comcast.genericutility.webdriverUtility;
import com.vtiger.comcast.pomripositorylib.Home;
import com.vtiger.comcast.pomripositorylib.Organization_Information;
import com.vtiger.comcast.pomripositorylib.Organizations;
import com.vtiger.comcast.pomripositorylib.CreateOrganizations;
import com.vtiger.comcast.pomripositorylib.login;

public class CreateOrganizationTest {
    @Test
    public void CreateOrganization() throws Throwable {
	WebDriver driver=null;
	fileutility fLib=new fileutility();
	fileutilityexel eLib=new fileutilityexel();
	JavaUtility jLib=new JavaUtility();
	webdriverUtility wbLib=new webdriverUtility();
	
	
	String BROWSER = fLib.getpropertykey("browser");
	String URL = fLib.getpropertykey("url");
	
	String orgName = eLib.getexelData("Sheet1",4,2)+"_"+jLib.getrandomnum();
	
	if(BROWSER.equals("chrome")) {
		driver=new ChromeDriver();
	}else if(BROWSER.equals("firefox")) {
		driver=new FirefoxDriver();
	}else if(BROWSER.equals("ie")) {
		driver=new InternetExplorerDriver();
	}	
	
	
	driver.get(URL);
	/*login to the app*/
	
	login lg=new login(driver);
	String usn = fLib.getpropertykey("username");
	String pwd = fLib.getpropertykey("password");
	lg.loginTOapp(usn,pwd);;
	/*navigate to the Organization*/
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
	else
		System.err.println("Organization is not Created");
	/*signout from app*/
	hm.SignOut();
	/*close browser*/
	driver.close();
    }
    }

