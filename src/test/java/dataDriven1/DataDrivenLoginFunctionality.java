package dataDriven1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataDrivenLoginFunctionality {

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
	
	/*TestCase 1 - "Validate logging into the application using valid credentials"
 	1. Open a browser
	2. Open the URL(http://demo.redmine.com)
	3. Enter valid email address into the 'E-Mail Address' field 
	4. Enter valid password into the 'Password' field
	5. Click on 'Login' button
	*/
 
	void validateLoggingwithValidCredentials() {
		
		try {
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.id("username")).sendKeys(DataForLogin.readData(1, 2)); //login
		driver.findElement(By.id("password")).sendKeys(DataForLogin.readData(1, 3));		//password
		driver.findElement(By.name("login")).click();
		expectedtitle = "My account - Redmine demo"; //expected Message
		driver.findElement(By.cssSelector("div[id='account']>ul>li>a[class='my-account']")).click();
		actualtitle = driver.getTitle(); //Get Current Title
	    
	    /*String url = driver.getCurrentUrl(); //Get Current URL Command
	    System.out.println(url);*/
	    
	   
		}
		catch(Exception e) {
			System.out.println("I'm in Catch 1 Block");
			 
		}
			//System.out.println(actualtitle);
			if(expectedtitle.equalsIgnoreCase(actualtitle)) {
				System.out.println("Validate logging into the Application using valid Username and valid Password: "+  ANSI_GREEN +  "Passed" + ANSI_RESET);
				driver.findElement(By.linkText("Sign out")).click();
			}
			else {
				System.out.println("Validate logging into the Application using valid Username and valid Password: "+  ANSI_RED +  "Failed" + ANSI_RESET);
				
			}
		
	
		
		
	}

	/*TestCase 2 - "Validate logging into the Application using invalid email and invalid password."
		1. Open a browser
	2. Open the URL(http://demo.redmine.com)
	3. Enter invalid email address into the 'E-Mail Address' field 
	4. Enter invalid password into the 'Password' field
	5. Click on 'Login' button
	*/
	void validateLoggingwithInvalidUsernameInvalidPassword() {
		try {
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.id("username")).sendKeys(DataForLogin.readData(2, 2));
		driver.findElement(By.id("password")).sendKeys(DataForLogin.readData(2, 3));
		driver.findElement(By.name("login")).click();
		expectedtitle = "Invalid user or password";
		WebElement message = driver.findElement(By.id("flash_error"));
	    actualtitle = message.getText();
		}
		catch(Exception e) {
			System.out.println("I'm in Catch 2 Block");
		}
		//System.out.println(actualtitle);
		if(expectedtitle.equals(actualtitle)) {
			System.out.println("Validate logging into the Application using Invalid Username and Invalid Password: "+  ANSI_GREEN +  "Passed" + ANSI_RESET);
			
		}
		else {
			System.out.println("Validate logging into the Application using Invalid Username and Invalid Password: "+  ANSI_RED +  "Failed" + ANSI_RESET);
			
		}
	    
}
		
	/*TestCase 3 - "Validate logging into the Application using invalid Email and valid Password"
 	1. Open a browser
	2. Open the URL(http://demo.redmine.com)
	3. Enter Invalid email address into the 'E-Mail Address' field 
	4. Enter valid password into the 'Password' field
	5. Click on 'Login' button
	 */
	void validateLoggingwithInvalidUsernameValidPassword() {
	try {
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.id("username")).sendKeys(DataForLogin.readData(2, 2));
		driver.findElement(By.id("password")).sendKeys(DataForLogin.readData(1, 3));
		driver.findElement(By.name("login")).click();
		expectedtitle = "Invalid user or password";
		WebElement message = driver.findElement(By.id("flash_error"));
	    actualtitle = message.getText();
	      
		}
	catch(Exception e) {
		System.out.println("I'm in Catch 3 Block");
		}
	
		//System.out.println(actualtitle);
		//Validating
		if(expectedtitle.equals(actualtitle)) {
			System.out.println("Validate logging into the Application using Invalid Username and Valid password: "+  ANSI_GREEN +  "Passed" + ANSI_RESET);
			
		}
		else {
			System.out.println("Validate logging into the Application using Invalid Username and Valid password: "+  ANSI_RED +  "Failed" + ANSI_RESET);
			
		}
		
    		
}
	
	/*TestCase 4 - "Validate logging into the Application using invalid Email and valid Password"
 	1. Open a browser
	2. Open the URL(http://demo.redmine.com)
	3. Enter Invalid email address into the 'E-Mail Address' field 
	4. Enter valid password into the 'Password' field
	5. Click on 'Login' button
 */
	void validateLoggingwithValidUsernameInvalidPassword() {
		
	try {
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.id("username")).sendKeys(DataForLogin.readData(1, 2));
		driver.findElement(By.id("password")).sendKeys(DataForLogin.readData(2, 2));
		driver.findElement(By.name("login")).click();
		expectedtitle = "Invalid user or password";
		WebElement message = driver.findElement(By.id("flash_error"));
	    actualtitle = message.getText();
		
		}
		catch(Exception e) {
		System.out.println("I'm in Catch 4 Block");
		}
	
		//System.out.println(actualtitle);
		//Validating
		if(expectedtitle.equals(actualtitle)) {
			System.out.println("Validate logging into the Application using Valid Username and Invalid password: "+  ANSI_GREEN +  "Passed" + ANSI_RESET);
			
		}
		else {
			System.out.println("Validate logging into the Application using Valid Username and Invalid password: "+  ANSI_RED +  "Failed" + ANSI_RESET);
			
		
    	}
		
}
	
	/*TestCase 5 - "Validate logging into the Application without providing any credentials"
 	1. Open a browser
	2. Open the URL(http://demo.redmine.com)
	3. Enter nothing into the 'E-Mail Address' field 
	4. Enter nothing into the 'Password' field
	5. Click on 'Login' button
 */
	void validateLoggingwithBlankInputs() {
		
	try {

		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.id("username")).sendKeys("");
		driver.findElement(By.id("password")).sendKeys("");
		driver.findElement(By.name("login")).click();
		expectedtitle = "Invalid user or password";
		WebElement message = driver.findElement(By.id("flash_error"));
	    actualtitle = message.getText();
	
	      
		}
	catch(Exception e) {
		System.out.println("I'm in Catch 5 Block");
		}
	
		//System.out.println(actualtitle);
		//Validating
		if(expectedtitle.equals(actualtitle)) {
			System.out.println("Validate logging into the Application using Blank Inputs: "+  ANSI_GREEN +  "Passed" + ANSI_RESET);
			
		}
		else {
			System.out.println("Validate logging into the Application using Blank Inputs: "+  ANSI_RED +  "Failed" + ANSI_RESET);
			
		}
		
   
}
	
	/*TestCase 6 - "Validate 'Forgotten Password' link with Invalid Email Id"
 	1. Open a browser
	2. Open the URL(http://demo.redmine.com)
	3. Enter nothing into the 'E-Mail Address' field 
	4. Enter nothing into the 'Password' field
	5. Click on 'Lost Password' link.
	6. Enter Invalid email id into 'E-Mail Address' field.
	7. Click on Submit Button.
 */
	void validateForgottenPasswordLinkWithInvalidEmail() {
		
		try {
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.linkText("Lost password")).click();
		driver.findElement(By.id("mail")).sendKeys(DataForLogin.readData(2, 5));
		driver.findElement(By.name("commit")).click();
		
		expectedtitle = "Unknown user.";
		WebElement message = driver.findElement(By.id("flash_error"));
	    actualtitle = message.getText();
		}
	    catch(Exception e) {
			System.out.println("I'm in Catch 6 Block");
			}
		//System.out.println(actualtitle);
		//Validating
		if(expectedtitle.equals(actualtitle)) {
			System.out.println("Validate 'Forgotten Password' link with Invalid Username: "+  ANSI_GREEN +  "Passed" + ANSI_RESET);
			
		}
		else {
			System.out.println("Validate 'Forgotten Password' link with Invalid Username: "+  ANSI_RED +  "Failed" + ANSI_RESET);
			
		}
		
	    
}
	
	
	/*TestCase 7 - "Validate 'Forgotten Password' link with valid Email Id"
 	1. Open a browser
	2. Open the URL(http://demo.redmine.com)
	3. Enter nothing into the 'E-Mail Address' field 
	4. Enter nothing into the 'Password' field
	5. Click on 'Lost Password' link.
	6. Enter valid email id into 'E-Mail Address' field.
	7. Click on Submit Button.
 */
	void validateForgottenPasswordLinkWithvalidEmail() {
		
		try {
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.linkText("Lost password")).click();
		driver.findElement(By.id("mail")).sendKeys(DataForLogin.readData(1, 5));
		driver.findElement(By.name("commit")).click();
		
		expectedtitle = "An email with instructions to choose a new password has been sent to you.";
		WebElement message = driver.findElement(By.id("flash_notice"));
	    actualtitle = message.getText();
		}
	    catch(Exception e) {
			System.out.println("I'm in Catch 7 Block");
			}
	  
		//System.out.println(actualtitle);
		//Validating
		if(expectedtitle.equals(actualtitle)) {
			System.out.println("Validate 'Forgotten Password' link with valid Email Id: "+  ANSI_GREEN +  "Passed" + ANSI_RESET);
			
		}
		else {
			System.out.println("Validate 'Forgotten Password' link with valid Email Id: "+  ANSI_RED +  "Failed" + ANSI_RESET);
			
		}
		
	    
}

	/*TestCase 8 - "Validate user functionality by navigate back after successful login Stays Logged"
 	1. Open a browser
	2. Open the URL(http://demo.redmine.com)
	3. Enter valid details into the 'E-Mail Address' field 
	4. Enter valid detials into the 'Password' field
	5. Click on 'login' button.
	6. click on My account page.
	7. Navigate back button.
 */
	void validateUserFunctionalityByNavigateBackAfterSuccessfulLogin() {
		String expectedtitle = null;
		String actualtitle = null;
		try {
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.id("username")).sendKeys(DataForLogin.readData(1, 2)); //login
		driver.findElement(By.id("password")).sendKeys(DataForLogin.readData(1, 3));		//password
		driver.findElement(By.name("login")).click();
		expectedtitle = "My account - Redmine demo"; //expected Message
		driver.findElement(By.cssSelector("div[id='account']>ul>li>a[class='my-account']")).click();
		driver.navigate().back(); //Navigate Back
		driver.findElement(By.cssSelector("div[id='account']>ul>li>a[class='my-account']")).click();
		actualtitle = driver.getTitle(); //Get Current Title
	   
		}
	    catch(Exception e) {
			System.out.println("I'm in Catch 8 Block");
			}
	    
	    /*String url = driver.getCurrentUrl(); //Get Current URL Command
	    System.out.println(url);*/
		
		//System.out.println(actualtitle);
	    if(expectedtitle.equalsIgnoreCase(actualtitle)) {
			System.out.println("Validate user functionality by navigate back after successful login stays logged : "+  ANSI_GREEN +  "Passed" + ANSI_RESET);
			driver.findElement(By.linkText("Sign out")).click();
		}
		else {
			System.out.println("Validate user functionality by navigate back after successful login stays logged: "+  ANSI_RED +  "Failed" + ANSI_RESET);
		}
		
	}
	
	
	
	/*TestCase 9 - "Validate user functionality that logged into Correct User are not"
 	1. Open a browser
	2. Open the URL(http://demo.redmine.com)
	3. Enter valid details into the 'E-Mail Address' field 
	4. Enter valid detials into the 'Password' field
	5. Click on 'login' button.
	6. Click on My account page.
	7. Check Current User.

 */
	void validateUserFunctionalityThatLoggedIntoCorrectUser() {
		
		try {
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.id("username")).sendKeys(DataForLogin.readData(1, 2)); //login
		driver.findElement(By.id("password")).sendKeys(DataForLogin.readData(1, 3));		//password
		driver.findElement(By.name("login")).click();
		expectedtitle = DataForLogin.readData(1, 2); //expected Message
		actualtitle = driver.findElement(By.cssSelector("div[id='loggedas']>a[class='user active']")).getText();
	   
		}
	    catch(Exception e) {
			System.out.println("I'm in Catch 9 Block");
			}
		//System.out.println(actualtitle);
	    if(expectedtitle.equalsIgnoreCase(actualtitle)) {
			System.out.println("Validate user functionality that logged into Correct User: " +  ANSI_GREEN +  "Passed" + ANSI_RESET);
			driver.findElement(By.linkText("Sign out")).click();
		}
		else {
			System.out.println("Validate user functionality that logged into Correct User: "+  ANSI_RED +  "Failed" + ANSI_RESET);
			
		}
	    
	
}
	
	
	/*TestCase 10 - "Validate user functionality after loggedout navigate forward will login"
 	1. Open a browser
	2. Open the URL(http://demo.redmine.com)
	3. Enter valid details into the 'E-Mail Address' field 
	4. Enter valid detials into the 'Password' field
	5. Click on 'login' button.
	6. Click on My account page.
	7. Click on signout
	8. click on navigate forward button.

 */
	void validateUserFunctionalityThatLoggedOutNavigateBackStillLoggedIn() {
		
		try {
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.id("username")).sendKeys(DataForLogin.readData(1, 2)); //login
		driver.findElement(By.id("password")).sendKeys(DataForLogin.readData(1, 3));		//password
		driver.findElement(By.name("login")).click();
		driver.findElement(By.linkText("Sign out")).click();
		driver.navigate().back();
		expectedtitle = "My page - Redmine demo"; //expected Message
		actualtitle = driver.getTitle();
	   
		}
	    catch(Exception e) {
			System.out.println("I'm in Catch 9 Block");
			}
		//System.out.println(actualtitle);
	    if(expectedtitle != actualtitle) {
			System.out.println("Validate user functionality that Logged out Navigate back Still Logged In : " +  ANSI_GREEN +  "Passed" + ANSI_RESET);
			//driver.findElement(By.linkText("Sign out")).click();
		}
		else {
			System.out.println("Validate user functionality that Logged out Navigate back Still Logged In: "+  ANSI_RED +  "Failed" + ANSI_RESET);
			
		}
	    
	
}	
	void closeBrowser() {
		driver.quit();
	}
	
	public static void main(String[] args) {
		
		DataDrivenLoginFunctionality tryCatchLogin = new DataDrivenLoginFunctionality();
		tryCatchLogin.callBrowser();
		tryCatchLogin.validateLoggingwithValidCredentials();
		tryCatchLogin.validateLoggingwithInvalidUsernameInvalidPassword();
		tryCatchLogin.validateLoggingwithInvalidUsernameValidPassword();
		tryCatchLogin.validateLoggingwithValidUsernameInvalidPassword();
		tryCatchLogin.validateLoggingwithBlankInputs();
		tryCatchLogin.validateForgottenPasswordLinkWithInvalidEmail();
		tryCatchLogin.validateForgottenPasswordLinkWithvalidEmail();
		tryCatchLogin.validateUserFunctionalityByNavigateBackAfterSuccessfulLogin();
		tryCatchLogin.validateUserFunctionalityThatLoggedIntoCorrectUser();
		tryCatchLogin.validateUserFunctionalityThatLoggedOutNavigateBackStillLoggedIn();
		tryCatchLogin.closeBrowser();
	
	}

}
