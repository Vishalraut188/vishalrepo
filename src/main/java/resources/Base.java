package resources;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	
 public   WebDriver driver;
    
   public Properties prop;

	public WebDriver initialisedDriver() throws IOException {
		
	    prop = new Properties();
		
		String FilePath = System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties";
		System.out.println(FilePath);
		
		FileInputStream fis = new FileInputStream(FilePath);
		
		prop.load(fis);
		
		
		String BrowserName =  prop.getProperty("browser");
		
		if(BrowserName.equalsIgnoreCase("chrome")) {
			
			driver = new ChromeDriver();
		//	driver.get("https://tutorialsninja.com/demo/");
		
		}else if(BrowserName.equalsIgnoreCase("Firefox")) {
			
			driver = new FirefoxDriver();
		//	driver.get("https://tutorialsninja.com/demo/");
				
		}else if(BrowserName.equalsIgnoreCase("IE")) {
			
			driver = new InternetExplorerDriver();
		//	driver.get("https://tutorialsninja.com/demo/");
		}
		
		driver.manage().window().maximize();
		
		return driver;
		
	}
	

	public String takesScreenShots(String testName,WebDriver driver) throws IOException {
		File SourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFilePath = System.getProperty("user.dir")+"\\screenshots\\"+testName+".png";
		FileUtils.copyFile(SourceFile,new File(destinationFilePath));
		return destinationFilePath;
	}
}
