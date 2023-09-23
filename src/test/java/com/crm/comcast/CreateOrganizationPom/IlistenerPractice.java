package com.crm.comcast.CreateOrganizationPom;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseClass;
@Listeners(com.crm.comcast.genericutility.ListnerImp.class)
public class IlistenerPractice extends BaseClass {	
@Test
public void IlistenerPractices(){
	System.out.println("failed test ");
	Assert.fail();
}
}
