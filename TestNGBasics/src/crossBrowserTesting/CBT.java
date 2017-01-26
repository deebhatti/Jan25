package crossBrowserTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CBT {
WebDriver driver;
	
	@BeforeTest
	@Parameters("browser")
	public void openBrowser(String browser){
		if(browser.equals("Firefox")){
			driver = new FirefoxDriver();
		}
		
		else if (browser.equals("Chrome")){
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if(browser.equals("Internet Explorer")){
			System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}		
		
		driver.manage().window().maximize();		
		driver.get("https://www.facebook.com/");
	}
	
	@Test
	public void testTitle(){
		String expectedTitle = "Facebook - Log In or Sign Up";		
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@AfterTest
	public void closeBrowser(){
		driver.close();
	}

}
