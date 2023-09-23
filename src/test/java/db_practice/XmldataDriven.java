package db_practice;

import java.util.Random;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class XmldataDriven {

	@Test
	public void  CreateOrgwithIndustry(XmlTest xml) {
		Random random=new Random();
		int randomnum = random.nextInt();
		System.out.println(randomnum);
		
		String Browser = xml.getParameter("browser");
		String url = xml.getParameter("http://localhost:8888/");
		
		
	}
}
