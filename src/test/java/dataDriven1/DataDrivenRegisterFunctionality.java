package dataDriven1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataDrivenRegisterFunctionality {
	public static ChromeDriver driver;
	public static String ANSI_GREEN = "\u001B[32m";
	public static String ANSI_RED = "\u001B[31m";
	public static String ANSI_RESET = "\u001B[37m";
	public static String expectedtitle;
	public static String actualtitle;
	
	void callBrowser() {
		System.setProperty("webdriver.chrome.driver", "/Users/rajusaru/Desktop/Selenium/SoftwareDownloads/chromedriver_mac_arm64/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://demo.redmine.org");
		driver.manage().window().maximize();
		
	}
	
	void closeBrowser() {
		driver.quit();
	}
	
	void validateRegisterFunctionalitybyProvidingAllTheFields() {
		
		try{
		driver.findElement(By.linkText("Register")).click(); //click on Register Link
		driver.findElement(By.id("user_login")).sendKeys(DataForRegister.readData(1, 0)); //Enter login
		driver.findElement(By.id("user_password")).sendKeys("1234"); //Enter password
		driver.findElement(By.id("user_password_confirmation")).sendKeys("1234");//Enter Password Confirmation
		driver.findElement(By.id("user_firstname")).sendKeys(DataForRegister.readData(1, 1)); //Enter Firstname
		driver.findElement(By.id("user_lastname")).sendKeys(DataForRegister.readData(1, 4)); //Enter Lastname
		driver.findElement(By.id("user_mail")).sendKeys(DataForRegister.readData(1,8)); //Enter Email
		driver.findElement(By.name("commit")).click(); //Click Submit
		expectedtitle = "Your account has been activated. You can now log in.";
		WebElement message = driver.findElement(By.id("flash_notice"));
	    actualtitle = message.getText();
		}
		catch(Exception e) {
			System.out.println("I'm in Catch block");
		}
		//Validating
		if(expectedtitle.equals(actualtitle)) {
			System.out.println("Verify that user is able to create an account by providing all the fields is: "+  ANSI_GREEN +  "Passed" + ANSI_RESET);
			driver.findElement(By.linkText("Sign out")).click();
		}
		else {
			System.out.println("Verify that user is able to create an account by providing all the fields is: "+  ANSI_RED +  "Failed" + ANSI_RESET);
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataDrivenRegisterFunctionality datadriven=new DataDrivenRegisterFunctionality();
		
		datadriven.callBrowser();
		datadriven.validateRegisterFunctionalitybyProvidingAllTheFields();
		datadriven.closeBrowser();
	}

}
