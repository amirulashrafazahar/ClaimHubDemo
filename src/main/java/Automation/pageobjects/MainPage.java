package Automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
	
	WebDriver driver;
	
	public MainPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[normalize-space()='Log out']")
	WebElement logOut;

	
	public void logout()
	{
		logOut.click();
	}
	
	
}
