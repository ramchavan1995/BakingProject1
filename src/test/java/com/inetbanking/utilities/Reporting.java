package com.inetbanking.utilities;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;




public class Reporting extends TestListenerAdapter{
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	
	public void onStart(ITestContext testContext) {
		//System.out.println("hii 1");
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String reportName="TestExtent-Report-"+timestamp+".html";
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+reportName);
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"\\extent-config.xml");
		//htmlReporter.loadXMLConfig("E:\\Javap\\inetBankingV1\\extent-config.xml");
		
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("HostName", "LocalHost");
		extent.setSystemInfo("OS", "Window10");
		extent.setSystemInfo("Tester Name", "Lakhan");
		extent.setSystemInfo("Browser", "firefox");
		
		htmlReporter.config().setDocumentTitle("INetBankimgTestProject");//Title of the Report
		htmlReporter.config().setReportName("Functional Test Report");//Name of the Report
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
		
	
	//	System.out.println("abcjksknslkjjsll");
		
		
		
	}
	
	public void onTestSuccess(ITestResult tr) {
		System.out.println("hii 2");
	logger=extent.createTest(tr.getName());
	logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	
	
	}
	
	public void onTestFailure(ITestResult tr) {
		System.out.println("hii 3");
		logger=extent.createTest(tr.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		String screenshotpath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
		
		File f=new File( screenshotpath);
		
		if(f.exists()) {
			try {
			logger.fail("screenshot is below:"+logger.addScreenCaptureFromPath(screenshotpath));
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void onTestSkipped(ITestResult tr) {
		System.out.println("hii 4");
		logger=extent.createTest(tr.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}
	
	
	public void onFinish(ITestContext textcontext) {
		System.out.println("hii 5");
		extent.flush();
	}


}
