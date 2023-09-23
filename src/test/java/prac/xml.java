package prac;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.internal.reflect.Parameter;
import org.testng.xml.XmlTest;

import com.crm.comcast.genericutility.fileutility;
import com.crm.comcast.genericutility.fileutilityexel;

public class xml {
	
	@Test
	public void tc1(XmlTest xml) throws Throwable {
		
		String Browser=xml.getParameter("browser");
		String URL=xml.getParameter("url");
		String UserName=xml.getParameter("username");
		String Password=xml.getParameter("password");
		
		Random ran=new Random();
		int ranNum = ran.nextInt(20);
		
		fileutilityexel fe=new fileutilityexel();
		String Orgname = fe.getexelData("Sheet1",2 , 0)+"_"+ranNum;
		WebDriver driver=null;
		if(Browser.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(Browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(UserName);
		driver.findElement(By.name("user_password")).sendKeys(Password);
		driver.findElement(By.id("submitButton")).click();
	
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(Orgname);
		driver.findElement(By.name("button")).click();
		Thread.sleep(3000);
		System.out.println("Org Created");
	}

}
