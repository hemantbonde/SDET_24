package prac;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BookforfutureMMT {
	@Test
	public void  bookfuturemmt() throws Throwable {
	Date sdate=new Date();
	 String date = sdate.toString();
	 System.out.println(date);
	 
	 
	 
	 WebDriver driver=new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 driver.get("https://www.makemytrip.com/");
	 
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//li[@data-cy='account']")).click();
	 driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
	 
	 WebElement from = driver.findElement(By.id("fromCity"));
	 from.click();
	 from.sendKeys("mum");
	 WebElement selectFrom = driver.findElement(By.xpath("//p[text()='Mumbai, India']"));
	 selectFrom.click();
	 
	
	 driver.findElement(By.xpath("//input[@aria-controls='react-autowhatever-1']")).sendKeys("nag");
	 WebElement selectTo = driver.findElement(By.xpath("//p[text()='Nagpur, India']"));
	 selectTo.click();
	 
	 driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
	 driver.findElement(By.xpath("//div[(@aria-label='Fri Jan 28 2022')]")).click();
	 
	 
	 System.out.println("flight is booked");
	 
}
}

