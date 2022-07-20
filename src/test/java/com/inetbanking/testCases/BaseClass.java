package com.inetbanking.testCases;



import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.inetbanking.utilities.ReadConfig;
import com.inetbanking.utilities.Reporting;


public class BaseClass {
	
	
	ReadConfig  readconfig=new ReadConfig ();
	
	public String baseURL=readconfig.getApplicationUrl();
	public String username=readconfig.getUserName();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	public ExtentReports extent;
	
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {
		
		logger=Logger.getLogger(BaseClass.class);
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome")) {
	     //System.setProperty(" webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
	
		System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
		driver=new ChromeDriver();
		}
	else if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.getFirePath());
		driver=new FirefoxDriver();
			
		}
		
	
		
		driver.get(baseURL);
//		
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver,String tname) throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("screenshot taken");
	}
	
	public String randomstring() {
		String generatedstring=RandomStringUtils.randomAlphabetic(15);
		return(generatedstring);
	}
	
	public static String randomnum() {
		String generatedstring2=RandomStringUtils.randomNumeric(8);
		return(generatedstring2);
	}
	
	
	

}
