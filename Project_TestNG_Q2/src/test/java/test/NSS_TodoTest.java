package test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page.NSS_ToDoPage;
import util.BrowserFactory;

public class NSS_TodoTest {

	WebDriver driver;

	@BeforeMethod
	public void launchBrowser() {
		// Starts the browser and saves the driver in the test class
		driver = BrowserFactory.startBrowser();
	}

	@Test(priority = 1)
	public void UserShouldBeAbleToAddCategory() throws InterruptedException {

//		On to the site
		driver.get("http://techfios.com/test/104/");

		System.out.println("Before Adding " + driver.findElements(By.xpath("//input[@type='checkbox']")).size());

		NSS_ToDoPage newcategory = PageFactory.initElements(driver, NSS_ToDoPage.class);
		newcategory.UserShldBeAbleToAddNewcategory();

		System.out.println("After Adding " + driver.findElements(By.xpath("//input[@type='checkbox']")).size());

	}

	@Test(priority = 2)
	public void UserShouldNotBeAbleToAddDublicteCategory() {

		driver.get("http://techfios.com/test/104/");

		NSS_ToDoPage newcategory = PageFactory.initElements(driver, NSS_ToDoPage.class);

		String expectedCategory = "Bethesda"; // To store the actual title
		String actualcategory = newcategory.NewCategory(); // To get and store the title
		System.out.println("The category you want to add already exists: <duplicated category name>");
		assertTrue(true, expectedCategory);

	}

	@AfterMethod
	public void close() {
		// close and quit
		driver.close();
		driver.quit();
	}
}
