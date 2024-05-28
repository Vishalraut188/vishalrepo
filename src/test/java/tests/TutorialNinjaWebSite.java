package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


import pageobject.AccountPage;
import pageobject.LoginPage;
import pageobject.MainHomePage;

public class TutorialNinjaWebSite {
	
	WebDriver driver;
	ExtentReports ER;
	
	@BeforeMethod
	public void openBrowser() {
		
		String reportPath = System.getProperty("user.dir")+"\\reports\\index.html";
		
		ExtentSparkReporter reporters = new ExtentSparkReporter(reportPath);
		reporters.config().setReportName("Vishal Raut");
		reporters.config().setDocumentTitle("Selenium");
		ER = new ExtentReports();
		ER.attachReporter(reporters);
		ER.setSystemInfo("Oprating System", "Windoes 10");
		ER.setSystemInfo("Tested By", "Vishal Raut");
		
		
	}
	
	@Test
	public void loginTuto() {
		
	    ExtentTest etest = ER.createTest("Login Tuto");
		driver = new ChromeDriver();
		etest.info("Chrome browser launched");
		driver.get("https://tutorialsninja.com/demo/");
		etest.info("WebSite O");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		
		MainHomePage mhp = new MainHomePage(driver);
		mhp.myAccountOnHomePage().click();
		mhp.loginLinkOnHomePage().click();
		
		LoginPage lp  = new LoginPage(driver);
		lp.emailField().sendKeys("ramss@gmail.com");
		lp.passwordField().sendKeys("ramss");
		lp.loginButton().click();
		
		AccountPage ap = new AccountPage(driver);
		String text = ap.confirmationText().getText();
		System.out.println(text);
		Assert.assertEquals(text, "My Accounts");
		
		
	}
	
	
	@AfterMethod
	public void close() {
		
		driver.close();
		ER.flush();
	}

}
