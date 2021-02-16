package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Tushar
 * 
 *         This Page Class is created for Authetication page in the application
 *         Page Factory is implemented The weblements to be used in the selenium
 *         tests are located via xpath and stored in this class.The methods in
 *         the class are used to perform actions over the identified webelements
 */

public class AuthenticationPage {

	public WebDriver driver;

	public AuthenticationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='email_create']")
	private WebElement Email_SignUp;

	@FindBy(xpath = "//form[1]/div[1]/div[3]/button[1]/span[1]")
	private WebElement CreateAccount_button;

	@FindBy(xpath = "//input[@id='email']")
	private WebElement Email_SignIn;

	@FindBy(xpath = "//input[@id='passwd']")
	private WebElement Password_SignIn;

	@FindBy(xpath = "//form[1]/div[1]/p[2]/button[1]/span[1]")
	private WebElement SignIn_button;

	public void Enter_SignupEmail(String Email) {
		Email_SignUp.sendKeys(Email);
	}

	public void Click_CreateAccount() {
		CreateAccount_button.click();
	}

	public void Clear_Field() {
		Email_SignUp.clear();
	}
}
