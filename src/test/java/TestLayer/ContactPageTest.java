package TestLayer;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseLayer.BaseClass;
import UtilityLayer.ExcelReader;

public class ContactPageTest extends BaseClass {

	@Test(priority = 4, dataProvider = "getContactData")
	public void validateNewContactFunctionality(String fname, String lname, String mname, String email, String status)
			throws InterruptedException {
		WebElement wb = getDriver().findElement(By.xpath("//a[@href='/contacts']"));
		Actions act = new Actions(getDriver());
		Thread.sleep(5000);
		act.moveToElement(wb).click(wb).build().perform();

		getDriver().findElement(By.xpath("//a[@href='/contacts/new']")).click();

		getDriver().findElement(By.name("first_name")).sendKeys(fname);
		getDriver().findElement(By.name("last_name")).sendKeys(lname);
		getDriver().findElement(By.name("middle_name")).sendKeys(mname);
		getDriver().findElement(By.name("value")).sendKeys(email);

		getDriver().findElement(By.name("status")).click();

		List<WebElement> ls = getDriver().findElements(By.xpath("//div[@name='status']/span"));

		for (WebElement abc : ls) {
			String a = abc.getText();
			if (a.equalsIgnoreCase(status)) {
				abc.click();
				break;
			}
		}

		Thread.sleep(5000);
		getDriver().findElement(By.xpath("//button[text()='Save']")).click();
	}

	@DataProvider
	public Object[][] getContactData() throws IOException {
		ExcelReader obj = new ExcelReader(
				System.getProperty("user.dir") + "\\src\\main\\java\\TestData\\Cogmento CRM test Data.xlsx");

		Object[][] data = obj.getAllSheetData(0);

		return data;

	}

}
