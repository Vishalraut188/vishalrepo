package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
	
	public RegisterPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="input-firstname")
	private WebElement firstNameField;
	
	public WebElement firstNameField() {
		return firstNameField;
	}
	
	@FindBy(id="input-lastname")
	private WebElement lastNameField;
	
	public WebElement lastNameField() {
		return lastNameField;
	}
	
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	public WebElement emailField() {
		return emailField;
	}
	
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	
	public WebElement telephoneField() {
		
		return telephoneField;
	}
	
	@FindBy(id="input-password")
	private WebElement passwordfield;
	
	public WebElement passwordFiled() {
		return passwordfield;
	}
	
	@FindBy(id="input-confirm")
	private WebElement confirmpassword;
	
	public WebElement confirmPassword() {
		return  confirmpassword;
	}
	
	@FindBy(name="agree")
	private WebElement checkboxclick;
	
	public WebElement checkbocClick() {
		return checkboxclick;
	}
	
	@FindBy(css="input[type='submit']")
	private WebElement continuebutton;
	
	public WebElement continueButton() {
		
		return continuebutton;
	}
	
	@FindBy(xpath="//h1[contains(text(),'Regi')]")
    private WebElement confirmaccounttext;
	
	public WebElement confirmAccPage() {
		return confirmaccounttext;
	}
	
	
	
	
	

	
}
