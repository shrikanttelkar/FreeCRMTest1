package com.crm.qa.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
//import com.infy.app.util.BrowserLevelUtil;

public class LoginPage extends TestBase{

	//Page factory or Object Repository :
	
	//@FindBy(name="username") 
	@FindBy(id="txtUsername")
	WebElement username;
	
	//@FindBy(name="password") 
	@FindBy(id="txtPassword")
	WebElement password;
	
	//@FindBy(xpath="//input[@type='submit']") 
	@FindBy(id="btnLogin")
	WebElement loginBtn;
	
	//@FindBy(linkText="Sign Up") 
	
	WebElement signUpBtn;
	@FindBy(xpath="//img[contains(@class='img-responsive')]") WebElement crmlogo;
	
	//Initialize Page Object :
	public LoginPage(){
		
		PageFactory.initElements(driver, this); 
		//PageFactory.initElements(driver, LoginPage.class);
	}
	
	//Actions :
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateCRMImage(){
		return crmlogo.isDisplayed();
	}
	
	
	public HomePage login(String un,String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();      //after click it redirect to HomePage so we write return HomePage
		
		return new HomePage();
	}
}
