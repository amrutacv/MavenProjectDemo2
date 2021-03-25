package com.crm.qa.testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 {

	public static WebDriver driver;
	
	@FindBy(xpath="//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")
	public static WebElement login;
	
	@FindBy(name="email")
	public static WebElement username;
	
	@FindBy(name="password")
	public static WebElement pwd;
	
	@FindBy(css=".ui fluid large blue submit button")
	public static WebElement loginBtn;
	public Test1() {
		
		PageFactory.initElements(driver, this);
	}
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("enable-automation");
		Test1.driver = new ChromeDriver(options);
		Test1.driver.manage().deleteAllCookies();
		Test1.driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		Test1.driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Test1.driver.get("https://www.freecrm.com/");
		Test1.login.click();
		Test1.username.sendKeys("a");
	}

}
