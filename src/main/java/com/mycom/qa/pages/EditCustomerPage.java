package com.mycom.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mycom.qa.base.TestBase;

public class EditCustomerPage extends TestBase  {
	
	
	@FindBy(xpath="//a[contains(text(),'Edit Customer')]")
	WebElement Editcustomer;
	
	@FindBy(name="cusid")
	WebElement customerid;
	
	@FindBy(name="AccSubmit")
	WebElement submitBtn;
	
	@FindBy(xpath="//p[contains(text(),'Edit Customer Form')]")
	WebElement logo; 
	
	@FindBy(name="res")
	WebElement resetBtn;
	
	public EditCustomerPage() throws IOException {
	
		PageFactory.initElements(driver, this);
	}
	

	public void  editcustomer() {
		
		Editcustomer.click();
	}
	
	public HomePage enterId(String id) throws IOException {
		
		customerid.sendKeys(id);
		submitBtn.click();
		
		return new HomePage();
		
	}
	
	public  boolean verifyLogo() {
		
		System.out.println(logo.getText());
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println(resetBtn.isEnabled());
		return logo.isDisplayed();
	}
	
}
