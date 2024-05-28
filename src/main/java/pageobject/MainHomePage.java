package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainHomePage {
	
	WebDriver driver;
	
	public MainHomePage(WebDriver driver) {
		
		this.driver = driver;
		
	
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement Myaccounthome;
	
	@FindBy(xpath="//li[@class='dropdown open']//ul/li[2]")
	private WebElement LoginLink;
	
	@FindBy(xpath="(//a[text()='Register'])[1]")
	private WebElement RegistrationLink;
	
	public WebElement myAccountOnHomePage() {
		
		return Myaccounthome;
	}
	
	public WebElement loginLinkOnHomePage() {
		return LoginLink;
	}
	
	public WebElement  registrationLinkOnHomePage() {
		return  RegistrationLink;
	}
	

}
