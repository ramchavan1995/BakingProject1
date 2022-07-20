package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObject.LoginPage;

public class TC_LoginTest_001 extends BaseClass{
	
	
	@Test
	public void loginTest() throws IOException {
		
		
		   driver.get(baseURL);
		 logger.info("Url is Opened");
			//driver.get("https://demo.guru99.com/V4/");
			
			LoginPage lp=new LoginPage(driver);
			System.out.println("hii");
			lp.setUserName(username);
			System.out.println(username);
			logger.info("Entered Username");
			lp.setPassword(password);
			logger.info("Entered Password");
			
			lp.clickSubmit();
			
			if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
				Assert.assertTrue(true);
				logger.info("Login Test Passed");
			}
			else {
				captureScreen(driver,"loginTest");
				Assert.assertTrue(false);
				logger.info("Login Test Failed");
			}
	}

}
