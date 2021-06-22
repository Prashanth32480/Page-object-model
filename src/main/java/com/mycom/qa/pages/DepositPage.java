package com.mycom.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mycom.qa.base.TestBase;

public class DepositPage extends TestBase {
		
	@FindBy(xpath="//a[contains(text(),'Deposit')]")
	WebElement deposit;
		
	@FindBy(name="accountno")
	WebElement accountno;
		
	@FindBy(name="ammount")
	WebElement amount;
		
	@FindBy(name="desc")
	WebElement description;
		
	@FindBy(name="AccSubmit")
	WebElement submitBtn;
	
	@FindBy(xpath="//p[contains(text(),'Amount Deposit Form')]")
	WebElement logo;
	
	@FindBy(name="res")
	WebElement resetBtn;

	public  DepositPage() throws IOException {
		
		PageFactory.initElements(driver, this);
	}

		
	public void depositpage() {
			
		deposit.click();
	}
		
	public boolean verifylogoTest() {
			
		System.out.println(logo.getText());
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		resetBtn.isEnabled();
		return logo.isDisplayed();
			
	}

	public HomePage depositAmount(String accno, String amm, String desc) throws IOException {
		
		accountno.sendKeys(accno);
		amount.sendKeys(amm);
		description.sendKeys(desc);
		submitBtn.click();
		return new HomePage();
	
	}

}
