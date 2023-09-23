package com.crm.comcast.genericutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.mysql.cj.jdbc.Driver;
import com.vtiger.comcast.pomripositorylib.Home;
import com.vtiger.comcast.pomripositorylib.login;
/**
 * 
 * @author Hemant
 *
 */
public class BaseClass {
	public WebDriver driver=null;
	public fileutility fLib=new fileutility();
	public fileutilityexel eLib=new fileutilityexel();
	public JavaUtility jLib=new JavaUtility();
	public webdriverUtility wbLib=new webdriverUtility();
	public  DataBaseUtilities dbLib= new DataBaseUtilities();
	
	@BeforeSuite(groups={"smokeTest","regressionTest"})
	public void configBs() throws Throwable {
		System.out.println("******Connect to DB*********");
		//login to db
		dbLib.connecttoDB();
	
		
	}
	//@Parameters(value = "browser")
	@BeforeClass(groups={"smokeTest","regressionTest"})
	public void configBC(/*String BROWSER*/) throws Throwable {
		System.out.println("******Open Browser*******");
		String BROWSER = fLib.getpropertykey("browser");
		String URL = fLib.getpropertykey("url");
		
		if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}else if(BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}else if(BROWSER.equals("ie")) {
			driver=new InternetExplorerDriver();
		}
		driver.get(URL);
		
	}
	
	@BeforeMethod(groups={"smokeTest","regressionTest"})
	public void ConfigBm() throws Throwable {
		System.out.println("******Login to App*******");
		String usn = fLib.getpropertykey("username");
		String pwd = fLib.getpropertykey("password");
		login lg=new login(driver);
		lg.loginTOapp(usn,pwd);
	}
	
	@AfterMethod(groups={"smokeTest","regressionTest"})
	public void ConfigAM() {
		System.out.println("****SignOut from App*****");
		Home hm=new Home(driver);
		hm.SignOut();
	}
	
	@AfterClass(groups={"smokeTest","regressionTest"})
	public void configAc() {
		System.out.println("*****close Browser******");
		driver.close();
	}
	
	@AfterSuite(groups={"smokeTest","regressionTest"})
	public void ConfigAs() throws Throwable {
		System.out.println("*******Close DB**********");
		dbLib.CloseDb();
	}
	
	
	
		
}
