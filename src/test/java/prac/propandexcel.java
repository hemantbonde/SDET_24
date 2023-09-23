package prac;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.comcast.genericutility.fileutility;
import com.crm.comcast.genericutility.fileutilityexel;

public class propandexcel {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		fileutility fi=new fileutility();
		String Browser=fi.getpropertykey("browser");
		String URL=fi.getpropertykey("url");
		String UserName=fi.getpropertykey("username");
		String Password=fi.getpropertykey("password");
		
		Random ran=new Random();
		int ranNum = ran.nextInt(20);
		
		fileutilityexel fe=new fileutilityexel();
		String Orgname = fe.getexelData("Sheet1",1 , 0)+"_"+ranNum;
		
		
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
		try {
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(Orgname);
		driver.findElement(By.name("button")).click();
		Thread.sleep(3000);
		WebElement title = driver.findElement(By.className("dvHeaderText"));
		if(title.getText().contains("[ ACC11 ] hdfc_"+ranNum+" - Organization Information")) {
			System.out.println("Organization is Created ");
		}
		}
		catch(Exception e){
			System.err.println("Organization Already Created");
		}
		finally {
		driver.close();
		System.out.println("************Closed**************");
		}

	}

}
