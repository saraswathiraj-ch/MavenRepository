package testNG;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;

public class TestNGClass {
	public static WebDriver driver;
	
	@BeforeTest
	  public void beforeClass() {
		 System.setProperty("webdriver.gecko.driver", "/Users/rajusaru/Desktop/Selenium/SoftwareDownloads/geckodriver");
			driver = new FirefoxDriver();
			driver.get("https://www.redmine.org/");
			driver.manage().window().maximize();
			System.out.println("Browser is opened");
	  }
	 @AfterTest
	  public void afterClass() {
		  
		driver.quit();
			System.out.println("Browser is Closed");
	  }

	
 
  
}
