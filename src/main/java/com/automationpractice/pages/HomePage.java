package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * @author Tushar
 * 
 *         This Page Class is created for Home page in the application
 *         Page Factory is implemented 
 *         The weblements to be used in the selenium tests are located via xpath and stored in this class
 *		   The methods in the class are used to perform actions over the identified webelements
 */


public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='search_query_top']")
	private WebElement Search_box;

	@FindBy(xpath = "//div[3]/div[1]/div[1]/div[2]/form[1]/button[1]")
	private WebElement Search_button;

	@FindBy(xpath = "//a[contains(text(),'Sign in')]")
	private WebElement SignIn_button;

	@FindBy(xpath = "//div[3]/div[1]/div[1]/div[3]/div[1]/a[1]")
	private WebElement Cart_button;
	
	@FindBy(xpath = "//span[normalize-space()='Test Apps']")
	private WebElement User_Info;
	
	@FindBy(xpath = "//img[@alt='My Store']")
	private WebElement HomePage_link;
	
	@FindBy(xpath = "//div[@class='product-content']//a[@class='product-name'][normalize-space()='Faded Short Sleeve T-shirts']")
	private WebElement Product_link;
	
	@FindBy(xpath = "//input[@id='quantity_wanted']")
	private WebElement Quantity;
	
	@FindBy(xpath = "//span[normalize-space()='Add to cart']")
	private WebElement AddtoCart_button;
	
	@FindBy(xpath = "//a[@title='Close']")
	private WebElement Alertbox;
	
	@FindBy(xpath = "//span[@title='Close window']")
	private WebElement AddtoCart_Popup;
	

	public void Click_Searchbutton() {Search_button.click();}

	public void Click_SignIn() {SignIn_button.click();}

	public void Cartbutton_click() {Cart_button.click();}
	
	public void Enter_ProductName(String Product){Search_box.sendKeys(Product);}
	
	public String Fetch_UserName(){return User_Info.getText();}

	public void Navigate_to_HomePage(){HomePage_link.click();}
	
	public void Clickon_Product(){Product_link.click();}
	
	public void UpdateQuantity(String Quan){Quantity.sendKeys(Quan);}
	
	public void Click_AddtoCart(){AddtoCart_button.click();}
	
	public void Close_Alert(){Alertbox.click();}
	
	public void Close_AddtoCartWindow(){AddtoCart_Popup.click();}
	
	public void ClearSearchField(){Search_box.clear();}
	
	public void ClearQuantityField(){Quantity.clear();}
}


