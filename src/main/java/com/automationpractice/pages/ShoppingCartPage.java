package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * @author Tushar
 * 
 *         This Page Class is created for Shopping Cart page in the application
 *         Page Factory is implemented 
 *         The weblements to be used in the selenium tests are located via xpath and stored in this class
 *		   The methods in the class are used to perform actions over the identified webelements
 */

public class ShoppingCartPage {
	
	

		public WebDriver driver;

		public ShoppingCartPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}

		@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[5]/input[2]")
		private WebElement Shoppingcart_Quantity;

		@FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]")
		private WebElement Checkout_Summary;

		@FindBy(xpath = "//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]")
		private WebElement Checkout_address;

		@FindBy(xpath = "//input[@id='cgv']")
		private WebElement Shipping_checkbox;
		
		@FindBy(xpath = "//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")
		private WebElement Checkout_Shipping;
		
		@FindBy(xpath = "//a[@title='Close']")
		private WebElement TermsofService_Alert;
		

		public void Update_Quantity(String Q) {
			Shoppingcart_Quantity.sendKeys(Q);
		}

		public void Click_CheckoutSummary() {
			Checkout_Summary.click();
		}

		public void Click_Checkoutaddress() {
			Checkout_address.click();
		}
		
		public void Select_Checkbox(){
			Shipping_checkbox.click();
		}
		
		public void Click_Checkoutshipping()
		{
			Checkout_Shipping.click();
		}
		
		public void CloseAlert()
		{
			TermsofService_Alert.click();
		}
		public void ClearQuantity()
		{
			Shoppingcart_Quantity.clear();
		}
	}





