package com.mycom.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mycom.qa.base.TestBase;

public class EditAccountPage extends TestBase {
	
	
	@FindBy(xpath="//a[contains(text(),'Edit Account')]")
	WebElement editAccount;
	
	@FindBy(name="accountno")
	WebElement accountNo;
	
	@FindBy(name="AccSubmit")
	WebElement  submitBtn;
	
	@FindBy(xpath="//p[contains(text(),'Edit Account Form')]")
	WebElement logo;
	
	@FindBy(name="res")
	WebElement resetBtn;

	public EditAccountPage() throws IOException {
		
		PageFactory.initElements(driver, this);
	}

	
	public void editaccountpage() {
		
		editAccount.click();
	}
	
	
	
	public boolean editlogo() {
		
		System.out.println(logo.getText());
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println(resetBtn.isEnabled());
		return logo.isDisplayed();
		
	}
	
	
	public HomePage editAccountLogin(String accntNo) throws IOException {
		
		accountNo.sendKeys(accntNo);
		submitBtn.click();
		return new HomePage();
		
	}
	
	
	
	
}
