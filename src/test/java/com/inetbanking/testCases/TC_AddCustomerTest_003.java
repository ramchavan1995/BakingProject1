package com.inetbanking.testCases;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObject.AddCustomerPage;
import com.inetbanking.pageObject.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User Name Is Provided");
		lp.setPassword(password);
		logger.info("Password Is Provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		 AddCustomerPage addcust=new  AddCustomerPage(driver);
		 addcust.CilckAddNewCustomer();
		 
		// addcust.CilckAdPage();
		 
//		 driver.switchTo().frame((WebElement) By.id("background_exit_dc"));
//		 driver.findElement(By.id("dismiss-button")).click();
//		 driver.switchTo().defaultContent();
//		 
//		 if(isAlertPresent()==true) {
//		 driver.switchTo().frame((WebElement) By.id("background_exit_dc"));
//		 driver.findElement(By.id("dismiss-button")).click();
//		 driver.switchTo().defaultContent();
//	 }
//		
		// driver.switchTo().alert().sendKeys("Close"); 
		 
		
		 logger.info("Providing Customer Details...");
		 
		 addcust.custName("Lakhan Chavan");
		 addcust.custGender("male");
		 addcust.cusdob("19", "06", "1995");
		 addcust.custAddress("INDIA");
		 addcust.custCity("PUNE");
		 addcust.custState("MAHARASHTRA");
		 addcust.custPin("414309");
		 addcust.custTelephoneNo("9112768777");
		 
		 String email=randomstring()+"@gmail.com";
		 addcust.custEmailId(email);
		 
		 addcust.custPassword("ramlakan123");
		 addcust.custSubmit();
		 
		 Thread.sleep(3000);
		 
		 logger.info("Validation is started...");
		 
		 boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		 
		 if(res==true) {
			 Assert.assertTrue(true);
			 logger.info("Test case is Passed...");
		 }
		 else {
			 logger.info("Test case is Failed...");
			 captureScreen(driver," addNewCustomer");
			 Assert.assertTrue(false);
		 }
	}
	
	

}
