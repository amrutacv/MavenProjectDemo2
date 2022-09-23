package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.crm.qa.util.TestUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public static WebDriver driver;
	public static Properties prop;
	public BaseTest() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void initialize() {
//		System.setProperty("browser", "chrome");
		if(System.getProperty("browser").toUpperCase().equals("CHROME")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.addArguments("enable-automation");
			driver = new ChromeDriver(options);
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.pageLoadTimeOut, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.implicitlyWait, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
		}
		else {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.addArguments("enable-automation");
			driver = new ChromeDriver(options);
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.pageLoadTimeOut, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.implicitlyWait, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
		}
		
	}
}
