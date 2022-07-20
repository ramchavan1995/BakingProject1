package com.inetbanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
		
	}
	
	@FindBy(how=How.XPATH,using="/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement lnkAddNewCustomer;
	
//	@FindBy(how=How.ID,using="dismiss-button")
//	@CacheLookup
//	WebElement txtCustPage ;
	
	
	@FindBy(how=How.NAME,using="name")
	@CacheLookup
	WebElement txtCustomerName ;
	
	@FindBy(how=How.NAME,using="rad1")
	@CacheLookup
	WebElement rdGender ;
	
	@FindBy(how=How.ID_OR_NAME,using="rad1")
	@CacheLookup
	WebElement txtdob;
	
	@FindBy(how=How.NAME,using="addr")
	@CacheLookup
	WebElement txtaddress ;
	
	@FindBy(how=How.NAME,using="city")
	@CacheLookup
	WebElement txtcity ;
	
	@FindBy(how=How.NAME,using="state")
	@CacheLookup
	WebElement txtstate ;
	
	@FindBy(how=How.NAME,using="pinno")
	@CacheLookup
	WebElement txtpin;
	
	@FindBy(how=How.NAME,using="telephoneno")
	@CacheLookup
	WebElement txttelephoneno;
	
	@FindBy(how=How.NAME,using="emailid")
	@CacheLookup
	WebElement txtemailid;
	
	@FindBy(how=How.NAME,using="password")
	@CacheLookup
	WebElement txtpassword;
	
	@FindBy(how=How.NAME,using="sub")
	@CacheLookup
	WebElement btnsubmit;
	
	public void CilckAddNewCustomer() {
		lnkAddNewCustomer.click();
		
	}
	
	
//	public void CilckAdPage() {
//		txtCustPage.click();
//		
//	}
	
	

	public void custName(String cname) {
		txtCustomerName.sendKeys(cname);
		
	}
	

	public void custGender(String cgender) {
		rdGender.click();
		
	}
	

	public void cusdob(String mm,String dd,String yy) {
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
		
	}
	

	public void custAddress(String caddress) {
		txtaddress.sendKeys(caddress);
		
	}
	

	public void custCity(String ccity) {
		txtcity.sendKeys(ccity);	
		
	}
	
	public void custState(String cstate) {
		txtstate.sendKeys(cstate);	
		
	}
	
	public void custPin(String cpin) {
		txtpin.sendKeys(String.valueOf(cpin));	//convert all data type in String by used valueOf method
		
	}
	
	public void custTelephoneNo(String ctelephoneno) {
		txttelephoneno.sendKeys(ctelephoneno);	
		
	}
	
	public void custEmailId(String cemailid) {
		txtemailid.sendKeys(cemailid);
		
	}
	
	public void custPassword(String cpass) {
		 txtpassword.sendKeys(cpass);	
		
	}
	
	public void custSubmit() {
		btnsubmit.click();
		
	}

}
