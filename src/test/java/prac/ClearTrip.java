package prac;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ClearTrip {
@Test
public void bookticket() throws Throwable {
	Date sdate=new Date();
	 String date = sdate.toString();
	 System.out.println(date);
	 String[] a = date.split(" ");
	 String actdate =a[0]+" "+a[1]+" "+a[2]+" "+a[5];
	 
	 
	 
	 WebDriver driver=new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 driver.get("https://www.cleartrip.com/");
	 WebElement from = driver.findElement(By.xpath("//input[@type='text']"));
	 from.click();
	 from.sendKeys("mum");
	 Thread.sleep(1000);
	 WebElement selectFrom = driver.findElement(By.xpath("//p[contains(text(),'Mumbai')]"));
	 selectFrom.click();
	 
	
	 driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("nag");
	 Thread.sleep(1000);
	 WebElement selectTo = driver.findElement(By.xpath("//p[contains(text(),'Nagpur')]"));
	 selectTo.click();
	 
	 driver.findElement(By.xpath("//button[@style='min-width: 185px;']")).click();

	 driver.findElement(By.xpath("//div[(@aria-label='"+actdate+"')]")).click();
	 System.out.println("flight is booked");
	 
}
}
