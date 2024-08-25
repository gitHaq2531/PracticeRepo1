package com.client.shoProd.generic.ListenersUtility;

import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.client.shoProd.generic.baseUtility.UtilityClassObject;

public class ListenersImpClass implements ISuiteListener, ITestListener
{
	public ExtentReports reports;
	public ExtentTest test;
	public String methodName;
	public String timeStamp=LocalDateTime.now().toString().replace(':', '-');

	@Override
	public void onStart(ISuite suite) {
		ExtentSparkReporter spark=new ExtentSparkReporter("./advanceReport/shoProd_Report"+timeStamp+".png");
		spark.config().setDocumentTitle("shoProd_suite_execution_report");
		spark.config().setReportName("shoProd_Report");
		spark.config().setTheme(Theme.DARK);
		
		reports=new ExtentReports();
		reports.attachReporter(spark);
		reports.setSystemInfo("OS", "windows 11");
		reports.setSystemInfo("browser", "chrome_127");
	}

	@Override
	public void onFinish(ISuite suite) {
		reports.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		 methodName = result.getMethod().getMethodName();
		 test = reports.createTest(methodName);
		 UtilityClassObject.setTest(test);
		 test.log(Status.INFO, methodName+" executed");
	}

	//on test case success...
	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, methodName+" success");
	}

	//on test case failure...
	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, methodName+" got failed");
		test.log(Status.FAIL, result.getThrowable());
		
		TakesScreenshot ts=(TakesScreenshot)UtilityClassObject.getDriver();
		String filePath = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(filePath, methodName+"_"+timeStamp);
	}

	//on test case skipped...
	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, methodName+" skipped");
	}
}
