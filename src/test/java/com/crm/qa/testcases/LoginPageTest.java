package com.crm.qa.testcases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginpage;
	HomePage homePage;
	
	public LoginPageTest(){
		super();   //to call base class TestBase constructor
	}
	
	@BeforeSuite
	public void setUp(){
	    initialization(); //before this super() is called
	    loginpage=new LoginPage();
		}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title=loginpage.validateLoginPageTitle();
		//Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
		Assert.assertEquals(title, "OrangeHRM");
	}
	
	@Test(priority=2)
	public void crmlogoImageTest(){
		boolean flag=loginpage.validateCRMImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest(){
		//homePage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		//homePage=loginpage.login("shrikantcrm","freecrm@123");
		homePage=loginpage.login("admin","admin123");
	}
	
	@AfterSuite
	public void tearDown(){
		driver.quit();
	}
}
