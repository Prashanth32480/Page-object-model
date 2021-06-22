package com.mycom.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mycom.qa.base.TestBase;

public class DeleteCustomerPage extends TestBase {
	
	//"/html/body/div[3]/div/ul/li[4]/a
	@FindBy(xpath="/html/body/div[3]/div/ul/li[4]/a")
	WebElement deletecustomer;
	
	@FindBy(name="cusid")
	WebElement customerid;
	
	@FindBy(name="AccSubmit")
	WebElement submitBtn;
	
	
	@FindBy(xpath="//p[contains(text(),'Delete Customer Form')]")
	WebElement logo;
	
	@FindBy(name="res")
	WebElement resetBtn;
	
	public DeleteCustomerPage() throws IOException {
		
		PageFactory.initElements(driver, this);
	}
	
	public void deleteCustomerPage() {
		
		deletecustomer.click();
	}
	
	public HomePage delete(String id) throws IOException {
		
		customerid.sendKeys(id);
		submitBtn.click();
		return new HomePage();
	}
	
	public boolean verifyText() {
		
		System.out.println(logo.getText());
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println(resetBtn.isEnabled());
		return logo.isDisplayed();
	}

	
	
}
