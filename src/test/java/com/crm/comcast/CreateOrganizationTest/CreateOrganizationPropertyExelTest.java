package com.crm.comcast.CreateOrganizationTest;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.fileutility;
import com.crm.comcast.genericutility.fileutilityexel;

public class CreateOrganizationPropertyExelTest {
	@Test
	public void CreateOrgTest() throws Throwable {
		fileutility fLib=new fileutility();
		fileutilityexel eLib=new fileutilityexel();
		
		Random random= new Random();
		int randomNum = random.nextInt(100);
		
		String browser = fLib.getpropertykey("browser");
		String url = fLib.getpropertykey("url");
		String userName= fLib.getpropertykey("username");
		String  password= fLib.getpropertykey("password");
		
		String orgName = eLib.getexelData("Sheet1", 4, 2)+"_"+randomNum;
		
		WebDriver driver=null;;
		if(browser.equals("chrome")) {
			driver=new ChromeDriver();
		}else if(browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}else if(browser.equals("ie")) {
			driver=new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(userName);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		

		driver.findElement(By.name("button")).click();
		
		String title = driver.findElement(By.className("dvHeaderText")).getText();
		if(title.contains(orgName)) {
			System.out.println("Organization is Created ");
		}
		else{
			System.err.println("Organization Already Created");
		}
		driver.close();
		
		
		
		
		
		
	}

}
