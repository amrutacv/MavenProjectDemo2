package com.crm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.BaseTest;
import com.crm.qa.util.TestUtil;

public class HomePage extends BaseTest {
	@FindBy(xpath="//a[contains(@href,'contacts')]")
	WebElement contactsIcon;
	
	@FindBy(xpath="//a[contains(@href,'contacts')]//following-sibling::button")
	WebElement addContact;
	
	@FindBy(xpath="//div[text()='Contacts activity stream']")
	WebElement contactsActivityStream;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyHomePage() {
		return contactsActivityStream.isDisplayed();
	}
	
	public ContactsPage clickAddContact() throws InterruptedException {
		new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(contactsIcon));
		Actions action = new Actions(driver);
		action.moveToElement(contactsIcon).build().perform();
		new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(addContact));
		addContact.click();
		return new ContactsPage();
	}
}
