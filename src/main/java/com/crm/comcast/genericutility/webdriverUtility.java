package com.crm.comcast.genericutility;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * 
 * @author Hemant
 *
 */
public class webdriverUtility {
	
	public void impliciteWait(WebDriver driver) {
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	
	public void explicitelyWait(WebDriver driver,WebElement element,int time) {
		
	WebDriverWait wait=new WebDriverWait(driver,time);
	wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void switchtowindow(WebDriver driver,String actualTitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String windowid = it.next();
			driver.switchTo().window(windowid);
			
			if(driver.getTitle().contains(actualTitle)) {
				break;
			}
		}
		
	}
	
	public void mouseHover(WebDriver driver,WebElement element) {
		
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
	 }
	public void doubleclick(WebDriver driver,WebElement element) {
		Actions a=new Actions(driver);
		a.doubleClick(element).perform();
		}
	public void DropdownforIndustry(WebElement element) {
		Select s=new Select(element);
		s.selectByValue("Food & Beverage");
	}
	public void DropdownforType(WebElement element) {
		Select s=new Select(element);
		s.selectByVisibleText("Customer");
	}
	}
