package com.qa.tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mycom.qa.base.TestBase;
import com.mycom.qa.pages.HomePage;
import com.mycom.qa.pages.LoginPage;
import com.mycom.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;

	public HomePageTest() throws IOException {
		
		super();
		
	}
	
	@BeforeMethod
	public void setUp() throws IOException {
		
		initialization();
		loginPage=new LoginPage();
		testUtil=new TestUtil();
		homePage=loginPage.login(prop.getProperty("UserID"), prop.getProperty("Password"));
	}
	
	@Test
	public void verifyManagerTest() {
		
		homePage.managerIsDisplayed();
	}
	
	@Test
	public void verifyTitleTest() {
		
		String actual = homePage.titlePage();
	//	System.out.println(actual);
		String expectedTitle="Guru99 Bank Manager HomePage";
		assertEquals(actual,expectedTitle,"not matched title");
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}

}
