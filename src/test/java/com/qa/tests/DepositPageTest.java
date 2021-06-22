package com.qa.tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mycom.qa.base.TestBase;
import com.mycom.qa.pages.AccountPage;
import com.mycom.qa.pages.CustomerPage;
import com.mycom.qa.pages.DeleteAccountPage;
import com.mycom.qa.pages.DeleteCustomerPage;
import com.mycom.qa.pages.DepositPage;
import com.mycom.qa.pages.EditAccountPage;
import com.mycom.qa.pages.EditCustomerPage;
import com.mycom.qa.pages.HomePage;
import com.mycom.qa.pages.LoginPage;
import com.mycom.qa.util.TestUtil;

public class DepositPageTest  extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	CustomerPage customerPage;
	EditCustomerPage editCustomerPage;
	DeleteCustomerPage deleteCustomerPage;
	AccountPage accountPage;
	EditAccountPage editAccountPage;
	DeleteAccountPage deleteAccountPage;
	DepositPage depositPage;

	public DepositPageTest() throws IOException {
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
		accountPage=new AccountPage();
		editAccountPage=new EditAccountPage();
		deleteAccountPage=new DeleteAccountPage();
		depositPage=new DepositPage();
		depositPage.depositpage();
		
	}
	
	
	@Test
	public void verifylogoTest() {
		
		depositPage.verifylogoTest();
	}
	
	@Test
	public void verifyamountdepositTest() throws IOException {
		
		depositPage.depositAmount(prop.getProperty("DepositAccountNo"),
				(prop.getProperty("Amount")),(prop.getProperty("Description")));
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
	
}
	
	
	
	
	
	