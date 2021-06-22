package com.qa.tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mycom.qa.base.TestBase;
import com.mycom.qa.pages.CustomerPage;
import com.mycom.qa.pages.HomePage;
import com.mycom.qa.pages.LoginPage;
import com.mycom.qa.util.TestUtil;

public class CustomerPageTest  extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	CustomerPage customerPage;
	

	public CustomerPageTest() throws IOException {
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
		customerPage.customerPage();
		
	}
	
/*	@Test(priority=1)
	public void verifyCustomerTest() {
		
		customerPage.customerPage();
		
	}
	*/
	@Test(priority=1)
	public void verifyCustomerLoginTest() throws IOException, InterruptedException {
		
		//customerPage.customerPage();
		customerPage.customerLogin(prop.getProperty("Customername"),(prop.getProperty("Gender")),
				(prop.getProperty("Dateofbirth")),(prop.getProperty("Address")),(prop.getProperty("City")),
				(prop.getProperty("State")),(prop.getProperty("Pincode")),(prop.getProperty("Mobilenum")),
				(prop.getProperty("Emailid")),(prop.getProperty("PassWord")));
		Thread.sleep(5000);
	}
	
	
	@Test(priority=2)
	public void verifyLogoTest() {
		
		boolean actual=customerPage.verifytext();
//		String expected="Add New Customer";
//		assertEquals(actual,expected);
		System.out.println(actual);
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
	}
}
