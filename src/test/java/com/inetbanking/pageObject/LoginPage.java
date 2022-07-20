package com.inetbanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	public LoginPage(WebDriver rdriver){
		 
		 ldriver=rdriver;
		 PageFactory.initElements(rdriver, this);
	 }
	
	@FindBy(how=How.NAME,using="uid")
	WebElement txtUserName;
	
	@FindBy(how=How.NAME,using="password")
	WebElement txtPassword ;
	
	@FindBy(how=How.NAME,using="btnLogin")
	WebElement  btnLogin ;

	 
//	@FindBy(xpath="/html/body/form/table/tbody/tr[1]/td[2]/input")
//	WebElement txtUserName;
//	 
//	 @FindBy(xpath="/html/body/form/table/tbody/tr[2]/td[2]/input")
//	 @CacheLookup
//	 WebElement txtPassword;
//	 
//	 @FindBy(name="btnLogin")
//	 @CacheLookup
//	 WebElement btnLogin;
	 
	 @FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")   //    xpath=  /html/body/div[3]/div/ul/li[15]/a
	 @CacheLookup
	 WebElement lnkLogout;
	 
	 
	 
	 //Action method is done
	 public void setUserName(String uname) {
		 System.out.println(uname);
		txtUserName.sendKeys(uname);
		System.out.println(uname);
		 
	 }
	 
	 public void setPassword(String pwd) {
		 System.out.println(pwd);
		 txtPassword.sendKeys(pwd);
		 System.out.println(pwd);
	 }
	 
	 public void clickSubmit() {
		 btnLogin.click();
	 }
	 
	 public void clickLogout() {
		 lnkLogout.click();
	 }

	

}
