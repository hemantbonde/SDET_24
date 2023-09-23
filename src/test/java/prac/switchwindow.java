package prac;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class switchwindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.naukri.com");
		String parent = driver.getWindowHandle();
		
		Set<String> child = driver.getWindowHandles();
		child.remove(parent);
		String etitle="ICICI";
		System.out.println(child.size());
		for(String ch:child) {
			driver.switchTo().window(ch);
			String acttitle = driver.getTitle();
			
			if(acttitle.equals(etitle)) {
				driver.close();
			}
			}
		System.out.println(child.size());
		
		
				
		

	}

}
