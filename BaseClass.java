package CommonUtils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	//TO CREATE GLOBAL VARIABLE
	public WebDriver driver;
	PropertyFileUtil putil = new PropertyFileUtil();
	WebDriverUtil wutil = new WebDriverUtil();
	

	@BeforeSuite
	public void BS() {
		System.out.println("Connect to Data Base");
		
	}
	@BeforeClass
	public void BC()throws IOException{
	//IT IS USED TO LAUNCH THE APPLICATION
		String URL  = putil.getDataFromPropertyFile("url");
		WebDriver driver = new ChromeDriver();
		
		//TO CLICK ON 
		wutil.maximize(driver);
		wutil.implicitwait(driver);
				
	    //TO LAUNCH THE APPLICATION			
	     driver.get(URL);
}
	@BeforeMethod
	public void BM() throws IOException {
//@BeforeMethod is used to Login to the application
//		String USERNAME = putil.getDataFromPropertyFile("Username");
//		String PASSWORD = putil.getDataFromPropertyFile("password");
		String USERNAME = putil.getDataFromPropertyFile("username");
		String PASSWORD = putil.getDataFromPropertyFile("password");
	
		
		//LOGIN TO APPLICATION
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//        driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//        driver.findElement(By.id("submitButton")).click();
		
		WebElement us = driver.findElement(By.id("username"));
		us.clear();
		us.sendKeys(USERNAME);

		WebElement pass =  driver.findElement(By.id("password"));
		pass.clear();
        pass.sendKeys(PASSWORD);
        
        driver.findElement(By.xpath("//button[text()='Sign in']")).click();
              
	}
	@AfterMethod
	public void AM() {
		//@AfterMethod IS USED TO SIGNOUT FROM THE APPLICATION
		
	//MOUSEHOVER ON IMAGE 
		  WebElement image = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
	        wutil.mousehover(driver, image);
	        
	}

	@AfterClass
	public void AC() {
		//@AfterClass is used to close th browser
		driver.quit();
		
	}
	
	@AfterSuite
	public void AS() {
		System.out.println("Disconnect to Data Base");
		
	}
	
	
	


}
