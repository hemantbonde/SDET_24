package com.crm.comcast.genericutility;

import java.util.Random;

public class JavaUtility {
	public int getrandomnum() {
		Random random=new Random();
	    int randomnum = random.nextInt(1500);
		return randomnum;
		
	}

}
