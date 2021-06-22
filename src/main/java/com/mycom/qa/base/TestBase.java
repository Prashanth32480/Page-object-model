package com.mycom.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.mycom.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	public TestBase() throws IOException {
		
		try {
		prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\chamarthi.anusha\\AnushaEclipse-Workspace\\Practice\\src\\"
				                                +"main\\java\\com\\mycom\\qa\\config\\config.properties");
		prop.load(fis);
		
		}catch(FileNotFoundException fexc) {
			fexc.printStackTrace();
		}catch(IOException iexc) {
			iexc.printStackTrace();
		}
		
	}
	
	public static void initialization(){
		
		String browserName=prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			
			System.setProperty("webDriver.chrome.driver", "C:\\Selenium\\chromedriver\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browserName.equals("FF")) {
			
			System.setProperty("webDriver.gecko.driver", "C:\\Selenium\\geckodriver\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}

}
