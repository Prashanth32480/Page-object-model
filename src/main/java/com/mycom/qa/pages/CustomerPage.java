package com.mycom.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mycom.qa.base.TestBase;

public class CustomerPage extends TestBase {
	
	@FindBy(xpath="//a[contains(text(),'New Customer')]")
	WebElement customer;
	
	@FindBy(name="name")
	WebElement customername;
	
	@FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]")
	WebElement gender;
//	
//	@FindBy(name="dob")
//	WebElement dateofbirth;
	
	@FindBy(name="addr")
	WebElement address;
	
	@FindBy(name="city")
	WebElement city;
	
	@FindBy(name="state")
	WebElement state;
	
	@FindBy(name="pinno")
	WebElement pincode;
	
	@FindBy(name="telephoneno")
	WebElement phonenum;
	
	@FindBy(name="emailid")
	WebElement emailid;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="sub")
	WebElement submitBtn;
	
	@FindBy(xpath="//p[contains(text(),'Add New Customer')]")
	WebElement logo;
	

	@FindBy(name="res")
	WebElement resetBtn;

	public CustomerPage() throws IOException {
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void customerPage() {
		
		customer.click();
	}
	public boolean verifytext() {
		
		System.out.println(logo.getText());
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println(resetBtn.isEnabled());
		return logo.isDisplayed();
	}
	
	public HomePage customerLogin(String cn,String gd,String dob,String add,String st,String cy,String pin,String phoneno,String mailid,String pwd ) throws IOException {
		
		customername.sendKeys(cn);
		gender.click();
//		Select date=new Select(dateofbirth);
//		date.selectByVisibleText(dob);
		address.sendKeys(add);
		city.sendKeys(cy);
		state.sendKeys(st);
		pincode.sendKeys(pin);
		phonenum.sendKeys(phoneno);
		emailid.sendKeys(mailid);
		password.sendKeys(pwd);
		submitBtn.click();
		
		return new HomePage();
	}

}
