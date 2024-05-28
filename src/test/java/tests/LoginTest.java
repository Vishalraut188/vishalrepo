package tests;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import pageobject.AccountPage;
import pageobject.LoginPage;
import pageobject.MainHomePage;
import resources.Base;




public class LoginTest extends Base{

	public Logger  log;
	WebDriver driver;


	@Test(dataProvider="getLogin")
	public void login(String username, String password, String ExpectedResult) throws IOException, InterruptedException {
		
// log = LogManager.getLogger(LoginTest.class.getName());
		
		
		
		MainHomePage mhp = new MainHomePage(driver);
		mhp.myAccountOnHomePage().click();
		log.debug("Click on My Account link");
		mhp.loginLinkOnHomePage().click();
		log.debug("Click on Login link");

		
		LoginPage lp = new LoginPage(driver);
		lp.emailField().sendKeys(username);
		log.debug("Email addres got  entered");
		lp.passwordField().sendKeys(password);
		log.debug("Password got entere");
		lp.loginButton().click();
		log.debug("loggin button Clicked ");
		
		AccountPage ap = new AccountPage(driver);
	//	String text = ap.confirmationText().getText();
	//	System.out.println(text);
	//	Assert.assertEquals(text, "My Account");
		
        String ActualResult = null;
		
		try {
			
			if(ap.confirmationText().isDisplayed()){
				log.debug("User got logged in");
				 ActualResult = "Sucessfull";
			}
			
		    }	catch(Exception e) {
				log.debug("User did not logged in");
		    	ActualResult ="Failure";
			}
			
		Assert.assertEquals(ActualResult,ExpectedResult );
		log.info("Test case pass");
		
		
if(ActualResult.equals(ExpectedResult)) {
			
			log.info("Login Test got passed");
			
		}else {
			
			log.error("Login Test got failed");
		}
	
       
  //   Assert.assertEquals(ActualResult, ExpectedResult);
	//	log.info("Test case pass");
	}
	
	
	
	@DataProvider
	public Object[][] getLogin() {
		
		
		Object [][] getData = {{"ramss@gmail.com","ramss","Sucessfull"}};
		
		return getData;
	
	/*
	 * @DataProvider public Object[][] getLogin() {
	 * 
	 * 
	 * Object [][] getData =
	 * {{"ramss@gmail.com","ramss","Sucessfull"},{"Sams@gmail.com", "invalid"
	 * ,"Failure" }};
	 * 
	 * return getData;
	 */
		//it is also working
		
		/*
		 * Object[][] getData = new Object[2][2]; getData[0][0]="ramss@gmail.com";
		 * getData[0][1]="ramss"; getData[1][0]="Sams@gmail.com"; getData[1][1]="125";
		 * 
		 * return getData;
		 */
	}
	
	@BeforeMethod
	public void openBrowser() throws IOException {
		
		log = LogManager.getLogger(LoginTest.class.getName());
	driver = initialisedDriver();
	System.out.println("On before Method");
	log.debug("Browser Launched");
		
		driver.get(prop.getProperty("url"));
		log.debug("Navigate To Application URl");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@AfterMethod
	public void closer()
	{
		driver.close();
		log.debug("Browser Close");
		
	}
}
