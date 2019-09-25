package page;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NSS_ToDoPage {

	WebDriver driver;

	// Every Page must have a constructor to invite the driver
	public NSS_ToDoPage(WebDriver driver) {
		this.driver = driver;
	}

	// Element Library
	@FindBy(how = How.NAME, using = "data")
	WebElement addNewData;
	@FindBy(how = How.XPATH, using = "//input[@value='Add']")
	WebElement addButton;

	public void UserShldBeAbleToAddNewcategory() throws InterruptedException {

		Random rnd = new Random();
		int Num = rnd.nextInt(21);
		addNewData.sendKeys("Bethesda" + Num);
		addButton.click();
	}
	public String NewCategory() {
		return driver.getTitle();
	}
}

