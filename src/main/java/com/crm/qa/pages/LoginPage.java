package com.crm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BaseTest;
import com.crm.qa.util.TestUtil;

public class LoginPage extends BaseTest{
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement pwd;
	
	@FindBy(xpath="//div[contains(text(),'Login')]")
	WebElement login;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyLoginPage() {
		return username.isDisplayed();
	}
	public HomePage login(String user,String password) {
		username.sendKeys(user);
		pwd.sendKeys(password);
		login.click();
		return new HomePage();
	}
}
