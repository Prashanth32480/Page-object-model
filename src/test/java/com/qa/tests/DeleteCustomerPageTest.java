package com.qa.tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mycom.qa.base.TestBase;
import com.mycom.qa.pages.CustomerPage;
import com.mycom.qa.pages.DeleteCustomerPage;
import com.mycom.qa.pages.EditCustomerPage;
import com.mycom.qa.pages.HomePage;
import com.mycom.qa.pages.LoginPage;
import com.mycom.qa.util.TestUtil;

public class DeleteCustomerPageTest  extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	CustomerPage customerPage;
	EditCustomerPage editCustomerPage;
	DeleteCustomerPage deleteCustomerPage;

	public DeleteCustomerPageTest() throws IOException {
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
		deleteCustomerPage =new DeleteCustomerPage();
		deleteCustomerPage.deleteCustomerPage();
	}
	
	@Test
	public void verifyLogoTest() {
		
		boolean actual = deleteCustomerPage.verifyText();
		System.out.println(actual);
	}
	
	@Test
	public void verifyDeleteCustomerTest() throws IOException {
		
		deleteCustomerPage.delete(prop.getProperty("Customerid"));
	}
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
	
	

}
