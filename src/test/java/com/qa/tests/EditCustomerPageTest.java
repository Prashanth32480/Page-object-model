package com.qa.tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mycom.qa.base.TestBase;
import com.mycom.qa.pages.CustomerPage;
import com.mycom.qa.pages.EditCustomerPage;
import com.mycom.qa.pages.HomePage;
import com.mycom.qa.pages.LoginPage;
import com.mycom.qa.util.TestUtil;

public class EditCustomerPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	CustomerPage customerPage;
	EditCustomerPage editCustomerPage;

	public EditCustomerPageTest() throws IOException {
		
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException {
		
		initialization();
		loginPage=new LoginPage();
		homePage=new HomePage();
		homePage=loginPage.login(prop.getProperty("UserID"), prop.getProperty("Password"));
		testUtil=new TestUtil();
		customerPage=new CustomerPage();
		editCustomerPage=new EditCustomerPage();
		editCustomerPage.editcustomer();
		
	}
	
	@Test
	public void  verifyLogoTest() {
	
		boolean actual=editCustomerPage.verifyLogo();
		System.out.println(actual);
	}
	
	@Test
	public void verifyEditCustomerTest() throws IOException {
		
		editCustomerPage.enterId(prop.getProperty("CustomerId"));
		
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}

}
