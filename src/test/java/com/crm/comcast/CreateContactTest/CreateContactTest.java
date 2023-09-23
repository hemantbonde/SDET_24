package com.crm.comcast.CreateContactTest;

import java.util.Random;
import java.util.concurrent.TimeUnit;

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

public class CreateContactTest {
	@Test
	public void createcontact() throws Throwable {
		fileutility fLib=new fileutility();
		fileutilityexel eLib=new fileutilityexel();
		webdriverUtility wbLib=new webdriverUtility();
		JavaUtility jLib=new JavaUtility();
		
		String browser = fLib.getpropertykey("browser");
		String url = fLib.getpropertykey("url");
		String userName= fLib.getpropertykey("username");
		String  password= fLib.getpropertykey("password");
		int randomNum = jLib.getrandomnum();
		
		String orgName = eLib.getexelData("Sheet1",4,2)+"_"+randomNum;
		String lastname=eLib.getexelData("Sheet1", 4, 4);
		
		
		WebDriver driver=null;
		if(browser.equals("chrome")) {
			driver=new ChromeDriver();
		}else if(browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}else if(browser.equals("ie")) {
			driver=new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(userName);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		WebElement industry_ele = driver.findElement(By.name("industry"));
		industry_ele.click();
		wbLib.DropdownforIndustry(industry_ele);
		
		WebElement type_ele = driver.findElement(By.name("accounttype"));
		type_ele.click();
		wbLib.DropdownforType(type_ele);
		
		driver.findElement(By.name("button")).click();
		
		String title = driver.findElement(By.className("dvHeaderText")).getText();
		if(title.contains(orgName)) {
			System.out.println("Organization is Created ");
		}
		else{
			System.err.println("Organization Already Created");
		}
		
		
		WebElement element = driver.findElement(By.linkText("Contacts"));
		wbLib.explicitelyWait(driver,element, 20);
		element.click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.xpath("//input[@name='account_id']/following-sibling::img")).click();
	
		wbLib.switchtowindow(driver, "Accounts&action");
		driver.findElement(By.name("search_text")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(orgName)).click();
		wbLib.switchtowindow(driver, "Contacts ");
		driver.findElement(By.name("button")).click();
	
		String actualcontact = driver.findElement(By.className("dvHeaderText")).getText();
		if(actualcontact.contains(lastname)) {
			System.out.println("contact is created ");
		}else {
			System.err.println("Contact is not created");	
		}
		WebElement element2 = driver.findElement(By.xpath("(//td[@valign='bottom'])[2]"));
		wbLib.mouseHover(driver, element2);
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();
	}
}
