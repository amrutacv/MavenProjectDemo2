package com.crm.qa.testCases;

import java.util.Map;

import org.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseTest;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LandingPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class LoginPageTest extends BaseTest{
	LandingPage landingPage;
	LoginPage loginPage;
	HomePage homePage;
	String sheetName = "Login";
	public LoginPageTest() {
		super();
	}
	@BeforeMethod()
	public void launch() {
		initialize();
		landingPage = new LandingPage();
		Assert.assertTrue(landingPage.verifyLandingPageDisplayed(),"CRM application not launched");
		loginPage = landingPage.clickLogin();
		Assert.assertTrue(loginPage.verifyLoginPage(),"Login page not displayed");
	}
	
	@DataProvider(name = "data")
	public Object[][] getCRMTestData() throws InvalidFormatException{
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(dataProvider = "data")
	 public void loginTest(Map<Object,Object> map) {
		 homePage = loginPage.login(map.get("Username").toString(), map.get("Password").toString());
		 Assert.assertTrue(homePage.verifyHomePage(),"User not logged in");
	 }
	 
	 @AfterMethod()
	 public void tearDown() {
		 driver.quit();
	 }
}
