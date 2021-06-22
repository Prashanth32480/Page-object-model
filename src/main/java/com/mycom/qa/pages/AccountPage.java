package com.mycom.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mycom.qa.base.TestBase;

public class AccountPage extends TestBase {
	
	
	@FindBy(xpath="//a[contains(text(),'New Account')]")
	WebElement account;
	
	@FindBy(name="cusid")
	WebElement customerid;
	
	@FindBy(name="selaccount")
	WebElement  accounttype;
	
	@FindBy(name="inideposit")
	WebElement deposit;
	
	@FindBy(name="button2")
	WebElement submitBtn;
	
	@FindBy(xpath="//p[contains(text(),'Add new account form')]")
	WebElement logo;
	
	@FindBy(name="reset")
	WebElement resetBtn;

	public AccountPage() throws IOException {
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void accountpage() {
		
		account.click();
	}
	
	public boolean accountpagelogo() {
	     
		System.out.println(logo.getText());
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println(resetBtn.isEnabled());
		return logo.isDisplayed();
	}
	
	
	public HomePage accountLogin(String custid,String acctype,String amount) throws IOException {
		
		customerid.sendKeys(custid);
		Select type=new Select(accounttype);
		type.selectByVisibleText(acctype);
		deposit.sendKeys(amount);
		submitBtn.click();
		return new HomePage();
		
		
	}
	
	
	

}
