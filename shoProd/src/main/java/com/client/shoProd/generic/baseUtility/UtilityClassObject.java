package com.client.shoProd.generic.baseUtility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class UtilityClassObject 
{
public static ThreadLocal<ExtentTest> test=new ThreadLocal<ExtentTest>();
public static ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();

public static ExtentTest getTest() {
	return test.get();
}
public static void setTest(ExtentTest actSest) {
	test.set(actSest);
}

public static void setDriver(WebDriver actDriver) {
	driver.set(actDriver);
}

public static WebDriver getDriver() {
	return driver.get();
}
}
