package com.client.shoProd.generic.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver driver;

	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//elements for login to app...
	
	@FindBy(id="exampleInputEmail1")
	private WebElement usernameEdt;
	
	@FindBy(id="exampleInputPassword1")
	private WebElement loginPasswordEdt;
	
	@FindBy(xpath="//button[text()='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath="//a[text()='Forgot your Password?']")
	private WebElement forgotPasswordLink;

	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}
	public WebElement getLoginPasswordEdt() {
		return loginPasswordEdt;
	}
	public WebElement getLoginButton() {
		return loginButton;
	}
	public WebElement getForgotPasswordLink() {
		return forgotPasswordLink;
	}
	
	//elements for signUp or to create account...
	
	@FindBy(id="fullname")
	private WebElement fullnameEdt;
	
	@FindBy(id="email")
	private WebElement emailEdt;
	
	@FindBy(id="contactno")
	private WebElement contactEdt;
	
	@FindBy(id="password")
	private WebElement createPasswordEdt;
	
	@FindBy(id="confirmpassword")
	private WebElement confirmPasswordEdt;
	
	@FindBy(id="submit")
	private WebElement submitButton;
	
	public WebElement getFullnameEdt() {
		return fullnameEdt;
	}
	public WebElement getEmailEdt() {
		return emailEdt;
	}
	public WebElement getContactEdt() {
		return contactEdt;
	}
	public WebElement getCreatePasswordEdt() {
		return createPasswordEdt;
	}
	public WebElement getConfirmPasswordEdt() {
		return confirmPasswordEdt;
	}
	public WebElement getSubmitButton() {
		return submitButton;
	}
	
	// business logic for login to app...
	
	public void getLoginToApp(String username, String password) {
		usernameEdt.sendKeys(username);
		loginPasswordEdt.sendKeys(password);
		loginButton.click();
	}
	
}
