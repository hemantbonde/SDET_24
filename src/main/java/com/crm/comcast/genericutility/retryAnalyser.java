package com.crm.comcast.genericutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/**
 * 
 * @author Hemant
 *
 */
public class retryAnalyser implements IRetryAnalyzer {
	/**
	 * this method will implement retry analyser which can be utilised for failed script
	 */

	int count=0;
	int retrycount=5;
	public boolean retry(ITestResult result) {
	
		
		while(count<retrycount) {
			count++;
			return true;
		}
		return false;
	}
}
