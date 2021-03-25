package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement pwd;
	
	@FindBy(css=".ui fluid large blue submit button")
	WebElement login;
	
	public HomePage login(String user,String password) {
		username.sendKeys(user);
		pwd.sendKeys(password);
		login.click();
		return new HomePage();
	}
}
