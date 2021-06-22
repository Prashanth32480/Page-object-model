package com.mycom.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mycom.qa.base.TestBase;

public class DeleteAccountPage extends TestBase {
	
	
	@FindBy(xpath="//a[contains(text(),'Delete Account')]")
	WebElement deleteAccount;
	
	
	@FindBy(name="accountno")
	WebElement accountnum;
	
	
	@FindBy(name="AccSubmit")
	WebElement submitBtn;
	
	
	@FindBy(xpath="//p[contains(text(),'Delete Account Form')]")
	WebElement logo;

	
	@FindBy(name="res")
	WebElement resetBtn;
	

	public DeleteAccountPage() throws IOException {
		
		PageFactory.initElements(driver,this);
	}
	
	public void deleteaccount() {
		
		deleteAccount.click();
	}
	
	
	public boolean deleteaccountlogo() {
		
		System.out.println(logo.getText());
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println(resetBtn.isEnabled());
		return logo.isDisplayed();
		
	}
	
	
	public HomePage deleteAccount(String accNum) throws IOException {
		
		accountnum.sendKeys(accNum);
		submitBtn.click();
		return new HomePage();
	}

}
