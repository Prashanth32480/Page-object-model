package com.qa.tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mycom.qa.base.TestBase;
import com.mycom.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;

	public LoginPageTest() throws IOException {
		
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException{
		
		initialization();
		loginPage=new LoginPage();
		
	}
	
	
	@Test
	public void verifyLogoTest() {
		
		loginPage.verifyLogo();
	}
	
	@Test
	public void verifyLoginTest() throws IOException {
		
		loginPage.login(prop.getProperty("UserID"), prop.getProperty("Password"));
		
	}
	
	
	@Test
	public void verifyTitleTest() {
		
		loginPage.getTitlePage();
	}
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
	
}
