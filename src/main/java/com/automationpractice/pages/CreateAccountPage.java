package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Tushar
 * 
 *         This Page Class is created for User Registration page in the application
 *         Page Factory is implemented 
 *         The weblements to be used in the selenium tests are located via xpath and stored in this class
 *		   The methods in the class are used to perform actions over the identified webelements
 */


public class CreateAccountPage {
	
	public WebDriver driver;

	public CreateAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='customer_firstname']")
	private WebElement First_Name;

	@FindBy(xpath = "//input[@id='customer_lastname']")
	private WebElement Last_Name;

	@FindBy(xpath = "//input[@id='passwd']")
	private WebElement Password;

	@FindBy(xpath = "//input[@id='firstname']")
	private WebElement First_Name_Address;

	@FindBy(xpath = "//input[@id='lastname']")
	private WebElement Last_Name_Address;
	
	@FindBy(xpath = "//input[@id='company']")
	private WebElement Company_Name;
	
	@FindBy(xpath = "//input[@id='address1']")
	private WebElement Address_Line1;
	
	@FindBy(xpath = "//input[@id='city']")
	private WebElement City_name;

	@FindBy(xpath = "//select[@id='id_state']")
	private WebElement State_List;
	
	@FindBy(xpath = "//input[@id='postcode']")
	private WebElement Postal_Code;
	
	@FindBy(xpath = "//select[@id='id_country']")
	private WebElement Country_List;
	
	@FindBy(xpath = "//input[@id='phone']")
	private WebElement Home_Phone;
	
	@FindBy(xpath = "//input[@id='phone_mobile']")
	private WebElement Mobile_Phone;
	
	@FindBy(xpath = "//span[normalize-space()='Register']")
	private WebElement Register_button;
	
	
	public void Enter_firstname(String Fname) {First_Name.sendKeys(Fname);}
	
	public void Enter_lastname(String Lname) {Last_Name.sendKeys(Lname);}
	
	public void Enter_password(String Pass) {Password.sendKeys(Pass);}
	
	public void Enter_Company(String Company) {Company_Name.sendKeys(Company);}
	
	public void Enter_AddressLine1(String Addr1) {Address_Line1.sendKeys(Addr1);}
	
	public void Enter_City(String City) {City_name.sendKeys(City);}
	
	public void Select_State(String State_name) {
		Select state_dropdown = new Select(State_List);
		state_dropdown.selectByVisibleText(State_name);}
	
	public void Enter_Postal_Code(String Pcode) {Postal_Code.sendKeys(Pcode);}
	
	public void Select_Country(String Country_name) {
		Select country_dropdown = new Select(Country_List);
		country_dropdown.selectByVisibleText(Country_name);}
	
	public void Enter_HomePhone(String Hphone) {Home_Phone.sendKeys(Hphone);}
	
	public void Enter_MobilePhone(String Mphone) {Mobile_Phone.sendKeys(Mphone);}
	
	public void Click_Register_button() {Register_button.click();}
	
	public void ClearFields(){
		
		First_Name.clear();
		Last_Name.clear();
		Address_Line1.clear();
		City_name.clear();
		Mobile_Phone.clear();
		Postal_Code.clear();
	}
}
