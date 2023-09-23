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

public class organddeletebydyanamic {
	WebDriver driver;
	@Test
	public void organddeletebydyanamic() throws Throwable {
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

	WebElement org = driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input"));
	//table[@class='lvt small']/tbody/tr[*]/td[8]/a          
	}}
