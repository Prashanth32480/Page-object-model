package com.mycom.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mycom.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	
	@FindBy(name="uid")
	WebElement username;
	
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="btnLogin")
	WebElement loginBtn;
	
	@FindBy(xpath="//*[@id='site-name']/a")
	WebElement logoImg;
	
	public LoginPage() throws IOException {
		
		PageFactory.initElements(driver, this);
	}

	
	public boolean verifyLogo() {
		
		System.out.println(logoImg.getText());
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		return logoImg.isDisplayed();
	
	}
	
	public String getTitlePage() {
	
		return driver.getTitle();
		
	}
	
	public HomePage login(String un,String pwd) throws IOException {
		
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();
		
	}
}
