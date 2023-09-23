package db_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class s {

	
	@Test
	public void tc1() throws Throwable {
		// TODO Auto-generated method stub
		
		String projectName="SDET24";
		String createdBy="User1";
		WebDriver driver=new ChromeDriver();
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("http://localhost:8084/");
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.linkText("Projects")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		driver.findElement(By.name("projectName")).sendKeys(projectName);
		driver.findElement(By.name("createdBy")).sendKeys(createdBy);
		WebElement drp = driver.findElement(By.name("status"));
		Select s=new Select(drp);
		s.selectByVisibleText("Created");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);

		
		Connection con=null;
		try {
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		
		Statement stat = con.createStatement();
		ResultSet res = stat.executeQuery("select * from project");
		while(res.next()) {
			String val = res.getString(4);
			if(val.equals(projectName)) {
				System.out.println("Project Exist :"+val);
			Reporter.log("Project has been Created",true);
			break;
			}
		}}
		catch(Exception e)
		 {
			Reporter.log("Project has Not created",true);
		}finally {
		
		con.close();
		Reporter.log("----------closed-------",true);
		}
	}
	
}