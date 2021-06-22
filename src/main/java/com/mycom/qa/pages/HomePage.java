package com.mycom.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mycom.qa.base.TestBase;

public class HomePage extends TestBase {
	
	
	@FindBy(xpath="//a[contains(text(),'Manager')]")
	WebElement manager;
	
	@FindBy(xpath="//a[contains(text(),'New Customer')]")
	WebElement customer;
	
	

	public HomePage() throws IOException {
		
		PageFactory.initElements(driver, this);
	}
	
	public boolean managerIsDisplayed() {
		
		System.out.println(manager.getText());
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		return manager.isDisplayed();
		
	}
	
	public String titlePage() {
		
		return driver.getTitle();
	
	}

}
