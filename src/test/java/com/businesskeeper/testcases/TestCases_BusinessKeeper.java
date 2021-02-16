package com.businesskeeper.testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.automationpractice.pages.AuthenticationPage;
import com.automationpractice.pages.CreateAccountPage;
import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.ShoppingCartPage;

public class TestCases_BusinessKeeper {

	public WebDriver driver;
	String path = System.getProperty("user.dir");

	@BeforeClass
	public void Browsersetup() { // Setup method to launch the application before user actions are performed on the website

		System.setProperty("webdriver.chrome.driver", path + "\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");// Application URL
		driver.manage().window().maximize();
	}

	// The below test case will test all possible positive and negative scenarios for Signup functionality of the application under test

	@Test(priority = 1)
	public void SignupTest() throws IOException, InterruptedException {

		HomePage homepage_obj = new HomePage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		homepage_obj.Click_SignIn();

		AuthenticationPage auth_obj = new AuthenticationPage(driver);

		auth_obj.Enter_SignupEmail("1234");// Negative test case scenario
		auth_obj.Click_CreateAccount();
		Thread.sleep(3000);// Hard sleep used to allow distinct capture of the screenshot
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		File screenshotFile1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile1, new File(path + "\\Screenshots\\SignupValidation.png"));
		auth_obj.Clear_Field();
		auth_obj.Enter_SignupEmail("trohatgi@gmail.com");
		auth_obj.Click_CreateAccount();
		System.out.println("An account already exists with this email address");
		Thread.sleep(3000); // Hard sleep used to allow distinct capture of the screenshot
		File screenshotFile2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile2, new File(path + "\\Screenshots\\SignupValidation2.png"));
		auth_obj.Clear_Field();
		auth_obj.Enter_SignupEmail("keepty21@gmail.com");
		auth_obj.Click_CreateAccount();
	}

	// The below test case will test all possible negative scenarios for User Registration functionality of the application under test
	@Test(priority = 2)
	public void UserRegistrationNegativeTest() throws IOException, InterruptedException {

		CreateAccountPage createacc_obj = new CreateAccountPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		createacc_obj.Click_Register_button();
		System.out.println("Clicked on Register button without entering any value to generate 8 errors");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)"); // to scroll the page down
													// for the screenshot
		File screenshotFile3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile3, new File(path + "\\Screenshots\\CreateAccountValidation1.png"));

		createacc_obj.Enter_firstname("Trasd^&234"); // invalid firstname
		createacc_obj.Enter_lastname("123^&HJ"); // invalid lastname
		createacc_obj.Enter_password("1234"); // password less than 5 characters
		createacc_obj.Enter_AddressLine1("Alt-Moabit,125");
		createacc_obj.Enter_City("Berlin");
		createacc_obj.Select_State("Alaska");
		createacc_obj.Enter_Postal_Code("10557");
		createacc_obj.Select_Country("United States");
		createacc_obj.Enter_MobilePhone("015166806454");
		createacc_obj.Click_Register_button();
		System.out.println(
				"Entered invalid values for firtsname,lastname and password and clicked on Register button to generate 3 errors");
		Thread.sleep(3000); // Hard sleep used to allow distinct capture of the screenshot
		js.executeScript("window.scrollBy(0,400)");// to scroll the page down for the screenshot
		File screenshotFile4 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile4, new File(path + "\\Screenshots\\CreateAccountValidation2.png"));
	}

	// The below test case will test all possible positive scenarios for User Registration functionality of the application under test

	@Test(priority = 3)
	public void UserRegistrationPositiveTest() throws IOException, InterruptedException {

		CreateAccountPage createacc_obj2 = new CreateAccountPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		HomePage homepage_obj2 = new HomePage(driver);
		createacc_obj2.ClearFields();
		createacc_obj2.Enter_firstname("Test");
		createacc_obj2.Enter_lastname("Apps");
		createacc_obj2.Enter_password("12345");
		createacc_obj2.Enter_AddressLine1("Alt-Moabit,125");
		createacc_obj2.Enter_City("Berlin");
		createacc_obj2.Select_State("Alaska");
		createacc_obj2.Enter_Postal_Code("10557");
		createacc_obj2.Select_Country("United States");
		createacc_obj2.Enter_MobilePhone("15166806454");
		createacc_obj2.Click_Register_button();
		System.out.println("New User Registration Complete");

		System.out.println("Login is successful with username as " + homepage_obj2.Fetch_UserName());
		File screenshotFile5 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile5, new File(path + "\\Screenshots\\UserRegistration.png"));
	}

	// The below test case will test all possible positive/negative scenarios for Search Product functionality of the application under test

	@Test(priority = 4)
	public void SearchProductTest() throws IOException, InterruptedException {

		HomePage homepage_obj3 = new HomePage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		homepage_obj3.Navigate_to_HomePage();
		homepage_obj3.Click_Searchbutton();// searching with a blank search value
		System.out.println(
				"The system displays no items when we click on Search button without entering any product name in the search box");
		File screenshotFile6 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile6, new File(path + "\\Screenshots\\SearchBoxValidation1.png"));
		homepage_obj3.Enter_ProductName("TYU%^&%@^"); // invalid product name
		homepage_obj3.Click_Searchbutton();
		System.out.println(
				"The system displays no items when we click on Search button after entering an invalid product name");
		File screenshotFile7 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile7, new File(path + "\\Screenshots\\SearchBoxValidation2.png"));
		homepage_obj3.ClearSearchField();
		homepage_obj3.Enter_ProductName("Shirt");
		homepage_obj3.Click_Searchbutton();
		System.out.println("The system displays available items for a valid product name search");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)"); // to scroll the page down for the screenshot
		File screenshotFile8 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile8, new File(path + "\\Screenshots\\ValidProductSearch.png"));
	}

	// The below test case will test all possible positive/negative scenarios for Buy Product functionality of the application under test

	@Test(priority = 5)
	public void BuyProductTest() throws IOException, InterruptedException {

		HomePage homepage_obj4 = new HomePage(driver);
		ShoppingCartPage obj_shop = new ShoppingCartPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		homepage_obj4.Clickon_Product();
		homepage_obj4.ClearQuantityField();
		homepage_obj4.UpdateQuantity("0");// Negative Scenario to update quantity of product to 0
		homepage_obj4.Click_AddtoCart();
		Thread.sleep(3000); // Hard sleep used to allow distinct capture of the screenshot
		System.out.println("An alert box displayed for null value");
		File screenshotFile9 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile9, new File(path + "\\Screenshots\\NullQuantityValue.png"));
		homepage_obj4.Close_Alert();
		homepage_obj4.ClearQuantityField();
		homepage_obj4.UpdateQuantity("1");// Positive scenario
		homepage_obj4.Click_AddtoCart();
		Thread.sleep(3000); // Hard sleep used to allow distinct capture of the screenshot
		System.out.println("Add to cart pop-up window displayed confirming addition of 1 product to the shopping cart");
		File screenshotFile10 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile10, new File(path + "\\Screenshots\\AddtoCartConfirmation.png"));
		homepage_obj4.Close_AddtoCartWindow();
		homepage_obj4.Cartbutton_click();
		js.executeScript("window.scrollBy(0,300)");
		obj_shop.ClearQuantity();
		obj_shop.Update_Quantity("1000000000");// Negative Scenario to update quantity to an extremely large value
		Thread.sleep(3000); // Hard sleep used to allow distinct capture of the screenshot
		System.out.println("The system accepts an unrealistic large value of quantity");
		File screenshotFile11 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile11, new File(path + "\\Screenshots\\LargeQuantityValue.png"));
		obj_shop.Click_CheckoutSummary();
		obj_shop.Click_Checkoutaddress();
		obj_shop.Click_Checkoutshipping();// Negative Scenario of clicking on Proceed to Checkout without accepting the terms of service should pop-up an alert
		System.out.println("Terms of service pop-up");
		Thread.sleep(3000); // Hard sleep used to allow distinct capture of the screenshot
		obj_shop.CloseAlert();
		File screenshotFile12 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile12, new File(path + "\\Screenshots\\TermsOfService_popup.png"));
		obj_shop.Select_Checkbox();
		obj_shop.Click_Checkoutshipping();
		js.executeScript("window.scrollBy(0,300)"); // to scroll the page down for the screenshot
		Thread.sleep(3000); // Hard sleep used to allow distinct capture of the screenshot
		System.out.println("Final payment page is displayed");
		File screenshotFile13 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile13, new File(path + "\\Screenshots\\FinalPaymentpage.png"));
	}

	@AfterClass
	public void CloseBrowser() {
		driver.quit();// TearDown method to close the browser after all user actions are performed on the website
	}
}
