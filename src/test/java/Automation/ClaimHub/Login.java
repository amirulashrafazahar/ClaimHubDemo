package Automation.ClaimHub;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import TestUtils.Retry;

import Automation.pageobjects.LandingPage;
import Automation.pageobjects.MainPage;
import TestUtils.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login extends BaseTest {
	
	@Test(dataProvider="getData", groups= {"UAT"}, retryAnalyzer=Retry.class)
	public void LoginTest(HashMap<String, String> input) throws IOException
	{
		landingPage.scrollDown(100);
		landingPage.loginApplication(input.get("username"), input.get("password"));
        
		String loginSuccessMessage = driver.findElement(By.cssSelector(".post-title")).getText();
		System.out.println("Login Success Message: " + loginSuccessMessage);
		Assert.assertTrue(loginSuccessMessage.equalsIgnoreCase("Logged In Successfully"), "The login success message is not as expected.");

		MainPage logoutPage = new MainPage(driver);
        logoutPage.logout();
        
        String logoutSuccessMessage = driver.findElement(By.cssSelector("section[id='login'] h2")).getText();
		System.out.println("Logout Success Message: " + logoutSuccessMessage);
		Assert.assertTrue(logoutSuccessMessage.equalsIgnoreCase("Test login"), "The logout success message is not as expected.");
         
	}	
	
	@DataProvider
	public Object[] [] getData() throws IOException
	{
		List<HashMap<String,String>> data = getJsonDataToMap("C:\\Users\\posab\\OneDrive\\Documents\\POSABLE\\Documents\\Automation\\Interview\\ClaimHub\\ClaimHub\\src\\test\\java\\data\\login.json");
		return new Object[] [] {{data.get(0)}} ;
		
	}

}
