package CommonUtils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplementation implements ITestListener {
	
	ExtentReports report;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
   //System.out.println("Testsceipt execution is started");
   String methodName = result.getMethod().getMethodName();
Reporter.log(methodName+ "Testsceipt execution is started",true);
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
	// TODO Auto-generated method stub 
    //System.out.println("Testscript execution is Passed");	
    Reporter.log(methodName+"Testscript execution is Passed",true);
}
	
	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
	// TODO Auto-generated method stub
    //System.out.println("Testscript excution is Passed");
		String message = result.getThrowable().toString();
    Reporter.log(methodName +"Testscript excution is Passed",true);
}


     public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
	// TODO Auto-generated method stub
     //System.out.println("TestScript Execution skipeed");	
	Reporter.log(methodName + "TestScript Execution skipeed",true);}


	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
    //System.out.println( "To start the execution");
    Reporter.log("To start the execution",true);
    //USE ExtentSparkReporter class just to configure extent
    JavaUtil jutil = new JavaUtil ();
    ExtentSparkReporter reporter = new ExtentSparkReporter("./extentreport/report"+jutil.getRandomNumber()+".html");
    reporter.config().setDocumentTitle("vtigercrm");
    reporter.config().setTheme(Theme.DARK); // we can use STANDARD also
    reporter.config().setReportName("Pune");
    
    //USE EXTENTREPORTS TO GENERATE EXETENTREPORT
    report = new ExtentReports();
    report.attachReporter(reporter);
    report.setSystemInfo("Browser", "Chrome");
    report.setSystemInfo("chromeversion", "121");
    report.setSystemInfo("Author", "GUNJAN");
    
}

	@Override
	public void onFinish(ITestContext context) {
	// TODO Auto-generated method stub
    //System.out.println("Execution Passed");	
	Reporter.log("Execution Passed",true);
	report.flush();
	
	
	
	
		}

	}


