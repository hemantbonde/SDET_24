package com.crm.comcast.CreateOrganizationPom;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class SampleForRetryAnalyser {
@Test(retryAnalyzer = com.crm.comcast.genericutility.retryAnalyser.class)
public void  retryAnalyser() {
	Reporter.log("Retry this implementation",true);
	Assert.fail();
}
}
