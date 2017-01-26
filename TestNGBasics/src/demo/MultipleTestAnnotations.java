package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MultipleTestAnnotations {
	WebDriver driver;
	
	@BeforeMethod
	public void openBrowser(){
		driver = new FirefoxDriver();		
		driver.manage().window().maximize();		
		driver.get("https://www.facebook.com/");
	}
	
	@Test(priority=0,invocationCount=5)
	public void verifyTitle(){
		String expectedTitle = "Facebook - Log In or Sign Up";		
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test(priority=2,enabled=false)
	public void verifyText(){
		String expectedText = "Facebook helps you connect and share with the people in your life.";
		String actualText = driver.findElement(By.xpath("//*[@id='content']/div/div/div/div/div[1]/div/div")).getText();
		Assert.assertEquals(actualText, expectedText);
	}
	
	@Test(priority=1)
	public void verifyText2(){
		String expectedText = "Create an account";
		String actualText = driver.findElement(By.xpath("//*[@id='content']/div/div/div/div/div[2]/div[1]/div[1]/span")).getText();
		Assert.assertEquals(actualText, expectedText);
	}
	
	@AfterMethod
	public void closeBrowser(){
		driver.close();
	}

}
