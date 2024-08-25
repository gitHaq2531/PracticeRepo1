package com.client.shoProd.generic.webdriverUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class webDriverUtils 
{
	//implicitlyWait....
		public void waitToLoadPage(WebDriver driver){
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		}
		
		//explicit wait for visibility of element....
		public void waitForElementToBePresent(WebDriver driver, WebElement element){
			WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		
		//explicit wait for element to be clickable....
		public void waitForElementToBeClickable(WebDriver driver, WebElement element){
			WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		
		//explicit wait to check alert is present....
		public void waitForAlertToBePresent(WebDriver driver, WebElement element){
			WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.alertIsPresent());
		}
		
		//explicitwait for match the title....
		public void waitForTitleIs(WebDriver driver, WebElement element, String title){
			WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.titleContains(title));
		}
		//maximize window
		public void maximizeWindow(WebDriver driver){
			driver.manage().window().maximize();
		}
		
		//minimize window
		public void minimizeWindow(WebDriver driver){
			driver.manage().window().minimize();
		}
		public Select dropdown(WebElement element){
			Select selectElement=new Select(element);
			return selectElement;
		}
			
		//select by index in drop-down....
		public void selectByIndex(WebElement element,int index){
			dropdown(element).selectByIndex(index);
		}
		
		//select by value in drop-down....
		public void selectByValue(WebElement element,String value){
			dropdown(element).selectByValue(value);
		}
		
		//select by visible text in drop-down....
		public void selectByVisibleText(WebElement element,String text){
			dropdown(element).selectByVisibleText(text);
		}
		
		//perform actions 
		public Actions action(WebDriver driver){
			Actions act=new Actions(driver);
			return act;
		}
		
		//move to element
		public void moveToElement(WebDriver driver, WebElement element){
			action(driver).moveToElement(element).perform();
		}
		
		public void doubleClick(WebDriver driver, WebElement element){
			action(driver).doubleClick(element).perform();
		}
		
		public void rightClick(WebDriver driver, WebElement element){
			action(driver).contextClick(element).perform();
		}
		
		public void dragAndDrop(WebDriver driver, WebElement src, WebElement target){
			action(driver).dragAndDrop(src, target).perform();
		}
		
		public void scrollToElement(WebDriver driver, WebElement element){
			action(driver).scrollToElement(element).perform();
		}
		
		public void switchToAlert(WebDriver driver){
			driver.switchTo().alert();
		}
		
		public void switchToFrameByIndex(WebDriver driver,int index){
			driver.switchTo().frame(index);
		}
		
		public void switchToFrameByName(WebDriver driver,String name){
			driver.switchTo().frame(name);
		}
		
		public void switchToFrameByElement(WebDriver driver,WebElement element){
			driver.switchTo().frame(element);
		}
		
		public void switchToParentFrame(WebDriver driver){
			driver.switchTo().parentFrame();
		}
		
		public void switchToTopmostFrame(WebDriver driver){
			driver.switchTo().defaultContent();
		}
		
		public void acceptAlert(WebDriver driver){
			driver.switchTo().alert().accept();
		}
		
		public void dismissAlert(WebDriver driver){
			driver.switchTo().alert().dismiss();
		}
		
		public void enterDataInAlert(WebDriver driver, String text){
			driver.switchTo().alert().sendKeys(text);
		}
		
		public String getTextFromAlert(WebDriver driver){
			return driver.switchTo().alert().getText();
		}
		
		public void getWebPageScreenshot(WebDriver driver, String path) throws IOException{
			TakesScreenshot ts=(TakesScreenshot)driver;
			File tempSS=ts.getScreenshotAs(OutputType.FILE);
			File permSS= new File(path);
			FileHandler.copy(tempSS, permSS);
		}
		
		public void getElementScreenshot(WebElement element, String path) throws IOException{
			File tempSS=element.getScreenshotAs(OutputType.FILE);
			File permSS= new File(path);
			FileHandler.copy(tempSS, permSS);
		}
		
		public void scrollForFixAmount(WebDriver driver,int xAxes, int yAxes) throws IOException{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy("+xAxes+","+yAxes+")");
		}
		
		//switch to driver by using title....
		public WebDriver switchToWindowByTitle(WebDriver driver, String title) {
			Set<String> allWids = driver.getWindowHandles();
			for(String wid: allWids)	{
				driver.switchTo().window(wid);
				String widTitle=driver.getTitle();
				if(widTitle.contains(title))	{
					return driver;
				}
			}
			return null;
		}
		
		//switchTo window by partial url....
		public void switchToWindowByPartialUrl( String Prtialurl,WebDriver driver) {
			Set<String> allWids = driver.getWindowHandles();
			for(String wid: allWids) {
				driver.switchTo().window(wid);
				String widUrl=driver.getCurrentUrl();
				if(widUrl.contains(Prtialurl)) {
					break;
				}
			}
		}
		
		public String getParentWindowId(WebDriver driver) {
			return driver.getWindowHandle();
		}
		
		public void switchToParentWindow(WebDriver driver,String parentWid) {
			driver.switchTo().window(parentWid);
		}
}
