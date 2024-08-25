package com.client.shoProd.generic.baseUtility;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.client.shoProd.generic.ObjectRepository.HomePage;
import com.client.shoProd.generic.ObjectRepository.LoginPage;
import com.client.shoProd.generic.databaseUtility.DatabaseUtils;
import com.client.shoProd.generic.fileUtility.FileUtils;
import com.client.shoProd.generic.webdriverUtility.webDriverUtils;

public class BaseClassUtils 
{
	public DatabaseUtils dbUtils=new DatabaseUtils();
	public FileUtils fUtils=new FileUtils();
	public WebDriver driver=null;
	public webDriverUtils wdUtils=new webDriverUtils();
	
// connect to database...
@BeforeSuite
public void beforeSuite()  {
	dbUtils.getDataBaseConnection();;
}

//launch browser

@BeforeClass
public void beforeClass() throws IOException {
	String browser=fUtils.getdataFromPropertyFile("browser");
	if(browser.equals("chrome")){
		driver=new ChromeDriver();
	}
	else if(browser.equals("edge")){
		driver=new EdgeDriver();
	}
	else if(browser.equals("firefox")){
		driver=new FirefoxDriver();
	}
	UtilityClassObject.setDriver(driver);
	wdUtils.maximizeWindow(driver);
	wdUtils.waitToLoadPage(driver);
}

@BeforeMethod
public void beforeMethod() throws IOException 
{
	System.out.println("before method");
	String url="https://www.amazon.in";//fUtils.getdataFromProperties("url");
	driver.get(url);

//	String username=fUtils.getdataFromProperties("username");
//	String password=fUtils.getdataFromProperties("password");
//	LoginPage lp=new LoginPage(driver);
//	lp.getLoginToApp(username, password);
}

@AfterMethod
public void afterMethod() {
	System.out.println("after method");
//	HomePage hp=new HomePage(driver);
//	hp.getLogoutFromApp();
}

@AfterClass
public void afterClass() {
	//driver.quit();
}

@AfterSuite
public void afterSuite() {
	dbUtils.closeDataBaseConnection();;
}

}
