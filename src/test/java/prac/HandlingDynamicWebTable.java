package prac;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.fileutility;

import net.bytebuddy.implementation.bytecode.ByteCodeAppender.Size;

public class HandlingDynamicWebTable {
	WebDriver driver;
	@Test
	public void HandlingDynamicWebTable() throws Throwable {
		fileutility fLib=new fileutility();
		String browser = fLib.getpropertykey("browser");
		String url = fLib.getpropertykey("url");
		String userName= fLib.getpropertykey("username");
		String  password= fLib.getpropertykey("password");
		
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
		
		//click on the check box
		List<WebElement> list = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input"));
		
		for(int i=1;i<list.size();i++) {
			list.get(i).click();
		}
		
		//uncheck last one
		
		list.get(list.size()-1).click();
		//click on 5th checkbox
		list.get(5).click();
		
		//getname of all org
		List<WebElement> orglst = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a"));
		for(int i=1;i<orglst.size();i++) {
			System.out.println(orglst.get(i).getText());
		}
	}
	

}
