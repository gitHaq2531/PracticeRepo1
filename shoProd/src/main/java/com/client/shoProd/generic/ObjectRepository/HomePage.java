package com.client.shoProd.generic.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	WebDriver driver;

	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="My Account")
	private WebElement myAccountLink;
	
	@FindBy(linkText="Wishlist")
	private WebElement wishlistLink;
	
	@FindBy(linkText="My Cart")
	private WebElement myCartLink;
	
	@FindBy(linkText="Logout")
	private WebElement logoutLink;
	
	@FindBy(xpath="//span[text()='Track Order']")
	private WebElement trackOrderLink;
	
	@FindBy(xpath="//div[@class='basket']")
	private WebElement mycartBasketLink;
	
	@FindBy(className = "search-field")
	private WebElement searchEdt;
	
	@FindBy(xpath = "//a[text()='Home']")
	private WebElement homeTabLink;
	
	@FindBy(xpath = "//a[text()=' Furniture']")
	private WebElement furnitureTabLink;
	
	@FindBy(xpath = "//a[text()=' Fashion']")
	private WebElement fashionTabLink;
	
	@FindBy(xpath = "//a[text()=' Toys']")
	private WebElement toysTabLink;
	
	@FindBy(xpath = "//a[text()=' Accessories']")
	private WebElement accessoriesTabLink;
	
	@FindBy(xpath = "//a[text()=' Beauty']")
	private WebElement beautyTabLink;


	public WebElement getMyAccountLink() {
		return myAccountLink;
	}

	public WebElement getWishlistLink() {
		return wishlistLink;
	}

	public WebElement getMyCartLink() {
		return myCartLink;
	}

	public void getLogoutFromApp() {
		logoutLink.click();
	}

	public WebElement getTrackOrderLink() {
		return trackOrderLink;
	}

	public WebElement getMycartBasketLink() {
		return mycartBasketLink;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getHomeTabLink() {
		return homeTabLink;
	}

	public WebElement getFurnitureTabLink() {
		return furnitureTabLink;
	}

	public WebElement getFashionTabLink() {
		return fashionTabLink;
	}

	public WebElement getToysTabLink() {
		return toysTabLink;
	}

	public WebElement getAccessoriesTabLink() {
		return accessoriesTabLink;
	}

	public WebElement getBeautyTabLink() {
		return beautyTabLink;
	}
}
