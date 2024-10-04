package Automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="username")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement userPassword;
	
	@FindBy(id="submit")
	WebElement submit;
	
	public void goTo()
	{
		driver.get("https://practicetestautomation.com/practice-test-login/");
	}
	
	public void loginApplication(String username, String password)
	{
		userName.sendKeys(username);
		userPassword.sendKeys(password);
		submit.click();
	}
	
	public void scrollDown(int pixels) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0, " + pixels + ");");
	}

	
}
