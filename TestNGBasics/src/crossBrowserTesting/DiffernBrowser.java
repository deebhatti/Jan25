package crossBrowserTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DiffernBrowser {
	public static void main(String[] args) {
//		System.setProperty("webdriver.chrome.driver", "C:\\Webdrivers\\chromedriver_win32\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		
//		driver.manage().window().maximize();
//		driver.get("https://facebook.com");
		
//		System.setProperty("webdriver.edge.driver","NAmeof theFile");
//		WebDriver driver = new EdgeDriver();
		
		System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.get("https://facebook.com");
		
	}

}
