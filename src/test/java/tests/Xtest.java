package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import resources.Base;

public class Xtest extends Base {
	
 public 	WebDriver driver;
	@Test
	public void xtest() throws IOException {
		
		
		System.out.println("Nikita codes on this class on 2024 05 29");
		
	driver = initialisedDriver();
	
	driver.get("https://maven.apache.org/plugins/maven-resources-plugin/examples/filter.html");
		
	Assert.assertTrue(false);
	}

}
