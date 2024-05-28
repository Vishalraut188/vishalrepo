package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage {
	
	WebDriver driver;
	
	public AccountSuccessPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath="//h1[contains(text(),'Your Account')]")
	private WebElement registrationSuccess;
	
	public WebElement registrationSuccess() {
		return registrationSuccess;
	}
	
	@FindBy(css="div[class='alert alert-danger alert-dismissible']")
	private WebElement errormessage;
	
	public WebElement errorMessage() {
		
		return  errormessage;
	}

}
