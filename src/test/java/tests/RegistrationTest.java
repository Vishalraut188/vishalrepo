package tests;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobject.AccountSuccessPage;
import pageobject.MainHomePage;
import pageobject.RegisterPage;
import resources.Base;

public class RegistrationTest extends Base {
	
	public Logger  log;
	public WebDriver driver;
	
	@BeforeMethod
	public void   openbrowser() throws IOException {
		
		log = LogManager.getLogger(LoginTest.class.getName());
	driver = initialisedDriver();
	System.out.println("On before Method");
	log.debug("Browser Launched");
		
		driver.get(prop.getProperty("url"));
		log.debug("Navigate To Application URl");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	     
	}
	
	@AfterMethod
	public void close() {
		driver.close();
		log.debug("Browser Close");
	}
	
	@Test
	public void registration() {
		
		MainHomePage mhp = new MainHomePage(driver);
		mhp.myAccountOnHomePage().click();
		
		log.debug("cliked on my account link");
		mhp.registrationLinkOnHomePage().click();
		log.debug("cliked on my registration link");
		
	
//	Assert.assertTrue(driver.findElement(By.xpath("//h1[contains(text(),'Regi')]")).isDisplayed());
	
	RegisterPage rp  = new RegisterPage(driver);
	Assert.assertTrue(rp.confirmAccPage().isDisplayed());
	rp.firstNameField().sendKeys("Sample");
	log.debug("Enterd firstname");
	rp.lastNameField().sendKeys("sampl");
	log.debug("Entered lastname");
	rp.emailField().sendKeys("sample@gmail.com");
	log.debug("Entered Email Addres");
	rp.telephoneField().sendKeys("9090909555");
	log.debug("Entered telephonenumber");
	rp.passwordFiled().sendKeys("sample");
	log.debug("Entered password");
	rp.confirmPassword().sendKeys("sample");
	log.debug("Entered conpassword");
	rp.checkbocClick().click();
	log.debug("check box click");
	rp.continueButton().click();
	log.debug("continue button click");
	
	AccountSuccessPage asp = new AccountSuccessPage(driver);
	
//	System.out.println(asp.registrationSuccess().getText());
	
	
	try {
            boolean reg =	asp.registrationSuccess().isDisplayed();
                System.out.println(reg);
                                                                                
                Assert.assertTrue(reg);
                log.info("registration sucessfully");
                
                
	}catch(Exception e) {
		
		String tesxt = asp.errorMessage().getText();
		
		Assert.assertEquals(tesxt, "Warning: E-Mail Address is already registered!");
		log.info(" Duplicate Email addresss already entered please entered uniqe email address ");
	}
	
		
	}
	
	

}
