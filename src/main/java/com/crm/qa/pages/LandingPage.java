package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BaseTest;

public class LandingPage extends BaseTest{
	@FindBy(xpath="//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")
	WebElement login;
	
	@FindBy(xpath="//a[@title='free crm home']")
	WebElement logo;
	
	public LandingPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyLandingPageDisplayed() {
		return logo.isEnabled();
	}
	public LoginPage clickLogin() {
		login.click();
		return new LoginPage();
	}
	
}
