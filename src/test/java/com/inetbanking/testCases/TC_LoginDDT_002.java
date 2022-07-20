package com.inetbanking.testCases;

import java.io.IOException;


import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.*;

import com.inetbanking.pageObject.LoginPage;
import com.inetbanking.utilities.XLUtils;

import junit.framework.Assert;

public class TC_LoginDDT_002 extends BaseClass
    {
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException 
	{
		//driver.get(baseURL);
		LoginPage lp=new LoginPage(driver);
	  
	  lp.setUserName(user);
		
		 logger.info("user name provided");
	lp.setPassword(pwd);
		
		 logger.info("password provided");
		lp.clickSubmit();
		
		//Thread.sleep(3000);
		
		if(isAlertPresent()==true) 
		{
			driver.switchTo().alert().accept();//closed the alert
			driver.switchTo().defaultContent();//back to main page
			Assert.assertTrue(false);
			logger.warn("Login Failed");
			
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login Passed");
			lp.clickLogout();
			//Thread.sleep(3000);
			driver.switchTo().alert().accept();//closed logout alert
			driver.switchTo().defaultContent();
			
		}
		
		
	}
	
	
	public boolean isAlertPresent() 
	{                                //user define method created to check alert is present or not
		try 
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e) 
		{//NoAleetPresentException
			return false;
		}
	}
	
	
	
	@DataProvider(name="LoginData")//data provider method
	String [][] getData() throws IOException
	{
	//	String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/LoginData.xlsx";
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/LoginData.xlsx";
		//System.out.println("E:\\Javap\\inetBankingV1\\src\\test\\java\\com\\inetbanking\\testData\\LoginData.xlsx");
		System.out.println(path);
		int rownum=XLUtils.getRowCount(path, "Sheet2");
		
		System.out.println(rownum);
	
		int colcount=XLUtils.getCellCount(path, "Sheet2", 1);
		System.out.println(colcount);
		
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++) 
		{
			
			for(int j=0;j<colcount;j++) 
			{
				
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet2", i, j);//1,0
				
				System.out.println(logindata[i-1][j]);
				
			}
			
		}
		
		return logindata;
		
	}  

}
