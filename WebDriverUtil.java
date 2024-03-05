package CommonUtils;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtil {
	
	public WebDriver driver;
	
	public void maximize(WebDriver driver){
		driver.manage().window().maximize();

	}
	public void implicitwait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10 ));
	}
	
	//OGGINIZATIONS
	
	public void handeldropdown(WebElement element,String targetedelement) {
	Select s = new Select(element);
	s.selectByVisibleText(targetedelement);
	}
	public void mousehover(WebDriver driver, WebElement element) {
		  Actions  a = new Actions(driver);
	       a.moveToElement(element);
	       a.perform();
	       
	       
//	   CONTACTS  
	       
//	  public void switchwindow(WebDriver driver,String expectedurl) {
//		  Set<String> ids = driver.getWindowHandles();
//		  for(String e : ids) {
//			  String actualurl = driver.switchTo().window(e).getCurrentUrl();
//			  if(actual.contains(expectedurl)) {
//				  break;
//			  }
	    }




//      SCREENSHOT

//   public void screenshot(WebDriver driver,String ScreenshotName) {
//	TakeScreenshot ts =(TakeScreenshot)driver;
//	tempfile = ts.getScreenshotAs(OutputType.FILE);
//	File destinationFile = new File("./Screenshot/"+ScreenshotName+".png");
//	FileUtils.copyFile(tempfile, destinationFile);
//	return destinationFile;
//	
}

