package com.client.shoProd.module;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.client.shoProd.generic.baseUtility.BaseClassUtils;

@Listeners(com.client.shoProd.generic.ListenersUtility.ListenersImpClass.class)
public class Flipkart6 extends BaseClassUtils
{
@Test
public void flipkartTest() throws IOException {
	System.out.println("test execute6");
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("window.scrollTo(200,200)");
	driver.switchTo().newWindow(WindowType.WINDOW);
	driver.get("https://www.flipkart.com");
	Assert.fail();

	wdUtils.switchToWindowByTitle(driver, "Amazon");
	wdUtils.scrollForFixAmount(driver, 0, 200);
}
}
