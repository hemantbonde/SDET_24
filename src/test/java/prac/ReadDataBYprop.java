package prac;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.comcast.genericutility.fileutility;

public class ReadDataBYprop {


	public static void main(String[] args) throws Throwable {
		fileutility fi=new fileutility();
		// TODO Auto-generated method stub
		String Browser=fi.getpropertykey("browser");
		String URL=fi.getpropertykey("url");
		String UserName=fi.getpropertykey("username");
		String Password=fi.getpropertykey("password");
		String Orgname=fi.getpropertykey("orgname");
		
		
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
		if(title.getText().contains("[ ACC4 ] wipro ")) {
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
