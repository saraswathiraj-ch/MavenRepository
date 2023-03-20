/*Validating Register Functionality of RedmineDemoProject*/

package seleniumScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterFunctionalityTestCase {
	public static ChromeDriver driver; 
	public static String expectedtitle, actualtitle;

	
	void callBrowser() { //Method for Calling Browser
		System.setProperty("webdriver.chrome.driver", "/Users/rajusaru/Desktop/Selenium/SoftwareDownloads/chromedriver_mac_arm64/chromedriver");
		driver =new ChromeDriver(); //Call the browser
		driver.get("http://demo.redmine.org/"); // Call the Redmine URL in the browser
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Register")).click(); //click on Register Link//Maximize the Window
	}
	
	void quitBrowser() { //Method for Quiting Browser
		driver.quit(); //Close the Browser
	}
	

	/*TestCase12 - "Validate registering functionality by navigating back after Successfull User Resgistrtion"
	1.Open a browser
	2.Open the URL(http://demo.redmine.com)
	3.Click on  Register.
	4.Enter new account details into all Fields except Confirmation(Login, Password, First name, Last name).
	5.Click on Submit Button.
	6.Click back button.
	 */
	void validateRegisterFunctionalitybyNavigateBackAfterSuccessUserRegistrtion() 
	{
		try {
		driver.findElement(By.linkText("Register")).click(); //click on Register Link
		driver.findElement(By.id("user_login")).sendKeys("Sarayu67"); //Enter login
		driver.findElement(By.id("user_password")).sendKeys("1234"); //Enter password
		driver.findElement(By.id("user_password_confirmation")).sendKeys("1234");//Enter Password Confirmation
		driver.findElement(By.id("user_firstname")).sendKeys("Sarayu67"); //Enter Firstname
		driver.findElement(By.id("user_lastname")).sendKeys("Singamsetty"); //Enter Lastname
		driver.findElement(By.id("user_mail")).sendKeys("sarayu67@gmail.com"); //Enter Email
		driver.findElement(By.name("commit")).click(); //Click Submit errorExplanation
		
		driver.navigate().back(); // Navigate Back Command
		expectedtitle = "Sarayu65"; //expected URL
	    WebElement title = driver.findElement(By.xpath("//a[@class='user active']")); //Get Current URL from current page
	    actualtitle = title.getText();
	    System.out.println(actualtitle);
		}
	catch(Exception e) 
		{
		System.out.println("I'm in catch block");
		
		//validate
	    if(expectedtitle.equals(actualtitle)) 
	    {
			System.out.println("Validate registering functionality by navigating back after Successfull User Resgistrtion: Passed");
		}
		else {
			System.out.println("Validate registering functionality by navigating back after Successfull User Resgistrtion: Failed");
			
		}
	}
}	
	
	// Main Method
	public static void main(String[] args) {
		
		//Create an Object to call all methods in the class RFTestCase
		RegisterFunctionalityTestCase RF =new RegisterFunctionalityTestCase();
		
		//Calling All Methods to implement TestCases
		RF.callBrowser();
		/*RF.validateRegisterFunctionalitybyProvidingAllTheFields();
		RF.validateRegisterFunctionalitybyProvidingAllBlankSpaces();
		RF.validateRegisterFunctionalitybyFillingDifferentPasswordsIntoPasswordAndConfirmation();
		RF.validateRegisterFunctionalitybyProvidingInvalidEmailID();
		RF.validateRegisterFunctionalitybyProvidingAlreadyExisingAccountDetails();
		RF.validateRegisterFunctionalitybyProvidingAllFieldsExceptLogin();
		RF.validateRegisterFunctionalitybyProvidingAllFieldsExceptFirstName();
		RF.validateRegisterFunctionalitybyProvidingAllFieldsExceptLastName();
		RF.validateRegisterFunctionalitybyProvidingAllFieldsExceptEmailId();
		RF.validateRegisterFunctionalitybyProvidingAllFieldsExceptPassword();
		RF.validateRegisterFunctionalitybyProvidingAllFieldsExceptConfirmation();
		*/
		RF.validateRegisterFunctionalitybyNavigateBackAfterSuccessUserRegistrtion();
		RF.quitBrowser();
		
		 
	}

}
